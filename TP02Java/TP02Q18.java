import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

public class TP02Q18 {
    public static int comp = 0, mov = 0;
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

        } catch (Exception e) {
            e.getMessage();
        }

        ArrayList<Jogador> escolhidos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String id =sc.nextLine();
        while (!id.equals("FIM")) {
                escolhidos.add(jogadores.get(Integer.parseInt(id)));
                id =sc.nextLine();
        }

        quickSortPartial(escolhidos, 0, escolhidos.size() - 1);
        int indice = 10;
        if (indice >= 0 && indice < escolhidos.size()) {
            List<Jogador> sublista = escolhidos.subList(indice, escolhidos.size());
            sublista.clear();
        }
        for (int i = 0; i < 10; i++) {
            escolhidos.get(i).imprimir();
        }
        long tempoFinal = System.currentTimeMillis();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("matrícula_countingsort.txt"));
            bw.write("Matrícula: 802742" + "\tComparações: " + comp + "\tMovimentações: " + mov
                    + "\tExecução: " + ((tempoFinal - tempoInicial) / 1000d) + "ms");
            bw.close();
        } catch (IOException e) {
           e.getMessage();
        }

       sc.close();
    }

    public static void quickSortPartial(ArrayList<Jogador> lista, int esq, int dir) {
        int i = esq, j = dir;
        
        Jogador pivo = lista.get((esq + dir) / 2);
        
        while (i <= j) {
            comp++;
            while (compareJogadores(lista.get(i), pivo) < 0)
                i++;
            comp++;
            while (compareJogadores(lista.get(j), pivo) > 0)
                j--;
    
            if (i <= j) {
                Jogador temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                i++;
                j--;
                mov+=3;
            }
        }
        
        if (esq < j)
            quickSortPartial(lista, esq, j);
        if (i < dir)
            quickSortPartial(lista, i, dir);
    }
    
    public static int compareJogadores(Jogador jogador1, Jogador jogador2) {
        int resultado = jogador1.getEstadoNascimento().compareToIgnoreCase(jogador2.getEstadoNascimento());
        comp++;
        if (resultado == 0) {
            resultado = jogador1.getNome().compareToIgnoreCase(jogador2.getNome());
        }
        
        return resultado;
    }
}