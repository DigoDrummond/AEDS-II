package Stack;

//remover e inserir no fim, custo 1
//remover e inserir no inicio, custo n

public class Stack {

	int[] array;
	int n;
	
	Stack(){
		this(6);
	}
	Stack(int size){
		array = new int[size];
		n=0;
	}
	
	int removerFim() throws Exception{
		if(n==0)
			throw new Exception("Empty Array!");
		
		return array[--n];
	}
	
	void inserirFim() throws Exception{
		if(n>=array.length)
			throw new Exception("Array's already full");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
