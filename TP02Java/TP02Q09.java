import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

class Jogador {

    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador() {
    }

    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento,
            String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        if (cidadeNascimento.length() > 0)
            this.cidadeNascimento = cidadeNascimento;
        else
            cidadeNascimento = "nao informado";
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public void imprimir() {
        System.out.println("[" + getId() + " ## " + getNome() + " ## " + getAltura() + " ## " + getPeso() + " ## "
                + getAnoNascimento() + " ## " + getUniversidade() + " ## " + getCidadeNascimento() + " ## "
                + getEstadoNascimento() + "]");
    }
    public int compareTo(Jogador outro) {
        return this.altura - outro.altura;
    }

    public void ler(String linha) {
        String[] data = new String[8];
        int tmp = 0;
        int j = 0;
        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == ',') {
                data[j] = linha.substring(tmp, i);
                tmp = i + 1;
                if (data[j].intern() == "") {
                    data[j] = "nao informado";
                }
                j++;
            }

        }

        data[7] = linha.substring(tmp, linha.length());

        if (data[7] == "") {
            data[7] = "nao informado";
        }
        setId(Integer.parseInt(data[0]));
        setNome(data[1]);
        setAltura(Integer.parseInt(data[2]));
        setPeso(Integer.parseInt(data[3]));
        setUniversidade(data[4]);
        setAnoNascimento(Integer.parseInt(data[5]));
        setCidadeNascimento(data[6]);
        setEstadoNascimento(data[7]);

    }
}

public class TP02Q09 {
    public static int comp=0, mov=0;
    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        ArrayList<Jogador> jogadores = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("/tmp/players.csv");
            BufferedReader arq = new BufferedReader(fileReader);
            arq.readLine();
            while (arq.ready()) {
                Jogador jogador = new Jogador();
                jogador.ler(arq.readLine());
                jogadores.add(jogador);
            }
            arq.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getLocalizedMessage());
        }
        ArrayList<Jogador> escolhidos = new ArrayList<>();
        String input = sc.nextLine();
        while (!input.equals("FIM")) {
            escolhidos.add(jogadores.get(Integer.parseInt(input)));
            input = sc.nextLine();
        }
        heapSort(escolhidos);
        for (int i = 0; i < escolhidos.size(); i++) {
            escolhidos.get(i).imprimir();
        }

        long tempoFinal = System.currentTimeMillis();
        try {
            FileWriter fileWriter = new FileWriter("matricula_heapsort.txt");
            BufferedWriter arq = new BufferedWriter(fileWriter);
            arq.write("Matricula: 802742\tTempo: " + (tempoFinal - tempoInicial) / 1000d + "\tComparações: " + comp + "\tMovimentações: " + mov);
            arq.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getLocalizedMessage());
        }

        sc.close();

    }

    
    public static void heapSort(ArrayList<Jogador> array) {
        int n = array.size();
        // Construindo heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        // Tirando um or um
        for (int i = n - 1; i >= 0; i--) {
            // Raiz para o fim do array
            Jogador temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);
            mov+=3;
            // Chame heapify no heap reduzido
            heapify(array, i, 0);
        }
    }

    public static void heapify(ArrayList<Jogador> array, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
    
        comp++;
        if (esquerda < n && (array.get(esquerda).compareTo(array.get(maior)) > 0
            || (array.get(esquerda).compareTo(array.get(maior)) == 0 
                && array.get(esquerda).getNome().compareTo(array.get(maior).getNome()) > 0))) {
            maior = esquerda;
        }
        comp++;
        if (direita < n && (array.get(direita).compareTo(array.get(maior)) > 0
            || (array.get(direita).compareTo(array.get(maior)) == 0 
                && array.get(direita).getNome().compareTo(array.get(maior).getNome()) > 0))) {
            maior = direita;
        }
    
        if (maior != i) {
            Jogador swap = array.get(i);
            array.set(i, array.get(maior));
            array.set(maior, swap);
            mov+=3;
            heapify(array, n, maior);
        }
    }
    
}