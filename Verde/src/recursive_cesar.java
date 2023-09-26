
import java.util.*;

public class recursive_cesar {

	public static final int KEY = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (!isFim(str)) {
			str = sc.nextLine();
			if (!isFim(str)) {
				String cesar = cifraCesar(str);
				System.out.println(cesar);
			}
		}

		sc.close();
	}

	public static boolean isFim(String str) {
		if (str.length() != 3)
			return false;

		char[] fim = { 'F', 'I', 'M' };

		for (int i = 0; i < 3; i++) {
			if (str.charAt(i) != fim[i]) {
				return false;
			}
		}

		return true;
	}

	public static String cifraCesar(String str, int idx) {
		if (idx >= str.length())
			return str;
		char[] c = str.toCharArray();
		if ((int)c[idx]>=32 && (int)c[idx]<126)
			c[idx] = (char) ((int) c[idx] + KEY);

		return cifraCesar(new String(c), idx + 1);
	}

	public static String cifraCesar(String str) {
		return cifraCesar(str, 0);
	}
}
