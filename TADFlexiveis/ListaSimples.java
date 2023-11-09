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
    private int n = 0;

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

    public int tamanho2() {
        return n;
    }

    // IGUAL FILA
    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
        n++;
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
        n--;
        return resp;
    }

    // IGUAL FILA
    public int removerInicio() {
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp = tmp.prox = null;
        n--;
        return resp;
    }

    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
        n++;
    }

    public void inserirNoCabeca(int x) {
        primeiro.elemento = x;
        Celula novaCabeca = new Celula();
        novaCabeca.prox = primeiro;
        primeiro = novaCabeca;
    }

    public void inserir(int x, int pos) throws Exception {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Posição inválida!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;// percorre até anterior
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;

        }
        n++;
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
        n--;
        return resp;
    }

    public int removeSegundaPosicao() {
        Celula i = primeiro;
        for (int j = 0; j < 1; j++, i = i.prox)
            ;
        Celula tmp = i.prox;
        int resp = tmp.elemento;
        i.prox = tmp.prox;
        tmp.prox = tmp = i = null;
        n--;
        return resp;
    }

    public void mostrar() {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
    }

}

public class ListaSimples {
    public static void main(String[] args) {
        Lista lista = new Lista();

        // Testar inserirFim
        lista.inserirFim(5);
        lista.inserirFim(10);
        lista.inserirFim(15);
        lista.mostrar(); // Deve exibir: 5 10 15

        // Testar removerFim
        try {
            int removido = lista.removerFim();
            System.out.println("Removido: " + removido); // Deve exibir: Removido: 15
            lista.mostrar(); // Deve exibir: 5 10
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testar inserirInicio
        lista.inserirInicio(2);
        lista.inserirInicio(1);
        lista.mostrar(); // Deve exibir: 1 2 5 10

        // Testar inserir em posição específica
        try {
            lista.inserir(3, 2);
            lista.inserir(7, 4);
            lista.mostrar(); // Deve exibir: 1 2 3 5 7 10
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testar remover em posição específica
        try {
            int removido = lista.remover(2);
            System.out.println("Removido: " + removido); // Deve exibir: Removido: 3
            lista.mostrar(); // Deve exibir: 1 2 5 7 10
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testar remover segunda posição
        int removidoSegunda = lista.removeSegundaPosicao();
        System.out.println("Removido da segunda posição: " + removidoSegunda); // Deve exibir: Removido da segunda
                                                                               // posição: 2
        lista.mostrar(); // Deve exibir: 1 5 7 10
    }
}
