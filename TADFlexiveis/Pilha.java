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

class Stack {
    private Celula topo;

    public Stack() {
        topo = null;
    }

    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    public int remover() throws Exception {
        if (topo == null) {
            throw new Exception("Can't remove form empty stack!");
        }
        int resp = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = tmp = null;
        return resp;

    }

    public void mostrar() {
        System.out.println("[");
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.println(i.elemento);
        }
    }

    public int soma() {
        int sum = 0;
        for (Celula i = topo; i != null; i = i.prox) {
            sum += i.elemento;
        }
        return sum;
    }

    public int somaRecursivo() {
        return somaRecursivo(topo);
    }

    public int somaRecursivo(Celula i) {
        if(i==null){
            return 0;
        }
        return i.elemento + somaRecursivo(i.prox);
    }

    public int maior(){
        Celula i = topo;
        int maior = i.elemento;
        while(i!=null){
            if(i.elemento>maior){
                maior = i.elemento;
            }
            i = i.prox;
        }
        return maior;
    }

    public int maiorRecursivo(){
        return maiorRecursivo(topo);
    }

    public int maiorRecursivo(Celula i){
        int maior = i.elemento;
        if(maior<i.elemento){
            maior = i.elemento;
        }
        maiorRecursivo(i.prox);
        return maior;
    }

    public void mostraOrdemInsercao(Stack x) throws Exception{
       Stack tmp = new Stack();
       Stack reversed = new Stack();
       while(true){
        try{
            int elemento = x.remover();
            reversed.inserir(elemento);
        }catch(Exception e){
            break;
        }
       }
       reversed.mostrar();
    }
}

public class Pilha {
    public static void main(String[] agrs){
        Stack pilha = new Stack();
        try {
            pilha.inserir(5);
            pilha.inserir(10);
            pilha.inserir(3);
            pilha.inserir(7);

            pilha.mostrar();

            System.out.println("Soma dos elementos: " + pilha.soma());
            System.out.println("Soma recursiva: " + pilha.somaRecursivo());
            System.out.println("Maior elemento: " + pilha.maior());
            System.out.println("Maior elemento recursivo: " + pilha.maiorRecursivo());

            System.out.println("Mostrando em ordem de inserção:");
            pilha.mostraOrdemInsercao(pilha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
