package plugin.format;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import org.jetbrains.annotations.NotNull;
import plugin.filetype.ALittleFileType;

public class ALittleTypedHandler extends TypedHandlerDelegate {

    @NotNull
    @Override
    public TypedHandlerDelegate.Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        if (file.getFileType() == ALittleFileType.INSTANCE) {
            if (c == '{' || c == '}') {
                int offset = editor.getCaretModel().getOffset();
                if (offset > 0) {
                    if (c == '{') {
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    }
                    CodeStyleManager style_mgr = CodeStyleManager.getInstance(project);
                    PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());
                    style_mgr.adjustLineIndent(file, new TextRange(offset - 1, offset));
                    return Result.STOP;
                }
            } else if (c == '(') {
                int offset = editor.getCaretModel().getOffset();
                if (offset > 0) {
                    String nextChar = null;
                    if (offset + 1 < editor.getDocument().getTextLength())
                        nextChar = editor.getDocument().getText(new TextRange(offset, offset + 1));
                    if (nextChar == null || nextChar.equals("\n") || nextChar.equals(";") || nextChar.equals("]")) {
                        editor.getDocument().insertString(offset, ")");
                        editor.getCaretModel().moveToOffset(offset);
                        return Result.STOP;
                    }
                }
            } else if (c == '"') {
                int offset = editor.getCaretModel().getOffset();
                if (offset > 0) {
                    editor.getDocument().insertString(offset, "\"");
                    editor.getCaretModel().moveToOffset(offset);
                    return Result.STOP;
                }
            } else if (c == '[') {
                int offset = editor.getCaretModel().getOffset();
                if (offset > 0) {
                    editor.getDocument().insertString(offset, "]");
                    editor.getCaretModel().moveToOffset(offset);
                    return Result.STOP;
                }
            } else if (c == ';') {
                int offset = editor.getCaretModel().getOffset();
                int lineStartOffset = editor.getCaretModel().getVisualLineStart();
                if (offset > 0) {
                    CodeStyleManager style_mgr = CodeStyleManager.getInstance(project);
                    PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());
                    style_mgr.adjustLineIndent(file, lineStartOffset);
                    return Result.STOP;
                }
            }
        }
        return super.charTyped(c, project, editor, file);
    }

    @NotNull
    @Override
    public TypedHandlerDelegate.Result beforeCharTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file, @NotNull FileType fileType) {
        if (file.getFileType() == ALittleFileType.INSTANCE) {
            if (c == '}') {
                int offset = editor.getCaretModel().getOffset();
                if (offset > 0) {
                    String nextChar = null;
                    if (offset + 1 < editor.getDocument().getTextLength())
                        nextChar = editor.getDocument().getText(new TextRange(offset, offset + 1));
                    if (nextChar != null && nextChar.equals("}")) {
                        editor.getCaretModel().moveToOffset(offset + 1);
                        return Result.STOP;
                    }
                }
            } else if (c == ')') {
                int offset = editor.getCaretModel().getOffset();
                if (offset > 0) {
                    String nextChar = null;
                    if (offset + 1 < editor.getDocument().getTextLength())
                        nextChar = editor.getDocument().getText(new TextRange(offset, offset + 1));
                    if (nextChar != null && nextChar.equals(")")) {
                        editor.getCaretModel().moveToOffset(offset + 1);
                        return Result.STOP;
                    }
                }
            } else if (c == ']') {
                int offset = editor.getCaretModel().getOffset();
                if (offset > 0) {
                    String nextChar = null;
                    if (offset + 1 < editor.getDocument().getTextLength())
                        nextChar = editor.getDocument().getText(new TextRange(offset, offset + 1));
                    if (nextChar != null && nextChar.equals("]")) {
                        editor.getCaretModel().moveToOffset(offset + 1);
                        return Result.STOP;
                    }
                }
            } else if (c == '"') {
                int offset = editor.getCaretModel().getOffset();
                if (offset > 0) {
                    String nextChar = null;
                    if (offset + 1 < editor.getDocument().getTextLength())
                        nextChar = editor.getDocument().getText(new TextRange(offset, offset + 1));
                    if (nextChar != null && nextChar.equals("\"")) {
                        editor.getCaretModel().moveToOffset(offset + 1);
                        return Result.STOP;
                    }
                }
            }
        }
        return super.beforeCharTyped(c, project, editor, file, fileType);
    }
}
