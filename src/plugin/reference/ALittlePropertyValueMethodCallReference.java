package plugin.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.ALittleIcons;
import plugin.ALittleUtil;
import plugin.psi.*;

import java.util.ArrayList;
import java.util.List;

public class ALittlePropertyValueMethodCallReference extends ALittleReference<ALittlePropertyValueMethodCall> {
    public ALittlePropertyValueMethodCallReference(@NotNull ALittlePropertyValueMethodCall element, TextRange textRange) {
        super(element, textRange);
    }

    @NotNull
    public List<ALittleReferenceUtil.GuessTypeInfo> guessTypes() throws ALittleReferenceUtil.ALittleReferenceException {
        List<ALittleReferenceUtil.GuessTypeInfo> guessList = new ArrayList<>();

        // 获取父节点
        ALittlePropertyValueSuffix propertyValueSuffix = (ALittlePropertyValueSuffix)myElement.getParent();
        ALittlePropertyValue propertyValue = (ALittlePropertyValue)propertyValueSuffix.getParent();
        ALittlePropertyValueFirstType propertyValueFirstType = propertyValue.getPropertyValueFirstType();
        List<ALittlePropertyValueSuffix> suffixList = propertyValue.getPropertyValueSuffixList();

        // 获取所在位置
        int index = suffixList.indexOf(propertyValueSuffix);
        if (index == -1) return guessList;

        // 获取前一个类型
        ALittleReferenceUtil.GuessTypeInfo preType;
        if (index == 0) {
            preType = propertyValueFirstType.guessType();
        } else {
            preType = suffixList.get(index - 1).guessType();
        }

        if (preType.type == ALittleReferenceUtil.GuessType.GT_FUNCTOR) {
            for (ALittleReferenceUtil.GuessTypeInfo info : preType.functorReturnList) {
                if (info.functorAwait) {
                    ALittleReferenceUtil.GuessTypeInfo copy = ALittleReferenceUtil.DeepCopyGuessTypeInfo(info);
                    copy.callAwait = true;
                    guessList.add(copy);
                } else {
                    guessList.add(info);
                }
            }
        }

        return guessList;
    }

    public void checkError() throws ALittleReferenceUtil.ALittleReferenceException {
        // 获取父节点
        ALittlePropertyValueSuffix propertyValueSuffix = (ALittlePropertyValueSuffix)myElement.getParent();
        ALittlePropertyValue propertyValue = (ALittlePropertyValue)propertyValueSuffix.getParent();
        ALittlePropertyValueFirstType propertyValueFirstType = propertyValue.getPropertyValueFirstType();
        List<ALittlePropertyValueSuffix> suffixList = propertyValue.getPropertyValueSuffixList();

        // 获取所在位置
        int index = suffixList.indexOf(propertyValueSuffix);
        if (index == -1) return;

        // 获取前一个类型
        ALittleReferenceUtil.GuessTypeInfo preType;
        if (index == 0) {
            preType = propertyValueFirstType.guessType();
        } else {
            preType = suffixList.get(index - 1).guessType();
        }

        // 如果需要处理
        if (preType.type == ALittleReferenceUtil.GuessType.GT_FUNCTOR) {
            List<ALittleValueStat> valueStatList = myElement.getValueStatList();
            if (preType.functorParamList.size() < valueStatList.size()) {
                throw new ALittleReferenceUtil.ALittleReferenceException(myElement, "函数调用最多需要" + preType.functorParamList.size() + "个参数,不能是:" + valueStatList.size() + "个");
            }

            for (int i = 0; i < valueStatList.size(); ++i) {
                ALittleReferenceUtil.GuessTypeInfo guessTypeInfo = valueStatList.get(i).guessType();
                try {
                    boolean result = ALittleReferenceOpUtil.guessTypeEqual(myElement, preType.functorParamList.get(i), valueStatList.get(i), guessTypeInfo);
                    if (!result) {
                        throw new ALittleReferenceUtil.ALittleReferenceException(valueStatList.get(i), "第" + (i + 1) + "个参数类型和函数定义的参数类型不同");
                    }
                } catch (ALittleReferenceUtil.ALittleReferenceException e) {
                    throw new ALittleReferenceUtil.ALittleReferenceException(e.getElement(), "第" + (i + 1) + "个参数类型和函数定义的参数类型不同:" + e.getError());
                }
            }
        }
    }
}
