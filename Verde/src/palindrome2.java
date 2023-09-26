import java.util.Scanner;

public class palindrome2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (!isFim(str)) {
            str = sc.nextLine();
            if (!isFim(str)) {
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
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false; // Não é um palíndromo
            }
        }
        return true; // É um palíndromo
    }
    public static boolean isFim(String str) {
	    if (str.length() != 3)
	        return false;
	        
	    char[] fim = {'F', 'I', 'M'};
	    
	    for (int i = 0; i < 3; i++) {
	        if (str.charAt(i) != fim[i]) {
	            return false;
	        }
	    }
	    
	    return true;
	}
}
