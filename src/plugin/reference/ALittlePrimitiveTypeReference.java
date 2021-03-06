package plugin.reference;

import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import plugin.guess.ALittleGuess;
import plugin.guess.ALittleGuessException;
import plugin.guess.ALittleGuessPrimitive;
import plugin.psi.ALittlePrimitiveType;

import java.util.ArrayList;
import java.util.List;

public class ALittlePrimitiveTypeReference extends ALittleReference<ALittlePrimitiveType> {
    public ALittlePrimitiveTypeReference(@NotNull ALittlePrimitiveType element, TextRange textRange) {
        super(element, textRange);
    }

    @NotNull
    @Override
    public List<ALittleGuess> guessTypes() throws ALittleGuessException {
        String value = myElement.getText();
        List<ALittleGuess> guessTypeList = ALittleGuessPrimitive.sPrimitiveGuessListMap.get(value);
        if (guessTypeList == null) guessTypeList = new ArrayList<>();
        return guessTypeList;
    }
}
