// This is a generated file. Not intended for manual editing.
package plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import plugin.guess.ALittleGuess;
import plugin.guess.ALittleGuessException;

public interface ALittleOp6SuffixEx extends PsiElement {

  @Nullable
  ALittleOp6Suffix getOp6Suffix();

  @Nullable
  ALittleOp7Suffix getOp7Suffix();

  @Nullable
  ALittleOp8Suffix getOp8Suffix();

  @NotNull
  ALittleGuess guessType() throws ALittleGuessException;

  @NotNull
  List<ALittleGuess> guessTypes() throws ALittleGuessException;

  PsiReference getReference();

}
