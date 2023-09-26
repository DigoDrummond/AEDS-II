package InsertionSort;

import java.util.*;

public class Insertion_Sort {

	public static final int N = 100;

	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[N];

		for (int i = 0; i < N; i++) {
			array[i] = random.nextInt(100);
		}
		System.out.println("Vetor desordenada: ");
		System.out.print("[");
		for(int a : array) {
			System.out.print(a + " ");
		}
		System.out.println("]\n");
		
		insertionSort(array);
		
		System.out.println("Vetor ordenado: ");
		System.out.print("[");
		for(int a : array) {
			System.out.print(a + " ");
		}
		System.out.println("]\n");

	}

	public static void insertionSort(int[] array) {
		int count = 0;
		
		for(int i=0;i<N;i++) {
			int tmp = array[i];
			int j = i-1;
			while((j>=0) && array[j]>tmp) {
				count++;
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = tmp;
		}
		System.out.println("A quantidade de comparações executada foi: " + count);
	}
}
