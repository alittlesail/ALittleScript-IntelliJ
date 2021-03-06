package plugin.hightlight;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import plugin.component.ALittleLanguage;
import plugin.component.ALittleLexerAdapter;
import plugin.parser.ALittleParser;
import plugin.psi.ALittleFile;
import plugin.psi.ALittleTypes;

public class ALittleParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(ALittleLanguage.INSTANCE);

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENT_SET = TokenSet.create(ALittleTypes.LINE_COMMENT, ALittleTypes.BLOCK_COMMENT);
    public static final TokenSet STRING_CONTENT_SET = TokenSet.create(ALittleTypes.TEXT_CONTENT);
    public static final TokenSet NUMBER_CONTENT_SET = TokenSet.create(ALittleTypes.NUMBER_CONTENT);
    public static final TokenSet BAD_CHARACTER_SET = TokenSet.create(TokenType.BAD_CHARACTER);

    public static final TokenSet KEYWORD_SET = TokenSet.create(ALittleTypes.CAST, ALittleTypes.REFLECT, ALittleTypes.VAR,
            ALittleTypes.ANY, ALittleTypes.INT, ALittleTypes.LONG, ALittleTypes.DOUBLE, ALittleTypes.STRING, ALittleTypes.BOOL,
            ALittleTypes.CLASS, ALittleTypes.ENUM, ALittleTypes.STRUCT, ALittleTypes.ASSERT, ALittleTypes.THROW, ALittleTypes.TCALL,
            ALittleTypes.PUBLIC, ALittleTypes.PRIVATE, ALittleTypes.PROTECTED, ALittleTypes.STATIC, ALittleTypes.USING,
            ALittleTypes.BREAK, ALittleTypes.CONTINUE, ALittleTypes.CTOR, ALittleTypes.YIELD, ALittleTypes.ASYNC, ALittleTypes.AWAIT, ALittleTypes.BIND,
            ALittleTypes.IF, ALittleTypes.ELSE, ALittleTypes.ELSEIF, ALittleTypes.DO, ALittleTypes.WHILE, ALittleTypes.FOR,
            ALittleTypes.IN, ALittleTypes.LIST, ALittleTypes.MAP, ALittleTypes.TYPE_TAIL, ALittleTypes.CONCAT, ALittleTypes.PATHS,
            ALittleTypes.NEW, ALittleTypes.RETURN, ALittleTypes.REGISTER, ALittleTypes.NAMESPACE, ALittleTypes.THIS, ALittleTypes.FUNCTOR,
            ALittleTypes.GET, ALittleTypes.SET, ALittleTypes.FUN, ALittleTypes.COMMA, ALittleTypes.CONST);

    public static final TokenSet SYMBOL_SET = TokenSet.create(ALittleTypes.APOS, ALittleTypes.ASSIGN, ALittleTypes.BACK,
            ALittleTypes.COLON, ALittleTypes.COND_AND, ALittleTypes.COND_OR,
            ALittleTypes.DOT, ALittleTypes.EQ, ALittleTypes.GREATER,
            ALittleTypes.GREATER_OR_EQUAL, ALittleTypes.LBRACE, ALittleTypes.LBRACK, ALittleTypes.LESS, ALittleTypes.LESS_OR_EQUAL, ALittleTypes.LPAREN,
            ALittleTypes.MINUS, ALittleTypes.MINUS_ASSIGN, ALittleTypes.MINUS_MINUS, ALittleTypes.MUL, ALittleTypes.MUL_ASSIGN, ALittleTypes.NOT,
            ALittleTypes.NOT_EQ, ALittleTypes.PLUS, ALittleTypes.PLUS_ASSIGN, ALittleTypes.PLUS_PLUS, ALittleTypes.QUOTE, ALittleTypes.QUOTIENT,
            ALittleTypes.QUOTIENT_ASSIGN, ALittleTypes.RBRACE, ALittleTypes.RBRACK, ALittleTypes.REMAINDER, ALittleTypes.REMAINDER_ASSIGN, ALittleTypes.RPAREN,
            ALittleTypes.SEMI);

    public static final TokenSet ANNO_SET = TokenSet.create(ALittleTypes.CMD, ALittleTypes.MSG
            , ALittleTypes.HTTP, ALittleTypes.HTTPDOWNLOAD, ALittleTypes.HTTPUPLOAD, ALittleTypes.CONSTANT, ALittleTypes.LANGUAGE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new ALittleLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENT_SET;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new ALittleParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ALittleFile(viewProvider);
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return ALittleTypes.Factory.createElement(node);
    }
}
