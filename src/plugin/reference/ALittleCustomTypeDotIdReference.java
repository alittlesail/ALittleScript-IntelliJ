package plugin.reference;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import plugin.psi.ALittleCustomType;
import plugin.psi.ALittleCustomTypeDotId;
import plugin.psi.ALittleCustomTypeDotIdName;
import plugin.psi.ALittleCustomTypeName;

public class ALittleCustomTypeDotIdReference extends ALittleCustomTypeCommonReference<ALittleCustomTypeDotId> {
   public ALittleCustomTypeDotIdReference(@NotNull ALittleCustomTypeDotId element, TextRange textRange) {
        super((ALittleCustomType)element.getParent().getParent(), element, textRange);

       ALittleCustomType custom_type = (ALittleCustomType)element.getParent();
       ALittleCustomTypeName custom_type_name = custom_type.getCustomTypeName();
       if (custom_type_name != null)
           mNamespace = custom_type_name.getText();
       else
           mNamespace = "";
       mKey = myElement.getText();
    }
}
