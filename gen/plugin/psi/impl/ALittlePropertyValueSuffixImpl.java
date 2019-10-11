// This is a generated file. Not intended for manual editing.
package plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static plugin.psi.ALittleTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import plugin.psi.*;
import com.intellij.psi.PsiReference;
import plugin.guess.ALittleGuess;
import plugin.guess.ALittleGuessException;

public class ALittlePropertyValueSuffixImpl extends ASTWrapperPsiElement implements ALittlePropertyValueSuffix {

  public ALittlePropertyValueSuffixImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ALittleVisitor visitor) {
    visitor.visitPropertyValueSuffix(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ALittleVisitor) accept((ALittleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ALittlePropertyValueBracketValue getPropertyValueBracketValue() {
    return findChildByClass(ALittlePropertyValueBracketValue.class);
  }

  @Override
  @Nullable
  public ALittlePropertyValueDotId getPropertyValueDotId() {
    return findChildByClass(ALittlePropertyValueDotId.class);
  }

  @Override
  @Nullable
  public ALittlePropertyValueMethodCall getPropertyValueMethodCall() {
    return findChildByClass(ALittlePropertyValueMethodCall.class);
  }

  @Override
  @NotNull
  public ALittleGuess guessType() throws ALittleGuessException {
    return ALittlePsiImplUtil.guessType(this);
  }

  @Override
  @NotNull
  public List<ALittleGuess> guessTypes() throws ALittleGuessException {
    return ALittlePsiImplUtil.guessTypes(this);
  }

  @Override
  public PsiReference getReference() {
    return ALittlePsiImplUtil.getReference(this);
  }

}
