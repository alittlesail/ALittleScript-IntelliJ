/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static plugin.psi.ALittleTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>_ALittleLexer.flex</tt>
 */
public class _ALittleLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\3\4\2\22\0\1\3\1\30\1\14\2\0\1\41\1\34\1\12\1\22\1\23\1\40\1\31\1"+
    "\26\1\32\1\11\1\4\1\5\11\10\1\24\1\25\1\36\1\27\1\42\2\0\2\7\1\56\2\7\1\73"+
    "\5\15\1\72\1\71\15\15\1\20\1\13\1\21\1\37\1\15\1\0\1\44\1\64\1\51\1\66\1\46"+
    "\1\62\1\61\1\67\1\52\1\15\1\70\1\55\1\45\1\43\1\57\1\50\1\15\1\60\1\47\1\53"+
    "\1\63\1\65\1\54\1\6\1\74\1\15\1\16\1\33\1\17\1\35\6\0\1\1\242\0\2\1\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\4\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\23\5\1\37\1\40\1\0\1\4\1\41\1\0\1\42"+
    "\3\0\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61"+
    "\1\62\1\63\13\5\1\64\1\65\14\5\1\66\3\5"+
    "\1\4\1\67\1\70\1\5\1\71\1\5\1\72\2\5"+
    "\1\73\7\5\1\74\5\5\1\75\1\5\1\76\1\77"+
    "\2\5\1\100\1\5\1\101\3\5\1\102\1\103\1\104"+
    "\10\5\1\105\1\106\1\5\1\107\2\5\1\110\2\5"+
    "\1\111\10\5\1\112\1\5\1\113\1\5\1\114\1\5"+
    "\1\115\1\116\3\5\1\117\1\120\1\121\1\122\2\5"+
    "\1\123\1\5\1\124\1\125\2\5\1\126\2\5\1\127"+
    "\2\5\1\130\1\131\1\132";

  private static int [] zzUnpackAction() {
    int [] result = new int[203];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\75\0\172\0\267\0\364\0\u0131\0\u016e\0\u01ab"+
    "\0\u01e8\0\75\0\u0225\0\75\0\75\0\75\0\75\0\75"+
    "\0\75\0\75\0\75\0\75\0\u0262\0\u029f\0\u02dc\0\u0319"+
    "\0\u0356\0\u0393\0\75\0\u03d0\0\u040d\0\u044a\0\u0487\0\u04c4"+
    "\0\u0501\0\u053e\0\u057b\0\u05b8\0\u05f5\0\u0632\0\u066f\0\u06ac"+
    "\0\u06e9\0\u0726\0\u0763\0\u07a0\0\u07dd\0\u081a\0\u0857\0\u0894"+
    "\0\u08d1\0\u090e\0\u094b\0\u0988\0\75\0\u09c5\0\u0a02\0\75"+
    "\0\u01e8\0\75\0\u0a3f\0\u0225\0\u0a7c\0\75\0\75\0\75"+
    "\0\75\0\75\0\75\0\75\0\75\0\75\0\75\0\75"+
    "\0\u0ab9\0\75\0\75\0\75\0\75\0\u0af6\0\u0b33\0\u0b70"+
    "\0\u0bad\0\u0bea\0\u0c27\0\u0c64\0\u0ca1\0\u0cde\0\u0d1b\0\u0d58"+
    "\0\u0d95\0\u0dd2\0\u0131\0\u0e0f\0\u0e4c\0\u0e89\0\u0ec6\0\u0f03"+
    "\0\u0f40\0\u0f7d\0\u0fba\0\u0ff7\0\u1034\0\u1071\0\u10ae\0\u10eb"+
    "\0\u1128\0\u1165\0\u11a2\0\u09c5\0\75\0\75\0\u11df\0\u0131"+
    "\0\u121c\0\u0131\0\u1259\0\u1296\0\u0131\0\u12d3\0\u1310\0\u134d"+
    "\0\u138a\0\u13c7\0\u1404\0\u1441\0\u0131\0\u147e\0\u14bb\0\u14f8"+
    "\0\u1535\0\u1572\0\u0131\0\u15af\0\u0131\0\u0131\0\u15ec\0\u1629"+
    "\0\u0131\0\u1666\0\u0131\0\u16a3\0\u16e0\0\u171d\0\u0131\0\u0131"+
    "\0\u175a\0\u1797\0\u17d4\0\u1811\0\u184e\0\u188b\0\u18c8\0\u1905"+
    "\0\u1942\0\u0131\0\u0131\0\u197f\0\u0131\0\u19bc\0\u19f9\0\u0131"+
    "\0\u1a36\0\u1a73\0\u0131\0\u1ab0\0\u1aed\0\u1b2a\0\u1b67\0\u1ba4"+
    "\0\u1be1\0\u1c1e\0\u1c5b\0\u0131\0\u1c98\0\u0131\0\u1cd5\0\u0131"+
    "\0\u1d12\0\u0131\0\u0131\0\u1d4f\0\u1d8c\0\u1dc9\0\u0131\0\u0131"+
    "\0\u0131\0\u0131\0\u1e06\0\u1e43\0\u0131\0\u1e80\0\u0131\0\u0131"+
    "\0\u1ebd\0\u1efa\0\u0131\0\u1f37\0\u1f74\0\u0131\0\u1fb1\0\u1fee"+
    "\0\u0131\0\u0131\0\u0131";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[203];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\2\2\3\1\4\1\5\2\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\6\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\1\6\1\43\1\44\1\45\1\46\1\47"+
    "\1\50\1\51\1\6\1\52\1\6\1\53\1\54\1\55"+
    "\1\6\1\56\1\57\1\60\2\6\1\61\1\62\1\63"+
    "\1\6\77\0\2\3\75\0\1\64\22\0\1\65\52\0"+
    "\1\7\1\66\1\0\1\7\1\67\70\0\4\6\4\0"+
    "\1\6\25\0\32\6\5\0\1\7\2\0\1\7\1\67"+
    "\74\0\1\70\63\0\12\71\1\72\1\73\61\71\13\74"+
    "\1\75\1\72\60\74\27\0\1\76\74\0\1\77\74\0"+
    "\1\100\1\0\1\101\72\0\1\102\2\0\1\103\71\0"+
    "\1\104\3\0\1\105\70\0\1\106\4\0\1\107\67\0"+
    "\1\110\6\0\1\111\65\0\1\112\74\0\1\113\74\0"+
    "\1\114\74\0\1\115\12\0\1\116\37\0\4\6\4\0"+
    "\1\6\25\0\1\6\1\117\1\6\1\120\14\6\1\121"+
    "\11\6\5\0\4\6\4\0\1\6\25\0\1\122\31\6"+
    "\5\0\4\6\4\0\1\6\25\0\1\123\11\6\1\124"+
    "\17\6\5\0\4\6\4\0\1\6\25\0\3\6\1\125"+
    "\4\6\1\126\21\6\5\0\4\6\4\0\1\6\25\0"+
    "\15\6\1\127\2\6\1\130\11\6\5\0\4\6\4\0"+
    "\1\6\25\0\12\6\1\131\17\6\5\0\4\6\4\0"+
    "\1\6\25\0\1\132\16\6\1\133\12\6\5\0\4\6"+
    "\4\0\1\6\25\0\15\6\1\134\6\6\1\135\5\6"+
    "\5\0\4\6\4\0\1\6\25\0\24\6\1\136\5\6"+
    "\5\0\4\6\4\0\1\6\25\0\10\6\1\137\21\6"+
    "\5\0\4\6\4\0\1\6\25\0\3\6\1\140\26\6"+
    "\5\0\4\6\4\0\1\6\25\0\3\6\1\141\26\6"+
    "\5\0\4\6\4\0\1\6\25\0\1\6\1\142\12\6"+
    "\1\143\3\6\1\144\11\6\5\0\4\6\4\0\1\6"+
    "\25\0\14\6\1\145\1\146\14\6\5\0\4\6\4\0"+
    "\1\6\25\0\1\6\1\147\30\6\5\0\4\6\4\0"+
    "\1\6\25\0\14\6\1\150\15\6\5\0\4\6\4\0"+
    "\1\6\25\0\1\6\1\151\30\6\5\0\4\6\4\0"+
    "\1\6\25\0\7\6\1\152\22\6\5\0\4\6\4\0"+
    "\1\6\25\0\20\6\1\153\11\6\1\64\2\0\72\64"+
    "\5\0\1\154\1\0\2\154\33\0\1\154\1\0\1\154"+
    "\2\0\1\154\4\0\1\154\3\0\1\154\1\0\1\154"+
    "\1\0\1\154\4\0\1\154\6\0\1\67\2\0\1\67"+
    "\64\0\1\71\2\0\72\71\1\74\2\0\72\74\27\0"+
    "\1\155\74\0\1\156\52\0\4\6\4\0\1\6\25\0"+
    "\2\6\1\157\27\6\5\0\4\6\4\0\1\6\25\0"+
    "\11\6\1\160\20\6\5\0\4\6\4\0\1\6\25\0"+
    "\12\6\1\161\17\6\5\0\4\6\4\0\1\6\25\0"+
    "\31\6\1\162\5\0\4\6\4\0\1\6\25\0\20\6"+
    "\1\163\11\6\5\0\4\6\4\0\1\6\25\0\4\6"+
    "\1\164\25\6\5\0\4\6\4\0\1\6\25\0\10\6"+
    "\1\165\21\6\5\0\4\6\4\0\1\6\25\0\1\6"+
    "\1\166\13\6\1\167\14\6\5\0\4\6\4\0\1\6"+
    "\25\0\7\6\1\170\4\6\1\171\15\6\5\0\4\6"+
    "\4\0\1\6\25\0\21\6\1\172\10\6\5\0\4\6"+
    "\4\0\1\6\25\0\1\6\1\173\30\6\5\0\4\6"+
    "\4\0\1\6\25\0\4\6\1\174\3\6\1\175\21\6"+
    "\5\0\4\6\4\0\1\6\25\0\20\6\1\176\11\6"+
    "\5\0\4\6\4\0\1\6\25\0\7\6\1\177\22\6"+
    "\5\0\4\6\4\0\1\6\25\0\7\6\1\200\22\6"+
    "\5\0\4\6\4\0\1\6\25\0\14\6\1\201\15\6"+
    "\5\0\4\6\4\0\1\6\25\0\10\6\1\202\21\6"+
    "\5\0\4\6\4\0\1\6\25\0\10\6\1\203\21\6"+
    "\5\0\4\6\4\0\1\6\25\0\12\6\1\204\17\6"+
    "\5\0\4\6\4\0\1\6\25\0\15\6\1\205\14\6"+
    "\5\0\4\6\4\0\1\6\25\0\1\206\31\6\5\0"+
    "\4\6\4\0\1\6\25\0\14\6\1\207\15\6\5\0"+
    "\4\6\4\0\1\6\25\0\3\6\1\210\26\6\5\0"+
    "\4\6\4\0\1\6\25\0\15\6\1\211\14\6\5\0"+
    "\4\6\4\0\1\6\25\0\20\6\1\212\11\6\5\0"+
    "\4\6\4\0\1\6\25\0\5\6\1\213\24\6\5\0"+
    "\4\6\4\0\1\6\25\0\4\6\1\214\25\6\5\0"+
    "\4\6\4\0\1\6\25\0\1\215\31\6\5\0\4\6"+
    "\4\0\1\6\25\0\3\6\1\216\26\6\5\0\4\6"+
    "\4\0\1\6\25\0\12\6\1\217\17\6\5\0\4\6"+
    "\4\0\1\6\25\0\2\6\1\220\27\6\5\0\4\6"+
    "\4\0\1\6\25\0\3\6\1\221\26\6\5\0\4\6"+
    "\4\0\1\6\25\0\10\6\1\222\21\6\5\0\4\6"+
    "\4\0\1\6\25\0\7\6\1\223\10\6\1\224\11\6"+
    "\5\0\4\6\4\0\1\6\25\0\22\6\1\225\7\6"+
    "\5\0\4\6\4\0\1\6\25\0\10\6\1\226\21\6"+
    "\5\0\4\6\4\0\1\6\25\0\12\6\1\227\17\6"+
    "\5\0\4\6\4\0\1\6\25\0\4\6\1\230\25\6"+
    "\5\0\4\6\4\0\1\6\25\0\10\6\1\231\21\6"+
    "\5\0\4\6\4\0\1\6\25\0\3\6\1\232\26\6"+
    "\5\0\4\6\4\0\1\6\25\0\4\6\1\233\25\6"+
    "\5\0\4\6\4\0\1\6\25\0\12\6\1\234\17\6"+
    "\5\0\4\6\4\0\1\6\25\0\15\6\1\235\14\6"+
    "\5\0\4\6\4\0\1\6\25\0\20\6\1\236\11\6"+
    "\5\0\4\6\4\0\1\6\25\0\4\6\1\237\25\6"+
    "\5\0\4\6\4\0\1\6\25\0\12\6\1\240\17\6"+
    "\5\0\4\6\4\0\1\6\25\0\1\6\1\241\30\6"+
    "\5\0\4\6\4\0\1\6\25\0\21\6\1\242\10\6"+
    "\5\0\4\6\4\0\1\6\25\0\10\6\1\243\21\6"+
    "\5\0\4\6\4\0\1\6\25\0\6\6\1\244\23\6"+
    "\5\0\4\6\4\0\1\6\25\0\4\6\1\245\25\6"+
    "\5\0\4\6\4\0\1\6\25\0\7\6\1\246\22\6"+
    "\5\0\4\6\4\0\1\6\25\0\7\6\1\247\22\6"+
    "\5\0\4\6\4\0\1\6\25\0\1\250\31\6\5\0"+
    "\4\6\4\0\1\6\25\0\6\6\1\251\23\6\5\0"+
    "\4\6\4\0\1\6\25\0\1\6\1\252\30\6\5\0"+
    "\4\6\4\0\1\6\25\0\3\6\1\253\10\6\1\254"+
    "\15\6\5\0\4\6\4\0\1\6\25\0\7\6\1\255"+
    "\22\6\5\0\4\6\4\0\1\6\25\0\4\6\1\256"+
    "\25\6\5\0\4\6\4\0\1\6\25\0\1\6\1\257"+
    "\30\6\5\0\4\6\4\0\1\6\25\0\3\6\1\260"+
    "\26\6\5\0\4\6\4\0\1\6\25\0\15\6\1\261"+
    "\14\6\5\0\4\6\4\0\1\6\25\0\3\6\1\262"+
    "\26\6\5\0\4\6\4\0\1\6\25\0\25\6\1\263"+
    "\4\6\5\0\4\6\4\0\1\6\25\0\12\6\1\264"+
    "\17\6\5\0\4\6\4\0\1\6\25\0\10\6\1\265"+
    "\21\6\5\0\4\6\4\0\1\6\25\0\5\6\1\266"+
    "\24\6\5\0\4\6\4\0\1\6\25\0\17\6\1\267"+
    "\12\6\5\0\4\6\4\0\1\6\25\0\6\6\1\270"+
    "\23\6\5\0\4\6\4\0\1\6\25\0\16\6\1\271"+
    "\13\6\5\0\4\6\4\0\1\6\25\0\10\6\1\272"+
    "\21\6\5\0\4\6\4\0\1\6\25\0\10\6\1\273"+
    "\21\6\5\0\4\6\4\0\1\6\25\0\6\6\1\274"+
    "\23\6\5\0\4\6\4\0\1\6\25\0\6\6\1\275"+
    "\23\6\5\0\4\6\4\0\1\6\25\0\1\276\31\6"+
    "\5\0\4\6\4\0\1\6\25\0\1\277\31\6\5\0"+
    "\4\6\4\0\1\6\25\0\3\6\1\300\26\6\5\0"+
    "\4\6\4\0\1\6\25\0\14\6\1\301\15\6\5\0"+
    "\4\6\4\0\1\6\25\0\1\6\1\302\30\6\5\0"+
    "\4\6\4\0\1\6\25\0\3\6\1\303\26\6\5\0"+
    "\4\6\4\0\1\6\25\0\10\6\1\304\21\6\5\0"+
    "\4\6\4\0\1\6\25\0\6\6\1\305\23\6\5\0"+
    "\4\6\4\0\1\6\25\0\15\6\1\306\14\6\5\0"+
    "\4\6\4\0\1\6\25\0\6\6\1\307\23\6\5\0"+
    "\4\6\4\0\1\6\25\0\3\6\1\310\26\6\5\0"+
    "\4\6\4\0\1\6\25\0\3\6\1\311\26\6\5\0"+
    "\4\6\4\0\1\6\25\0\3\6\1\312\26\6\5\0"+
    "\4\6\4\0\1\6\25\0\23\6\1\313\6\6";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8235];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\7\1\1\11\1\1\11\11\6\1\1\11"+
    "\31\1\1\11\1\0\1\1\1\11\1\0\1\11\3\0"+
    "\13\11\1\1\4\11\37\1\2\11\135\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[203];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _ALittleLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _ALittleLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 91: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 92: break;
          case 3: 
            { return QUOTIENT;
            } 
            // fall through
          case 93: break;
          case 4: 
            { return DIGIT_CONTENT;
            } 
            // fall through
          case 94: break;
          case 5: 
            { return ID_CONTENT;
            } 
            // fall through
          case 95: break;
          case 6: 
            { return DOT;
            } 
            // fall through
          case 96: break;
          case 7: 
            { return APOS;
            } 
            // fall through
          case 97: break;
          case 8: 
            { return BACK;
            } 
            // fall through
          case 98: break;
          case 9: 
            { return QUOTE;
            } 
            // fall through
          case 99: break;
          case 10: 
            { return LBRACE;
            } 
            // fall through
          case 100: break;
          case 11: 
            { return RBRACE;
            } 
            // fall through
          case 101: break;
          case 12: 
            { return LBRACK;
            } 
            // fall through
          case 102: break;
          case 13: 
            { return RBRACK;
            } 
            // fall through
          case 103: break;
          case 14: 
            { return LPAREN;
            } 
            // fall through
          case 104: break;
          case 15: 
            { return RPAREN;
            } 
            // fall through
          case 105: break;
          case 16: 
            { return COLON;
            } 
            // fall through
          case 106: break;
          case 17: 
            { return SEMI;
            } 
            // fall through
          case 107: break;
          case 18: 
            { return COMMA;
            } 
            // fall through
          case 108: break;
          case 19: 
            { return ASSIGN;
            } 
            // fall through
          case 109: break;
          case 20: 
            { return NOT;
            } 
            // fall through
          case 110: break;
          case 21: 
            { return PLUS;
            } 
            // fall through
          case 111: break;
          case 22: 
            { return MINUS;
            } 
            // fall through
          case 112: break;
          case 23: 
            { return BIT_OR;
            } 
            // fall through
          case 113: break;
          case 24: 
            { return BIT_AND;
            } 
            // fall through
          case 114: break;
          case 25: 
            { return BIT_NOT;
            } 
            // fall through
          case 115: break;
          case 26: 
            { return LESS;
            } 
            // fall through
          case 116: break;
          case 27: 
            { return BIT_XOR;
            } 
            // fall through
          case 117: break;
          case 28: 
            { return MUL;
            } 
            // fall through
          case 118: break;
          case 29: 
            { return REMAINDER;
            } 
            // fall through
          case 119: break;
          case 30: 
            { return GREATER;
            } 
            // fall through
          case 120: break;
          case 31: 
            { return COMMENT;
            } 
            // fall through
          case 121: break;
          case 32: 
            { return QUOTIENT_ASSIGN;
            } 
            // fall through
          case 122: break;
          case 33: 
            { return CONCAT;
            } 
            // fall through
          case 123: break;
          case 34: 
            { return STRING_CONTENT;
            } 
            // fall through
          case 124: break;
          case 35: 
            { return EQ;
            } 
            // fall through
          case 125: break;
          case 36: 
            { return NOT_EQ;
            } 
            // fall through
          case 126: break;
          case 37: 
            { return PLUS_ASSIGN;
            } 
            // fall through
          case 127: break;
          case 38: 
            { return PLUS_PLUS;
            } 
            // fall through
          case 128: break;
          case 39: 
            { return MINUS_ASSIGN;
            } 
            // fall through
          case 129: break;
          case 40: 
            { return MINUS_MINUS;
            } 
            // fall through
          case 130: break;
          case 41: 
            { return BIT_OR_ASSIGN;
            } 
            // fall through
          case 131: break;
          case 42: 
            { return COND_OR;
            } 
            // fall through
          case 132: break;
          case 43: 
            { return BIT_AND_ASSIGN;
            } 
            // fall through
          case 133: break;
          case 44: 
            { return COND_AND;
            } 
            // fall through
          case 134: break;
          case 45: 
            { return LESS_OR_EQUAL;
            } 
            // fall through
          case 135: break;
          case 46: 
            { return SHIFT_LEFT;
            } 
            // fall through
          case 136: break;
          case 47: 
            { return BIT_XOR_ASSIGN;
            } 
            // fall through
          case 137: break;
          case 48: 
            { return MUL_ASSIGN;
            } 
            // fall through
          case 138: break;
          case 49: 
            { return REMAINDER_ASSIGN;
            } 
            // fall through
          case 139: break;
          case 50: 
            { return GREATER_OR_EQUAL;
            } 
            // fall through
          case 140: break;
          case 51: 
            { return SHIFT_RIGHT;
            } 
            // fall through
          case 141: break;
          case 52: 
            { return IN;
            } 
            // fall through
          case 142: break;
          case 53: 
            { return IF;
            } 
            // fall through
          case 143: break;
          case 54: 
            { return DO;
            } 
            // fall through
          case 144: break;
          case 55: 
            { return SHIFT_LEFT_ASSIGN;
            } 
            // fall through
          case 145: break;
          case 56: 
            { return SHIFT_RIGHT_ASSIGN;
            } 
            // fall through
          case 146: break;
          case 57: 
            { return NEW;
            } 
            // fall through
          case 147: break;
          case 58: 
            { return ANY;
            } 
            // fall through
          case 148: break;
          case 59: 
            { return SET;
            } 
            // fall through
          case 149: break;
          case 60: 
            { return INT;
            } 
            // fall through
          case 150: break;
          case 61: 
            { return GET;
            } 
            // fall through
          case 151: break;
          case 62: 
            { return FOR;
            } 
            // fall through
          case 152: break;
          case 63: 
            { return FUN;
            } 
            // fall through
          case 153: break;
          case 64: 
            { return VAR;
            } 
            // fall through
          case 154: break;
          case 65: 
            { return MAP;
            } 
            // fall through
          case 155: break;
          case 66: 
            { return NULL;
            } 
            // fall through
          case 156: break;
          case 67: 
            { return ENUM;
            } 
            // fall through
          case 157: break;
          case 68: 
            { return ELSE;
            } 
            // fall through
          case 158: break;
          case 69: 
            { return TRUE;
            } 
            // fall through
          case 159: break;
          case 70: 
            { return THIS;
            } 
            // fall through
          case 160: break;
          case 71: 
            { return CTOR;
            } 
            // fall through
          case 161: break;
          case 72: 
            { return BOOL;
            } 
            // fall through
          case 162: break;
          case 73: 
            { return LIST;
            } 
            // fall through
          case 163: break;
          case 74: 
            { return PROTO;
            } 
            // fall through
          case 164: break;
          case 75: 
            { return CLASS;
            } 
            // fall through
          case 165: break;
          case 76: 
            { return WHILE;
            } 
            // fall through
          case 166: break;
          case 77: 
            { return FALSE;
            } 
            // fall through
          case 167: break;
          case 78: 
            { return BREAK;
            } 
            // fall through
          case 168: break;
          case 79: 
            { return ELSEIF;
            } 
            // fall through
          case 169: break;
          case 80: 
            { return STATIC;
            } 
            // fall through
          case 170: break;
          case 81: 
            { return STRING;
            } 
            // fall through
          case 171: break;
          case 82: 
            { return STRUCT;
            } 
            // fall through
          case 172: break;
          case 83: 
            { return PUBLIC;
            } 
            // fall through
          case 173: break;
          case 84: 
            { return RETURN;
            } 
            // fall through
          case 174: break;
          case 85: 
            { return DOUBLE;
            } 
            // fall through
          case 175: break;
          case 86: 
            { return PRIVATE;
            } 
            // fall through
          case 176: break;
          case 87: 
            { return FUNCTOR;
            } 
            // fall through
          case 177: break;
          case 88: 
            { return INSTANCE;
            } 
            // fall through
          case 178: break;
          case 89: 
            { return NAMESPACE;
            } 
            // fall through
          case 179: break;
          case 90: 
            { return PROTECTED;
            } 
            // fall through
          case 180: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
