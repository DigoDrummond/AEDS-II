import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Jogador {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

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

    public Jogador() {
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
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public void imprimir() {
        System.out.println("[" + id + " ## " + nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## "
                + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento + "]");
    }

    public void Ler(String linha) {
        int j = 0;
        char c = ',';
        int tmp = 0;
        String vetorStr[] = new String[8];
        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == c) {
                vetorStr[j] = linha.substring(tmp, i);
                tmp = i + 1;
                if (vetorStr[j].intern() == "") {
                    vetorStr[j] = "nao informado";
                }
                j++;
            }
        }
        vetorStr[7] = linha.substring(tmp, linha.length());
        if (vetorStr[7].intern() == "") {
            vetorStr[7] = "nao informado";
        }

        setId(Integer.parseInt(vetorStr[0]));
        setNome(vetorStr[1]);
        setAltura(Integer.parseInt(vetorStr[2]));
        setPeso(Integer.parseInt(vetorStr[3]));
        setUniversidade(vetorStr[4]);
        setAnoNascimento(Integer.parseInt(vetorStr[5]));
        setCidadeNascimento(vetorStr[6]);
        setEstadoNascimento(vetorStr[7]);
    }
}

public class TP02Q11 {
    public static int countComp = 0, countMov = 0;

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        ArrayList<Jogador> jogadores = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("/tmp/players.csv");
            BufferedReader arq = new BufferedReader(fileReader);

            arq.readLine();

            while (arq.ready()) {
                Jogador jogador = new Jogador();
                jogador.Ler(arq.readLine());
                jogadores.add(jogador);
            }
            arq.close();

        } catch (Exception FileNotFoundException) {
            System.out.println("Erro para abrir o arquivo");
        }

        ArrayList<Jogador> escolhidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        while (!id.equals("FIM")) {
            escolhidos.add(jogadores.get(Integer.parseInt(id)));
            id = scanner.nextLine();

        }

        countingSort(escolhidos);
        for (int i = 0; i < escolhidos.size(); i++) {
            escolhidos.get(i).imprimir();
        }

        scanner.close();

        long tempoFinal = System.currentTimeMillis();
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("matrícula_insercao.txt"));
            escritor.write("Matrícula: 803716" + "\tComparações: " + countComp + "\tMovimentações: " + countMov
                    + "\tExecução: " + ((tempoFinal - tempoInicial) / 1000d) + "ms");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
        }
    }

    public static void countingSort(ArrayList<Jogador> array) {
        // Encontra maior altura
        int maiorAltura = 0;
        for (Jogador jogador : array) {
            if (jogador.getAltura() > maiorAltura) {
                maiorAltura = jogador.getAltura();
            }
        }

        // Array que armazena contagens
        int[] countingArray = new int[maiorAltura + 1];

        // Preenche o array de contagem
        for (Jogador jogador : array) {
            countingArray[jogador.getAltura()]++;
        }

        // Reconstrói array, porém ordenado
        ArrayList<Jogador> sortedArray = new ArrayList<>(array.size()); // Array ordenado
        for (int altura = 0; altura <= maiorAltura; altura++) {
            while (countingArray[altura] > 0) {
                // Adicione o jogador ao array ordenado
                sortedArray.add(array.get(altura));
                countingArray[altura]--;
            }
        }
        array.clear();
        array.addAll(sortedArray);
    }

}