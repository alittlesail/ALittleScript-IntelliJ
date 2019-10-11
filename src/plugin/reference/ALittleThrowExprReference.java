package plugin.reference;

import com.intellij.codeInsight.hints.InlayInfo;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import plugin.guess.ALittleGuess;
import plugin.guess.ALittleGuessException;
import plugin.psi.ALittleNsendExpr;
import plugin.psi.ALittleThrowExpr;
import plugin.psi.ALittleValueStat;

import java.util.ArrayList;
import java.util.List;

public class ALittleThrowExprReference extends ALittleReference<ALittleThrowExpr> {
    public ALittleThrowExprReference(@NotNull ALittleThrowExpr element, TextRange textRange) {
        super(element, textRange);
    }

    @NotNull
    public List<ALittleGuess> guessTypes() throws ALittleGuessException {
        List<ALittleValueStat> valueStatList = myElement.getValueStatList();
        if (valueStatList.isEmpty()) {
            throw new ALittleGuessException(myElement, "throw表达式不能没有参数");
        }

        if (valueStatList.size() != 1)
            throw new ALittleGuessException(myElement, "throw只有string一个参数");

        ALittleValueStat valueStat = valueStatList.get(0);
        ALittleGuess guessInfo = valueStat.guessType();
        if (!guessInfo.value.equals("string")) {
            throw new ALittleGuessException(valueStat, "throw表达式第一个参数必须是string类型");
        }

        return new ArrayList<>();
    }

    public void checkError() throws ALittleGuessException {
        List<ALittleValueStat> valueStatList = myElement.getValueStatList();
        if (valueStatList.isEmpty()) {
            throw new ALittleGuessException(myElement, "throw表达式不能没有参数");
        }

        if (valueStatList.size() != 1)
            throw new ALittleGuessException(myElement, "throw只有string一个参数");

        ALittleValueStat valueStat = valueStatList.get(0);
        ALittleGuess guessInfo = valueStat.guessType();
        if (!guessInfo.value.equals("string")) {
            throw new ALittleGuessException(valueStat, "throw表达式第一个参数必须是string类型");
        }
    }

    @NotNull
    public List<InlayInfo> getParameterHints() throws ALittleGuessException {
        List<InlayInfo> result = new ArrayList<>();
        List<ALittleValueStat> valueStatList = myElement.getValueStatList();
        if (valueStatList.isEmpty()) {
            throw new ALittleGuessException(myElement, "throw表达式不能没有参数");
        }

        if (valueStatList.size() != 1)
            throw new ALittleGuessException(myElement, "throw只有string一个参数");

        // 构建对象
        for (int i = 0; i < valueStatList.size(); ++i) {
            ALittleValueStat valueStat = valueStatList.get(i);
            result.add(new InlayInfo("error", valueStat.getNode().getStartOffset()));
        }
        return result;
    }
}
