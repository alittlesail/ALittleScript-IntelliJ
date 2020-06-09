package plugin.component;

import com.intellij.lang.annotation.*;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import plugin.guess.ALittleGuessException;
import plugin.reference.ALittleReferenceInterface;

public class ALittleAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        try {
            // 检查错误，给元素上色
            PsiReference ref = element.getReference();
            if (ref instanceof ALittleReferenceInterface) {
                ((ALittleReferenceInterface) ref).checkError();
                ((ALittleReferenceInterface) ref).colorAnnotator(holder);
            }
        } catch (ALittleGuessException e) {
            // if (e.getElement() != null && holder.getCurrentAnnotationSession().getFile().equals(e.getElement().getContainingFile())) {
            //     holder.newAnnotation(HighlightSeverity.ERROR, e.getError()).range(e.getElement()).create();
            // }
        }
    }
}