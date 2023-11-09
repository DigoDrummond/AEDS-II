package TADFlexiveis;

class CelulaDupla {
	public int elemento;
	public CelulaDupla prox, ant;

	public CelulaDupla() {

	}

	public CelulaDupla(int x) {
		this.elemento = x;
		this.prox = this.ant = null;
	}
}

class Lista {
	private CelulaDupla primeiro, ultimo;

	public Lista() {
		primeiro = new CelulaDupla();
		ultimo=primeiro;
	}

	public int tamanho() {
		int count = 0;
		for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
			count++;
		}
		return count;
	}

	public void inserirInicio(int x) {
		CelulaDupla tmp = new CelulaDupla(x);
		tmp.ant = primeiro;
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {
			ultimo = tmp;
		} else {
			tmp.prox.ant = tmp;
		}
		tmp = null;

	}

	public int removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Can't remove from empty list!");
		}

		CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		int resp = primeiro.elemento;
		tmp.prox = primeiro.ant = null;
		return resp;

	}

	public void inserirFim(int x) {
		ultimo.prox = new CelulaDupla(x);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}

	public int removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Can't remove from empty list!");
		}

		int resp = ultimo.elemento;
		ultimo = ultimo.ant;
		ultimo.prox.ant = null;
		ultimo.prox = null;
		return resp;

	}

	public void inserir(int x, int pos) throws Exception {
		int tamanho = tamanho();
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição inválida");
		} else if (pos == 0) {
			inserirInicio(x);
		} else if (pos == tamanho) {
			inserirFim(x);
		} else {
			CelulaDupla i = primeiro;
			for (int j = 0; j < pos; j++, i = i.prox)
				;

			CelulaDupla tmp = new CelulaDupla(x);
			tmp.ant = i;
			tmp.prox = i.prox;
			tmp.ant.prox = tmp.prox.ant = tmp;
			tmp = i = null;
		}

	}

	public int remover(int pos) throws Exception {
		int resp;
		int tamanho = tamanho();

		if (primeiro == ultimo) {
			throw new Exception("Can't remove from empty list!");
		} else if (pos < 0 || pos >= tamanho) {
			throw new Exception("Invalid position!");
		} else if (pos == 0) {
			resp = removerInicio();
		} else if (pos == tamanho - 1) {
			resp = removerFim();
		} else {
			CelulaDupla i = primeiro.prox;
			for (int j = 0; j < pos; j++, i = i.prox)
				;
			i.ant.prox = i.prox;
			i.prox.ant = i.ant;
			resp = i.elemento;
			i.prox = i.ant = i = null;
		}
		return resp;

	}

	public void mostrar() {
		for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
	}
	
	public void inverte() {
		CelulaDupla i = primeiro.prox;
		CelulaDupla j = ultimo;
		while(i!=j && j.prox!=i) {
			int tmp = i.elemento;
			i.elemento = j.elemento;
			j.elemento = tmp;
			i = i.prox;
			j=j.ant;
		}
		
	}

}

public class ListaDupla {
	public static void main(String[] args) {
        Lista lista = new Lista();

        // Testando a inserção no início e no fim
        lista.inserirInicio(5);
        lista.inserirInicio(3);
        lista.inserirFim(7);
        lista.inserirFim(9);

        // Exibindo a lista antes da inversão
        System.out.println("Lista antes da inversão:");
        lista.mostrar();

        // Invertendo a lista
        lista.inverte();

        // Exibindo a lista após a inversão
        System.out.println("\nLista após a inversão:");
        lista.mostrar();
    }
}