
import java.util.*;

public class recursive_Is {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (!isFim(str)) {
			str = sc.nextLine();
			if (!isFim(str)) {
				boolean isVowel = onlyVowel(str);
				boolean isConsonant = onlyConsonant(str);
				boolean isInteger = onlyInteger(str);
				boolean isReal = isRealNumber(str);

				System.out.printf(isVowel ? "SIM " : "NAO ");
				System.out.printf(isConsonant ? "SIM " : "NAO ");
				System.out.printf(isInteger ? "SIM " : "NAO ");
				System.out.printf(isReal ? "SIM " : "NAO \n");

			}
		}

		sc.close();
	}

	public static boolean onlyVowel(String str, int idx) {
		String vowels = "AEIOUaeiou";
		if (idx == str.length())//ja verificou todos os caracteres
			return true;
		char c = str.charAt(idx);
		if (vowels.indexOf(c) == -1)
			return false;

		return onlyVowel(str, idx + 1);
	}

	public static boolean onlyVowel(String str) {
		return onlyVowel(str, 0);
	}

	public static boolean onlyConsonant(String str, int idx) {
		String consonants = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
		if(idx == str.length())//ja verificou todos os caracteres
			return true;
		char c = str.charAt(idx);
		if(consonants.indexOf(c) == -1)
			return false;
		return onlyConsonant(str, idx+1);
		
	}
	public static boolean onlyConsonant(String str) {
		return onlyConsonant(str, 0);
	}

	public static boolean onlyInteger(String str) {
		// Integer.parseInt converte string em inteiro, caso não consiga catch pega
		// excessão e retorna falso, indicando que numero não é inteiro
		try {
			double number = Integer.parseInt(str);
			int num = (int) ((int) number - number);
			if (num == 0)
				return true;
			else
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isRealNumber(String str) {
		try {
			str = str.replace(",", ".");
			double number = Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
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

}
