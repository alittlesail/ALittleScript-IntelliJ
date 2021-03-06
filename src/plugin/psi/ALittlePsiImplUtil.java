package plugin.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import plugin.guess.ALittleGuess;
import plugin.guess.ALittleGuessException;
import plugin.index.ALittleTreeChangeListener;
import plugin.reference.ALittleReferenceInterface;
import plugin.reference.ALittleReferenceOpUtil;

import java.util.List;

public class ALittlePsiImplUtil {
    public static PsiReference getReference(PsiElement element) {
        return ALittleReferenceOpUtil.create(element);
    }

    @NotNull
    public static ALittleGuess guessType(PsiElement element) throws ALittleGuessException {
        List<ALittleGuess> guessList = guessTypes(element);
        if (guessList.isEmpty()) {
            throw new ALittleGuessException(element, "无法计算出该元素属于什么类型");
        }
        return guessList.get(0);
    }

    @NotNull
    public static List<ALittleGuess> guessTypes(PsiElement element) throws ALittleGuessException {
        List<ALittleGuess> guessList = ALittleTreeChangeListener.getGuessTypeList(element);
        if (guessList != null && !guessList.isEmpty()) {
            boolean isChanged = false;
            for (ALittleGuess guess : guessList) {
                if (guess.isChanged()) {
                    isChanged = true;
                    break;
                }
            }
            if (!isChanged) return guessList;
        }

        ALittleReferenceInterface ref = ALittleReferenceOpUtil.create(element);
        if (ref == null) {
            throw new ALittleGuessException(element, "ALittleReference对象创建失败 element:" + element);
        }
        guessList = ref.guessTypes();

        // 如果是两个，并且一个是register，一个不是。那么就要把register那个删掉
        if (!ref.multiGuessTypes() && guessList.size() == 2 && guessList.get(0).getValue().equals(guessList.get(1).getValue())) {
            if (guessList.get(0).is_register && !guessList.get(1).is_register) {
                guessList.remove(0);
            } else if (!guessList.get(0).is_register && guessList.get(1).is_register) {
                guessList.remove(1);
            }
        }

        ALittleTreeChangeListener.putGuessTypeList(element, guessList);
        return guessList;
    }
}
