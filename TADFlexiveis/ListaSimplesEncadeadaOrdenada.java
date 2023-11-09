package TADFlexiveis;

class Celula {
    public int elemento;
    public Celula prox;

    public Celula() {

    }

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Lista {

    private Celula primeiro, ultimo;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public int tamanho() {
        int count = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            count++;
        }
        return count;
    }

    // IGUAL FILA
    private void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Can't remove form empty list!");
        }
        Celula i;
        for (i = primeiro.prox; i.prox != ultimo; i = i.prox)
            ;// percorre até penúltimo
        int resp = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;
        return resp;
    }

    // IGUAL FILA
    public int removerInicio() {
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp = tmp.prox = null;
        return resp;
    }

    private void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserir(int x) throws Exception {
        Celula anterior = primeiro;
        Celula atual = primeiro.prox;
        
        while(atual!=null && x>atual.elemento) {
        	anterior = atual;
        	atual=atual.prox;
        }
        Celula novo = new Celula(x);
        anterior.prox = novo;
        novo.prox=atual;
        if(novo.prox==null) {
        	ultimo=novo;
        }
        	
    }

    public int remover(int pos) throws Exception {
        int resp;
        int tamanho = tamanho();
        if (primeiro == ultimo) {
            throw new Exception("Can't remove form empty list!");
        } else if (pos == 0) {
            resp = removerInicio();
        } else if (pos == tamanho) {
            resp = removerFim();
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;// percorre até anterior
            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }
        return resp;
    }

    public int removeSegundaPosicao() {
        Celula i = primeiro;
        for (int j = 0; j < 2; j++, i = i.prox)
            ;
        Celula tmp = i.prox;
        int resp = tmp.elemento;
        i.prox = tmp.prox;
        tmp.prox = tmp = i = null;
        return resp;
    }

    public void mostrar() {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
    }

}

public class ListaSimplesEncadeadaOrdenada {
    public static void main(String[] args) {
        Lista lista = new Lista();

        try {
            lista.inserir(5);
            lista.inserir(2);
            lista.inserir(4);
            lista.inserir(1);
            lista.inserir(7);
            lista.inserir(6);
        } catch (Exception e) {

            e.printStackTrace();
        }
        lista.mostrar();

    }
}
