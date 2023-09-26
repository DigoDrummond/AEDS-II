
import java.util.*;

public class palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (!str.equals("FIM")) {
			str = sc.nextLine();
			if (!str.equals("FIM")) {
				boolean palindrome = isPalindrome(str);
				if (palindrome)
					System.out.println("SIM");
				else
					System.out.println("NAO");
			}
		}
		sc.close();
	}

	public static boolean isPalindrome(String str) {
		StringBuilder str2 = new StringBuilder(str);
		str2.reverse();
		return str.equals(str2.toString());
	}
}
