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
    public static int comp = 0, mov = 0;

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        ArrayList<Jogador> jogadores = new ArrayList<>();

        try {
            FileReader fr = new FileReader("/tmp/players.csv");
            BufferedReader arq = new BufferedReader(fr);

            arq.readLine();

            while (arq.ready()) {
                Jogador jogador = new Jogador();
                jogador.Ler(arq.readLine());
                jogadores.add(jogador);
            }
            arq.close();

        } catch (Exception e) {
           e.getMessage();
        }

        ArrayList<Jogador> selectedOnes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String frase = scanner.nextLine();
        while (!frase.equals("FIM")) {
            int n = Integer.parseInt(frase);
            if (n >= 0 && n < jogadores.size()) {
                selectedOnes.add(jogadores.get(Integer.parseInt(frase)));
                frase = scanner.nextLine();
            } else {
                System.out.println("Indice fora dos limites.");
                frase = scanner.nextLine();
            }
        }

        countingSort(selectedOnes);

        scanner.close();

        long tempoFinal = System.currentTimeMillis();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("matrícula_countingsort.txt"));
            bw.write("Matrícula: 802742" + "\tComparações: " + comp + "\tMovimentações: " + mov
                    + "\tExecução: " + ((tempoFinal - tempoInicial) / 1000d) + "ms");
            bw.close();
        } catch (IOException e) {
           e.getMessage();
        }
    }

    public static int getMaior(ArrayList<Jogador> array) {
        int maior = array.get(0).getAltura();
        for (int i = 0; i < array.size(); i++) {
            comp++;
            if (array.get(i).getAltura() > maior)
                maior = array.get(i).getAltura();
        }
        return maior;
    }

    public static void countingSort(ArrayList<Jogador> A) {
        int[] B = new int[A.size()];
        int[] C = new int[getMaior(A)];
        ArrayList<Jogador> ordenado = new ArrayList<>();
    
        for (int i = 0; i < A.size(); i++) {
            C[A.get(i).getAltura() - 1] += 1;
        }
    
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }
    
        for (int i = A.size() - 1; i >= 0; i--) {
            B[C[A.get(i).getAltura() - 1] - 1] = i;
            C[A.get(i).getAltura() - 1] -= 1;
        }
    
        for (int i = 0; i < B.length; i++) {
            ordenado.add(A.get(B[i]));
        }
    
        for (int i = 0; i < ordenado.size(); i++) {
            for (int j = i + 1; j < ordenado.size(); j++) {
                comp++;
                if (ordenado.get(i).getAltura() == ordenado.get(j).getAltura()) {
                    comp++;
                    if (ordenado.get(i).getNome().compareToIgnoreCase(ordenado.get(j).getNome()) > 0) {
                        // Troque os jogadores de posição se o nome for maior em ordem alfabética
                        Jogador temp = ordenado.get(i);
                        ordenado.set(i, ordenado.get(j));
                        ordenado.set(j, temp);
                        mov+=3;
                    }
                }
            }
        }
    
        for (int i = 0; i < ordenado.size(); i++) {
            ordenado.get(i).imprimir();
        }
    }
}