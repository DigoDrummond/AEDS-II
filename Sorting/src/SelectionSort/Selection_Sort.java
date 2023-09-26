package SelectionSort;

public class Selection_Sort {

	public static void main(String[] args) {
		int[] array = { 4, 2, 9, 1, 5, 8, 3 };
		int n = array.length;
		selectionSort(array);
		
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]);
		
	}
	public static void selectionSort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			int menor = i;
			for(int j = i+1;j<array.length;j++) {
				if(array[menor] > array[j])
					menor = j;
			}
			swap(array,menor,i);
		}
	}
	public static void swap(int[] array, int menor, int i) {
		int temp = array[menor];
		array[menor] = array[i];
		array[i] = temp;
	}
}