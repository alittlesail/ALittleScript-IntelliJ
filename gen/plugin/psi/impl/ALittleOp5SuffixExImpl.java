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

public class ALittleOp5SuffixExImpl extends ASTWrapperPsiElement implements ALittleOp5SuffixEx {

  public ALittleOp5SuffixExImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ALittleVisitor visitor) {
    visitor.visitOp5SuffixEx(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ALittleVisitor) accept((ALittleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ALittleOp5Suffix getOp5Suffix() {
    return findChildByClass(ALittleOp5Suffix.class);
  }

  @Override
  @Nullable
  public ALittleOp6Suffix getOp6Suffix() {
    return findChildByClass(ALittleOp6Suffix.class);
  }

  @Override
  @Nullable
  public ALittleOp7Suffix getOp7Suffix() {
    return findChildByClass(ALittleOp7Suffix.class);
  }

  @Override
  @Nullable
  public ALittleOp8Suffix getOp8Suffix() {
    return findChildByClass(ALittleOp8Suffix.class);
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
