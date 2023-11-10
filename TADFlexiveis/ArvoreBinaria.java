package TADFlexiveis;

import java.util.Random;

/*
 * -------inserção-------
 * melhor caso = O(1), inserção na raiz
 * pior caso = O(n), elementos inseridos na ordem crescente ou decrescente
 * caso médio = O(lg n), inserção de elemento na folha de ávore balanceada
 * 
 * -------pesquisa-------
 * melhor caso = O(1), elemento na raiz
 * pior caso = O(n), elementos na ultimo folha em árvore com elementos inseridos em ordem
 * caso médio = O(lg n), árvore balanceada
 * 
 * -------remoção-------
 * melhor caso = O(1),remove raiz
 * pior caso = O(n), remove folha em árvore cujos elementos foram inseridos em ordem
 * caso médio = O(lg n), remove elemento de folha de árvore balanceada
 * */

class No {
	public int elemento;
	public No esq, dir;

	No(int x) {
		this.elemento = x;
		this.esq = null;
		this.dir = null;
	}

	No(int elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

class CelulaDupla {
	public int elemento;
	public CelulaDupla prox, ant;

	public CelulaDupla() {
		this(0);
	}

	public CelulaDupla(int x) {
		this.elemento = x;
		this.prox = this.ant = null;
	}

}

class Celula {
	public int elemento;
	public Celula prox;// aponta para objetos do tipo célula

	public Celula() {
	}

	public Celula(int x) {
		this.elemento = x;
		this.prox = null;
	}
}

class ArvoreBinaria {
	No raiz;
	private int altura = 0;
	private int n = 0;// para TreeSort

	ArvoreBinaria() {
		raiz = null;
	}

	// ------- INSERÇÃO COM RETORNO DE REFERÊNCIA-------
	void inserir(int x) throws Exception {
		raiz = inserir(x, raiz);
	}

	No inserir(int x, No i) throws Exception {
		if (raiz == null) {
			i = new No(x);
		} else if (x > i.elemento) {
			i.dir = inserir(x, i.dir);
		} else if (x < i.elemento) {
			i.esq = inserir(x, i.esq);
		} else {
			throw new Exception("Número repetido não é inserido!");
		}
		return i;
	}
	// -----------------------------------------------

	// ------- INSERÇÃO COM PASSAGEM DE PAI-------
	void inserirPai(int x) throws Exception {
		if (raiz == null) {
			raiz = new No(x);
		} else if (x < raiz.elemento) {
			inserirPai(x, raiz.esq, raiz);
		} else if (x > raiz.elemento) {
			inserirPai(x, raiz.dir, raiz);
		} else {
			throw new Exception("Elemento repetido não será inserido!");
		}
	}

	void inserirPai(int x, No i, No pai) throws Exception {
		if (i == null) {
			if (x < pai.elemento) {
				pai.esq = new No(x);
			} else {
				pai.dir = new No(x);
			}
		} else if (x < i.elemento) {
			inserirPai(x, i.esq, i);
		} else if (x > i.elemento) {
			inserirPai(x, i.dir, i);
		} else {
			throw new Exception("Elemento repetido não será inserido");
		}
	}
	// ----------------------------------

	// ------- REMOVER -------
	
	void remover(int x) throws Exception{
		raiz = remover(x,raiz);
	}
	
	private No remover(int x, No i) throws Exception{
		if(i==null) {
			throw new Exception("Árvore vazia!");
		}else if(x<i.elemento) {
			i.esq = remover(x,i.esq);
		}else if(x>i.elemento) {
			i.dir = remover(x,i.dir);
		}else if(i.dir == null) {
			i=i.esq;
		}else if(i.esq == null) {
			i=i.dir;
		}else {
			i.esq = maiorEsq(i,i.esq);
		}
		return i;
		
	}
	
	private No maiorEsq(No i, No j) {
		if(j.dir == null) {
			i.elemento = j.elemento;
			j=j.esq;
		}else {
			j.dir = maiorEsq(i,j.dir);
		}
		return j;
	}

	// ------- PESQUISA-------
	boolean pesquisar(int x) {
		return pesquisar(x, raiz);
	}

	boolean pesquisar(int x, No i) {
		boolean resp = true;
		if (i == null) {
			resp = false;
		} else if (x == i.elemento) {
			resp = true;
		} else if (x < i.elemento) {
			pesquisar(x, i.esq);
		} else {
			pesquisar(x, i.dir);
		}
		return resp;
	}
	// ------------------------

	// ------- CAMINHAMENTO -------
	void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq);
			System.out.println(i.elemento + " ");
			caminharCentral(i.dir);
		}
	}

	void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq);
			caminharPos(i.dir);
			System.out.println(i.elemento + " ");
		}
	}

	void caminharPre(No i) {
		if (i != null) {
			System.out.println(i.elemento + " ");
			caminharPre(i.esq);
			caminharPre(i.dir);
		}
	}

	// ---------------------------

	// ------- CALCULA ALTURA DA ÁRVORE -------

	int getAltura() {
		return getAltura(raiz, altura);
	}

	int getAltura(No i, int altura) {
		if (i == null) {
			altura--;
		} else {
			int alturaEsq = getAltura(i.esq, altura + 1);
			int alturaDir = getAltura(i.dir, altura + 1);
			altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
		}
		return altura;
	}

	// --------------------------------

	// ------- PEGA MAIOR ELEMENTO DA ÁRVORE-------

	public int getMaior() {
		int resp = -1;
		if (raiz != null) {
			No i;
			for (i = raiz; i.dir != null; i = i.dir)
				;
			resp = i.elemento;
		}
		return resp;
	}
	
	//---------------------------------------------
	
	// ------- PEGA MENOR ELEMENTO DA ÁRVORE-------

		public int getMenor() {
			int resp = -1;
			if (raiz != null) {
				No i;
				for (i = raiz; i.esq != null; i = i.esq)
					;
				resp = i.elemento;
			}
			return resp;
		}
		
	//---------------------------------------------
	
	

	// ------- SOMA ELEMENTOS DA ÁRVORE -------

	public int soma() {
		return soma(raiz);
	}

	public int soma(No i) {
		int sum = 0;
		if (i != null) {
			sum = i.elemento + soma(i.esq) + soma(i.dir);
		}
		return sum;
	}

	// ----------------------------------------

	// ------- NÚMERO DE ELEMENTOS PARES NA ÁRVORE-------

	public int numPares() {
		return numPares(raiz);
	}

	public int numPares(No i) {
		int count = 0;
		if (i != null) {
			count = ((i.elemento % 2 == 0) ? 1 : 0) + numPares(i.esq) + numPares(i.dir);
		}
		return count;
	}

	// -----------------------------------------------

	// ------- VERIFICA SE DUAS ÁRVORES SÃO IGUAIS

	public boolean igual(ArvoreBinaria a, ArvoreBinaria b) {
		return igual(a.raiz, b.raiz);
	}

	public boolean igual(No i, No j) {
		boolean resp;
		if (i != null && j != null) {
			resp = (i.elemento == j.elemento) && igual(i.dir, j.dir) && igual(i.esq, j.esq);
		} else if (i == null && j == null) {
			resp = true;
		} else {
			resp = false;
		}
		return resp;
	}

	// -------------------------------------------

	// ------- VERIFICA SE TEM NÚMERO DIVISÍVEL POR 11 -------

	public boolean has11() {
		return has11(raiz);
	}

	public boolean has11(No i) {
		boolean resp = false;
		if (i != null) {
			resp = (i.elemento % 11 == 0) || has11(i.esq) || has11(i.dir);
		}
		return resp;
	}

	// ---------------------------------------------

	// ------- INSERE ELEMENTOS DA ÁRVORE NO ARRAY ORDENADAMENTE-------
	public int[] sort() {
		int[] array = new int[n];
		n = 0;
		sort(raiz, array);
		return array;
	}

	private void sort(No i, int[] array) {
		if (i != null) {
			sort(i.esq, array);
			array[n++] = i.elemento;
			sort(i.dir, array);
		}
	}

	// ---------------------------------------------------------

	// ------- ÁRVORE BINÁRIA COM ELEMENTO INTERCALADOS-------

	No toAB(Celula p1, CelulaDupla p2) throws Exception {
		No resp = null;
		p1 = p1.prox;
		p2 = p2.prox;

		while (p1 != null && p2 != null) {
			resp = inserir(p1.elemento, resp);
			resp = inserir(p2.elemento, resp);
			p1 = p1.prox;
			p2 = p2.prox;
		}

		return resp;
	}

}

public class ArvoreBinaria {

	public static void main(String[] args) throws Exception {
		ArvoreBinaria arvore = new ArvoreBinaria();

		Random gerador = new Random();
		gerador.setSeed(0);
		for (int i = 1; i <= 100000; i++) {
			int valor;
			do {
				valor = Math.abs(gerador.nextInt());
			} while (arvore.pesquisar(valor) == true);
			arvore.inserir(valor);

			if (i % 1000 == 0) {
				double log2 = Math.log(i) / Math.log(2);
				log2 *= 1.39;
				System.out
						.println("Número de nós = " + i + " --- log(i,2) = " + log2 + " --- h = " + arvore.getAltura());
			}
		}

	}
}