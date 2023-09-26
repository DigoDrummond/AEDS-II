
import java.util.Random;
import java.util.Scanner;

public class random {

	public static void main(String[] args) {
		Random generator = new Random();
		Scanner sc = new Scanner(System.in);
		generator.setSeed(4);

		String str = "";
		while (!isFim(str)) {
			str = sc.nextLine();
			if (!isFim(str)) {
				char[] array = str.toCharArray();
				int n = array.length;

				char letter1 = (char) ('a' + (Math.abs(generator.nextInt()) % 26));
				char letter2 = (char) ('a' + (Math.abs(generator.nextInt()) % 26));

				for (int i = 0; i < n; i++) {
					if (array[i] == letter1)
						array[i] = letter2;
				}
				System.out.println(String.valueOf(array));
			}
		}

		sc.close();
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
