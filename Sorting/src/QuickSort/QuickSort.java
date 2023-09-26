package QuickSort;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 4, 2, 9, 1, 5, 8, 3 };
		int n = array.length;
		quicksort(array,0,n-1);

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]);

	}

	public static void quicksort(int[] array,int esq, int dir) {
		int i = esq, j = dir, pivo = array[(esq + dir) / 2];
		while (i <= j) {
			while (array[i] < pivo)
				i++;
			while (array[j] > pivo)
				j--;
			if (i <= j) {
				swap(array,i, j);
				i++;
				j--;
			}
		}
		if (esq < j)
			quicksort(array,esq, j);
		if (i < dir)
			quicksort(array,i, dir);
	}
	public static void swap(int[] array,int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
