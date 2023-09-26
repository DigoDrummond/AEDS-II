package List;

public class List {
	int[] array;
	int n;

	List() {
		this(6);
	}

	List(int size) {
		array = new int[size];
		n = 0;
	}

	void inserirInicio(int x) throws Exception {
		if (n >= array.length)
			throw new Exception("Erro!");

		for (int i = n; i >= 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = x;
		n++;
	}

	void inserirFim(int x) throws Exception {
		if (n >= array.length)
			throw new Exception("Erro!");

		array[n] = x;
		n++;
	}

	void inserir(int x, int position) throws Exception {
		if (n >= array.length || position < 0 || position > n)
			throw new Exception("Erro!");

		for (int i = n; i > position; i--) {
			array[i] = array[i - 1];
		}
		array[position] = x;
		n++;
	}

	int removerInicio() throws Exception {
		if (n == 0)
			throw new Exception("Erro!");

		int res = array[0];
		n--;
		for (int i = 0; i < n; i++) {
			array[i] = array[i + 1];
		}
		return res;
	}
	
	int removeEnd() throws Exception{
		if (n == 0)
			throw new Exception("Erro!");
		
		//primeiro o decremento, depois retorna valor da nova ultima posição.
		return array[--n];
	}
	
	int remover(int position) throws Exception{
		if(n==0 ||position<0 || position>n)
			throw new Exception("Erro!");
		
		int res = array[position];
		n--;
		for(int i=position;i<n;i++) {
			array[i] = array[i+1];
		}
		
		return res;
	}

	public static void main(String[] args) {

	}

}
