package SelectionSort;

public class Recursive_Selection_Sort {

	public static void main(String[] args) {
		int[] array = { 4, 2, 9, 1, 5, 8, 3 };
		int n = array.length;
		selectionSort(array);

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]);

	}

	public static void selectionSort(int[] array, int i) {
		int menor = i;
		for (int j = i + 1; j < array.length; j++) {
			if (array[menor] > array[j])
				menor = j;
		}
		swap(array, menor, i);
		
		if(i+1<array.length)
			selectionSort(array,i+1);
	}
	
	public static void selectionSort(int[] array) {
		 selectionSort(array,0);
	}

	public static void swap(int[] array, int menor, int i) {
		int temp = array[menor];
		array[menor] = array[i];
		array[i] = temp;
	}
}