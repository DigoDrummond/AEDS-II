

import java.util.*;

public class a {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String num = sc.nextLine();
			String cutoff = sc.nextLine();

			double numDouble = Double.parseDouble(num);
			double cutoffDouble = Double.parseDouble(cutoff);

			int numInt = (int) numDouble;

			double result = numDouble - numInt;

			if (result < cutoffDouble)
				System.out.println((int) numDouble);
			else
				System.out.println((int) (numDouble + 1));

		}
	}

}
