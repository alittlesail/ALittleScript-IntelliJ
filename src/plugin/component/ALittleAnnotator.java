package plugin.component;

import com.intellij.lang.annotation.*;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import plugin.reference.ALittleReferenceInterface;
import plugin.reference.ALittleReferenceUtil;

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
        } catch (ALittleReferenceUtil.ALittleReferenceException e) {
            holder.createErrorAnnotation(e.getElement(), e.getError());
        }
    }
}