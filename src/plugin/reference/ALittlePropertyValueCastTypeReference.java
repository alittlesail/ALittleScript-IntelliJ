package plugin.reference;

import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import plugin.guess.ALittleGuess;
import plugin.guess.ALittleGuessException;
import plugin.psi.ALittlePropertyValueCastType;

import java.util.List;

public class ALittlePropertyValueCastTypeReference extends ALittleReference<ALittlePropertyValueCastType> {
    public ALittlePropertyValueCastTypeReference(@NotNull ALittlePropertyValueCastType element, TextRange textRange) {
        super(element, textRange);
    }

    @NotNull
    @Override
    public List<ALittleGuess> guessTypes() throws ALittleGuessException {
        if (myElement.getAllType() != null) {
            return myElement.getAllType().guessTypes();
        }
        throw new ALittleGuessException(myElement, "ALittlePropertyValueCastType出现未知的子节点");
    }

    @Override
    public void checkError() throws ALittleGuessException {
        List<ALittleGuess> guessList = myElement.guessTypes();
        if (guessList.isEmpty()) {
            throw new ALittleGuessException(myElement, "未知类型");
        } else if (guessList.size() != 1) {
            throw new ALittleGuessException(myElement, "重复定义");
        }
    }
}
