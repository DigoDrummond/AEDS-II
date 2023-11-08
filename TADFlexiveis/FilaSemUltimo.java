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

class Queue{
    Celula primeiro;

    Queue(){
        primeiro = new Celula();
    }

    public void inserir(int x){
        Celula i;
        for(i = primeiro;i.prox!=null;i=i.prox);
        i.prox = new Celula(x);
        i=null;
    }

    public int remover() throws Exception{
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp = tmp.prox = null;
        return resp;
    }
}

public class FilaSemUltimo {

}
