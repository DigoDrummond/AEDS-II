package Array;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Product[] array = new Product[n];
		
		for(int i=0;i<n;i++) {
			sc.nextLine();
			String name = sc.nextLine();
			double price = sc.nextDouble();
			array[i] = new Product(name,price);
		}
		double sum = 0.0;
		for(int i=0;i<n;i++) {
			sum+= array[i].getPrice();
		}
		double average = sum/n;
		
		System.out.println("Average price: " + average);
		
		
		sc.close();
	}

}
