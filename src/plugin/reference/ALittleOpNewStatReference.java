package plugin.reference;

import com.intellij.codeInsight.hints.InlayInfo;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import plugin.guess.*;
import plugin.psi.*;

import java.util.ArrayList;
import java.util.List;

public class ALittleOpNewStatReference extends ALittleReference<ALittleOpNewStat> {
    public ALittleOpNewStatReference(@NotNull ALittleOpNewStat element, TextRange textRange) {
        super(element, textRange);
    }

    @NotNull
    public List<ALittleGuess> guessTypes() throws ALittleGuessException {
        if (myElement.getCustomType() != null) {
            return myElement.getCustomType().guessTypes();
        } else if (myElement.getGenericType() != null) {
            return myElement.getGenericType().guessTypes();
        }
        throw new ALittleGuessException(myElement, "ALittleOpNewStat出现未知的子节点");
    }

    public void checkError() throws ALittleGuessException {
        List<ALittleValueStat> valueStatList = myElement.getValueStatList();

        if (myElement.getGenericType() != null) {
            if (valueStatList.size() > 0) {
                throw new ALittleGuessException(myElement, "创建容器实例对象不能有参数");
            }
            return;
        }

        if (myElement.getCustomType() != null) {
            ALittleCustomType customType = myElement.getCustomType();
            ALittleGuess guess = customType.guessType();
            if (guess instanceof ALittleGuessStruct) {
                if (valueStatList.size() > 0) {
                    throw new ALittleGuessException(myElement, "new的结构体不能有参数");
                }
                return;
            }

            if (guess instanceof ALittleGuessClassTemplate) {
                ALittleGuessClassTemplate guessClassTemplate = (ALittleGuessClassTemplate)guess;
                if (guessClassTemplate.templateExtends != null) {
                    guess = guessClassTemplate.templateExtends;
                } else if (guessClassTemplate.isStruct) {
                    if (valueStatList.size() > 0) {
                        throw new ALittleGuessException(myElement, "new的结构体不能有参数");
                    }
                    return;
                } else if (guessClassTemplate.isClass) {
                    throw new ALittleGuessException(myElement, "如果要new改模板类型，请不要使用class，无法确定它的构造函数参数");
                }
            }

            if (guess instanceof ALittleGuessClass) {
                ALittleClassDec classDec = ((ALittleGuessClass)guess).element;
                List<ALittleClassCtorDec> ctorDecList = classDec.getClassCtorDecList();
                if (ctorDecList.size() > 1) {
                    throw new ALittleGuessException(myElement, "new的类的构造函数个数不能超过1个");
                }

                if (ctorDecList.size() == 0) {
                    if (valueStatList.size() > 0) {
                        throw new ALittleGuessException(myElement, "new的类的构造函数没有参数");
                    }
                    return;
                }

                ALittleMethodParamDec param_dec = ctorDecList.get(0).getMethodParamDec();
                if (param_dec == null) {
                    if (valueStatList.size() > 0) {
                        throw new ALittleGuessException(myElement, "new的类的构造函数没有参数");
                    }
                    return;
                }

                List<ALittleMethodParamOneDec> param_oneDecList = param_dec.getMethodParamOneDecList();
                List<ALittleGuess> param_type_list = new ArrayList<>();
                for (ALittleMethodParamOneDec param_one_dec : param_oneDecList) {
                    param_type_list.add(param_one_dec.getAllType().guessType());
                }

                if (param_type_list.size() != valueStatList.size()) {
                    throw new ALittleGuessException(myElement, "new的类的构造函数调用需要" + param_type_list.size() + "个参数,不能是:" + valueStatList.size() + "个");
                }

                for (int i = 0; i < valueStatList.size(); ++i) {
                    ALittleValueStat valueStat = valueStatList.get(i);
                    try {
                        ALittleReferenceOpUtil.guessTypeEqual(param_type_list.get(i), valueStat, valueStat.guessType());
                    } catch (ALittleGuessException e) {
                        throw new ALittleGuessException(valueStat, "第" + (i + 1) + "个参数类型和函数定义的参数类型不同:" + e.getError());
                    }
                }
                return;
            }

            throw new ALittleGuessException(myElement, "只能new结构体和类");
        }
    }

    @NotNull
    public List<InlayInfo> getParameterHints() throws ALittleGuessException {
        List<InlayInfo> result = new ArrayList<>();

        List<ALittleValueStat> valueStatList = myElement.getValueStatList();

        ALittleCustomType customType = myElement.getCustomType();
        if (customType == null) return result;

        ALittleGuess guess = customType.guessType();

        if (guess instanceof ALittleGuessClassTemplate) {
            ALittleGuessClassTemplate guessClassTemplate = (ALittleGuessClassTemplate)guess;
            if (guessClassTemplate.templateExtends != null) {
                guess = guessClassTemplate.templateExtends;
            }
        }

        if (guess instanceof ALittleGuessClass) {
            ALittleClassDec classDec = ((ALittleGuessClass) guess).element;
            List<ALittleClassCtorDec> ctorDecList = classDec.getClassCtorDecList();
            if (ctorDecList.size() < 1) {
                return result;
            }

            ALittleMethodParamDec paramDec = ctorDecList.get(0).getMethodParamDec();
            if (paramDec == null) {
                return result;
            }

            List<ALittleMethodParamOneDec> paramOneDecList = paramDec.getMethodParamOneDecList();
            if (paramOneDecList.isEmpty()) {
                return result;
            }

            for (int i = 0; i < paramOneDecList.size(); ++i) {
                ALittleMethodParamOneDec paramOneDec = paramOneDecList.get(i);
                if (paramOneDec.getMethodParamNameDec() == null) {
                    return result;
                }
                if (i >= valueStatList.size()) {
                    return result;
                }
                String name = paramOneDec.getMethodParamNameDec().getText();
                // 参数占位符直接跳过
                if (name.equals("...")) continue;
                ALittleValueStat valueStat = valueStatList.get(i);
                String valueName = valueStat.getText();
                if (name.equals(valueName)) continue;
                result.add(new InlayInfo(name, valueStat.getNode().getStartOffset()));
            }
        }
        return result;
    }
}
