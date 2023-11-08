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

class Queue {
    private Celula primeiro, ultimo;

    public Queue() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Can't remove from empty Queue!");
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public int remover2() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Can't remove from empty Queue!");
        }
        Celula tmp = primeiro.prox;
        primeiro.prox = primeiro.prox.prox;
        int resp = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public void mostrar() {
        System.out.println("[]");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.println(i.elemento + " ");
        }
        System.out.println("]");
    }

    public int maior() {
        int maior = primeiro.prox.elemento;
        Celula i = primeiro.prox.prox;
        while (i != null) {
            if (i.elemento > maior) {
                maior = i.elemento;
            }
            i = i.prox;
        }
        return maior;
    }

    public int terceiroElemento() {
        return primeiro.prox.prox.prox.elemento;
    }

    public int soma() {
        int sum = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            sum += i.elemento;
        }
        return sum;
    }

    public void inverte() {
        Celula fim = ultimo;
        while (primeiro != fim) {
            Celula nova = new Celula(primeiro.prox.elemento);
            nova.prox = fim.prox;
            fim.prox = nova;
            Celula tmp = primeiro.prox;
            primeiro.prox = tmp.prox;
            nova = tmp = tmp.prox = null;
            if (ultimo == fim) {
                ultimo = ultimo.prox;
            }
        }
    }

    public int contar(Celula i){
        int resp = 0;
        if(i == null){
            resp = 0;
        }else if(i.elemento % 2 == 0 && i.elemento % 5 == 0){
            resp = 1+ contar(i.prox);
        }else{
            resp = contar(i.prox);
        }
        return resp;
    }
     public int contar(){
        return contar(primeiro.prox);
    }

}

public class Fila {

    public static void main(String[] args) {

    }
}
