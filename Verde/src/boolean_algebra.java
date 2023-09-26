import java.util.*;

public class boolean_algebra {
  public static boolean isZero(String str) {
    if (str.length() == 1 && str.charAt(0) == '0')
      return true;
    return false;
  }

  public static String switchLetter(String str) {
    int[] values = new int[100];
    int n, k, p, i;
    String newValue, letter;
    char v, l;
    n = str.charAt(0) - '0';
    for (k = 0; k < n; k++) {
      p = k + 1;
      p *= 2;
      values[k] = (int) str.charAt(p) - (int) '0';
    }
    i = str.length();
    for (k = 0; k < i; k++) {
      if (str.charAt(k) >= 65 && str.charAt(k) <= 90) {
        newValue = "";
        letter = "";
        p = str.charAt(k) - 'A';
        l = str.charAt(k);
        v = (char) (values[p] + 48);
        newValue = newValue + v;
        letter = letter + l;
        str = str.replace(letter, newValue);
      }
    }
    return str;
  }

  public static boolean hasOne(String str, int j, int i) {
    boolean result = false;
    int k;
    for (k = j; k < i; k++) {
      if (str.charAt(k) == '1') {
        result = true;
      }
    }
    return result;
  }

  public static boolean hasZero(String str, int j, int i) {
    boolean result = false;
    int k;
    for (k = j; k < i; k++) {
      if (str.charAt(k) == '0') {
        result = true;
      }
    }
    return result;
  }

  public static boolean hasOr(String str, int j) {
    return (str.charAt(j - 2) == 'o' && str.charAt(j - 1) == 'r');
  }

  public static boolean hasAnd(String str, int j) {
    return (str.charAt(j - 3) == 'a' && str.charAt(j - 2) == 'n' && str.charAt(j - 1) == 'd');
  }

  public static String parentheses(String str, int j, int i) {
    String subStr;
    int k;
    subStr = "";
    for (k = j; k <= i; k++) {
      subStr = subStr + str.charAt(k);
    }
    return subStr;
  }

  public static String switchAndOr(String str, String substr, int j, int i) {
    if (hasOr(str, j) && hasOne(str, j, i)) {
      substr = "or" + substr;
      str = str.replace(substr, "1");
    } else if (hasOr(str, j)) {
      substr = "or" + substr;
      str = str.replace(substr, "0");
    } else if (hasAnd(str, j) && hasZero(str, j, i)) {
      substr = "and" + substr;
      str = str.replace(substr, "0");
    } else if (hasAnd(str, j)) {
      substr = "and" + substr;
      str = str.replace(substr, "1");
    }
    return str;
  }

  public static String switchNot(String str) {
    String stringOne, stringZero;
    stringOne = "not(1)";
    stringZero = "not(0)";
    str = str.replace(stringOne, "0");
    str = str.replace(stringZero, "1");
    return str;
  }

  public static boolean evaluatestr(String str) {
    int i, j, n, start;
    String substr;
    boolean result = false;
    n = str.length();
    start = str.charAt(0) - '0';
    start = (start + 1) * 2;
    str = switchLetter(str);
    j = 0;
    for (i = 0; i < n; i++) {
      if (str.charAt(i) == '(') {
        j = i;
      }
      if (str.charAt(i) == ')') {
        substr = parentheses(str, j, i);
        str = switchNot(str);
        if (str.length() == n) {
          str = switchAndOr(str, substr, j, i);
          n = str.length();
          i = 0;
        } else {
          n = str.length();
          i = 0;
        }
      }
    }
    if (str.charAt(start) == '1') {
      result = true;
    } else if (str.charAt(start) == '0') {
      result = false;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] strs = new String[1000];
    int n = 0, i;
    do {
      strs[n] = sc.nextLine();
    } while (!isZero(strs[n++]));
    n--;
    for (i = 0; i < n; i++) {
      if (evaluatestr(strs[i])) {
        System.out.println("1");
      } else {
        System.out.println("0");
      }
    }
  }
}
