package SelectionSort;

public class Partial_Selection_Sort {

	public static void main(String[] args) {
		int[] array = { 4, 2, 9, 1, 5, 8, 3 };
		int n = array.length;
		selectionSort(array, 3);

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]);

	}

	public static void selectionSort(int[] array, int k) {
		for (int i = 0; i < k; i++) {
			int menor = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[menor] > array[j])
					menor = j;
			}
			swap(array, menor, i);
		}
	}

	public static void swap(int[] array, int menor, int i) {
		int temp = array[menor];
		array[menor] = array[i];
		array[i] = temp;
	}
}