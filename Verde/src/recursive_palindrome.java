import java.util.Scanner;

public class recursive_palindrome {

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

    public static boolean isPalindrome(String str, int esq, int dir) {
    	
        if(esq>=dir)
        	return true;
        char[] c = str.toCharArray();
        if(c[esq] != c[dir]) {
        	return false;
        }
        return isPalindrome(str, esq+1, dir-1);
        	
    }
    //overcharge para passar parametros iniciais
    public static boolean isPalindrome(String str) {
    	return isPalindrome(str,0,str.length()-1);
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
