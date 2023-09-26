package MergeSort;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 8, 2, 5, 3, 4, 7, 6, 1 };

		mergeSort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	// cada chamada recursiva divide array em dois, criar dois subarrays e copiar
	// elementos
	public static void mergeSort(int[] array) {
		int length = array.length;

		if (length <= 1)// caso base
			return;

		int middle = length / 2;

		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];

		int i = 0;// left array
		int j = 0;// right array

		for (; i < length; i++) {
			if (i < middle)
				leftArray[i] = array[i];
			else
				rightArray[j++] = array[i];
		}
		mergeSort(leftArray);// divide array repetidamente
		mergeSort(rightArray);// divide array repetidamente
		merge(leftArray, rightArray, array);

	}

	// helper method
	public static void merge(int[] leftArray, int[] rightArray, int[] array) {
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		int i = 0;// original array
		int l = 0;// left array
		int r = 0;// right array

		// verifica condições para junção/interseção ordenada
		while (l < leftSize && r < rightSize) {
			if (leftArray[l] < rightArray[r])
				array[i++] = leftArray[l++];
			else
				array[i++] = rightArray[r++];

		}
		while (l < leftSize)
			array[i++] = leftArray[l++];

		while (r < rightSize)
			array[i++] = rightArray[r++];

	}

}
