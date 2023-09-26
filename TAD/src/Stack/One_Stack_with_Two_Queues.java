package Stack;

public class One_Stack_with_Two_Queues {

	int[] array;
	int n;
	
	One_Stack_with_Two_Queues(){
		this(6);
	}
	
	One_Stack_with_Two_Queues(int size){
		array = new int[size];
		n=0;
	}
	
	void enfileirar(int x) throws Exception {
		if (n >= array.length)
			throw new Exception("Erro!");

		for (int i = n; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = x;
		n++;
	}
	
	int desemfileirar() throws Exception {
		if(n==0)
			throw new Exception("Empty Array");
		int[] aux = new int[n-1];
		int res = array[0];
		
		for(int i=1,j=0;i<n;i++,j++) {
			aux[j] = array[i];
		}
		n--;
		
		for(int i=0;i<n;i++) {
			array[i] = aux[i];
		}
		
		return res;
	}
	void imprimir() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
	
	
	public static void main(String[] args) throws Exception {
		One_Stack_with_Two_Queues fila = new One_Stack_with_Two_Queues(5);

		fila.enfileirar(4);
		fila.enfileirar(5);
		fila.enfileirar(7);
		fila.enfileirar(3);
		fila.enfileirar(1);
		
		fila.imprimir();
		
		int removido = fila.desemfileirar();
		
		fila.imprimir();
		
		System.out.println(removido);
	}

}
