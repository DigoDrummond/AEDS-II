package InsertionSort;

import java.util.*;

public class Recursive_Insertion_Sort {

	public static final int N = 100;

	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[N];

		for (int i = 0; i < N; i++) {
			array[i] = random.nextInt(100);
		}
		System.out.println("Vetor desordenada: ");
		System.out.print("[");
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println("]\n");

		insertionSort(array);

		System.out.println("Vetor ordenado: ");
		System.out.print("[");
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println("]\n");

	}

	public static void insertionSort(int[] array, int n) {
		if (n <= 1)
			return;

		insertionSort(array, n - 1);

		int tmp = array[n - 1];
		int j = n - 2;
		while ((j >= 0) && array[j] > tmp) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = tmp;

	}

	public static void insertionSort(int[] array) {
		insertionSort(array, N);
	}
}
