package plugin.reference;

import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import plugin.psi.*;

import java.util.ArrayList;
import java.util.List;

public class ALittleOpAssignExprReference extends ALittleReference<ALittleOpAssignExpr> {
    public ALittleOpAssignExprReference(@NotNull ALittleOpAssignExpr element, TextRange textRange) {
        super(element, textRange);
    }

    @NotNull
    public List<ALittleGuess> guessTypes() throws ALittleGuessException {
        return new ArrayList<>();
    }

    public void checkError() throws ALittleGuessException {
        ALittleValueStat valueStat = myElement.getValueStat();
        if (valueStat == null) return;

        List<ALittlePropertyValue> propertyValueList = myElement.getPropertyValueList();
        if (propertyValueList.isEmpty()) {
            return;
        }

        // 如果返回值只有一个函数调用
        if (propertyValueList.size() > 1) {
            // 获取右边表达式的
            List<ALittleGuess> methodCallGuessList = valueStat.guessTypes();
            if (methodCallGuessList.isEmpty()) {
                throw new ALittleGuessException(valueStat, "调用的函数没有返回值");
            }
            if (methodCallGuessList.size() < propertyValueList.size()) {
                throw new ALittleGuessException(valueStat, "调用的函数返回值数量少于定义的变量数量");
            }

            for (int i = 0; i < propertyValueList.size(); ++i) {
                ALittlePropertyValue pairDec = propertyValueList.get(i);
                try {
                    ALittleReferenceOpUtil.guessTypeEqual(pairDec, pairDec.guessType(), valueStat, methodCallGuessList.get(i));
                } catch (ALittleGuessException e) {
                    throw new ALittleGuessException(valueStat, "等号左边的第" + (i + 1) + "个变量数量和函数定义的返回值类型不相等:" + e.getError());
                }
            }

            return;
        }

        ALittleOpAssign opAssign = myElement.getOpAssign();
        if (opAssign == null)
            throw new ALittleGuessException(myElement, "没有赋值符号");
        String opString = opAssign.getText();

        ALittleGuess pairGuessType = propertyValueList.get(0).guessType();
        ALittleGuess valueGuessType = valueStat.guessType();

        if (opString.equals("=")) {
            try {
                ALittleReferenceOpUtil.guessTypeEqual(propertyValueList.get(0), pairGuessType, valueStat, valueGuessType);
            } catch (ALittleGuessException e) {
                throw new ALittleGuessException(e.getElement(), "等号左边的变量和表达式的类型不同:" + e.getError());
            }
        } else {
            if (!pairGuessType.value.equals("int") && !pairGuessType.value.equals("double") && !pairGuessType.value.equals("I64"))
                throw new ALittleGuessException(propertyValueList.get(0), opString + "左边必须是int, double, I64");

            if (!valueGuessType.value.equals("int") && !valueGuessType.value.equals("double") && !valueGuessType.value.equals("I64"))
                throw new ALittleGuessException(valueStat, opString + "右边必须是int, double, I64");
        }
    }
}
