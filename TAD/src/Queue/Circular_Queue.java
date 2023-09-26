package Queue;

public class Circular_Queue {
	int[] array;
	int first;
	int last;

	Circular_Queue(int size) {
		array = new int[size + 1];
		first = last = 0;
	}

	void Insert(int x) throws Exception {
		if (((last + 1) % array.length) == first)
			throw new Exception("Array's already full!");

		array[last] = x;
		last = (last + 1) % array.length;

	}
	

	int Remove() throws Exception {
		if (first == last)
			throw new Exception("Empthy Array!");

		//primeiro elemento passa a ser o próximo, removido vira lixo de memória
		//embora ainda esteja lá não está mais no array
		int res = array[first];
		first = (first + 1) % array.length;
		return res;
	}

	void show() {
		int i = first;
		System.out.print("[");

		while (i != last) {
			System.out.print(array[i] + " ");
			i = (i + 1) % array.length;
		}
		System.out.print("]\n");
	}

	boolean isEmpty() {
		if (first == last)
			return true;
		return false;
	}

	void recursiveShow(int i) {
		if (i == last)
			System.out.printf("]\n");
		else {
			if (i == first)
				System.out.printf("[ ");
			System.out.printf(array[i] + " ");
			recursiveShow((i + 1) % array.length);
		}
	}

	void recursiveShow() {
		recursiveShow(first);
	}

	boolean binarySearch(int x) {
		int left = first;
		int right = last;

		while (left != right) {
			int mid = (left + right) % array.length;
			if (array[mid] == x)
				return true;
			left = (left + 1) % array.length;
		}
		return false;
	}
	
	int returnPosition(int position) throws Exception{
		if(position>last && position <first)
			throw new Exception("Unvailable index!");
		return array[position];
	}

	public static void main(String[] args) throws Exception {
		Circular_Queue queue = new Circular_Queue(5);

		queue.Insert(5);
		queue.Insert(4);
		queue.Insert(10);
		queue.Insert(3);
		queue.Insert(2);
		queue.show();

		queue.Remove();
		queue.Remove();
		queue.Insert(11);
		queue.Insert(12);
		queue.recursiveShow();

		if (queue.binarySearch(11))
			System.out.println("11 está no array");
		else 
			System.out.println("11 não está no array");
		int s = queue.returnPosition(3);
		System.out.println(s);
	}

}
