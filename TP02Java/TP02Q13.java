import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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

    public static Comparator<Jogador> UniversidadeNomeComparator = new Comparator<Jogador>() {
        @Override
        public int compare(Jogador jogador1, Jogador jogador2) {
            int resultado = jogador1.getUniversidade().compareTo(jogador2.getUniversidade());
            if (resultado == 0) {
                return jogador1.getNome().compareTo(jogador2.getNome());
            }
            return resultado;
        }
    };
}

public class TP02Q13 {
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
		String id = sc.nextLine();
		while (!id.equals("FIM")) {
				escolhidos.add(jogadores.get(Integer.parseInt(id)));
				id = sc.nextLine();
		}

		MergeSort(escolhidos, Jogador.UniversidadeNomeComparator);
		for (int i = 0; i < escolhidos.size(); i++) {
			escolhidos.get(i).imprimir();
		}

		sc.close();

		long tempoFinal = System.currentTimeMillis();
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("matrícula_merge.txt"));
			escritor.write("Matrícula: 802742" + "\tComparações: " + comp + "\tMovimentações: " + mov
					+ "\tExecução: " + ((tempoFinal - tempoInicial) / 1000d) + "ms");
			escritor.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}


    public static void MergeSort(ArrayList<Jogador> escolhidos, Comparator<Jogador> comparator) {
        if (escolhidos.size() > 1) {
            int meio = escolhidos.size() / 2;
            ArrayList<Jogador> esq = new ArrayList<>(escolhidos.subList(0, meio));
            ArrayList<Jogador> dir = new ArrayList<>(escolhidos.subList(meio, escolhidos.size()));

            MergeSort(esq, comparator);
            MergeSort(dir, comparator);

            int i = 0, j = 0, k = 0;
            while (i < esq.size() && j < dir.size()) {
				comp++;
                if (comparator.compare(esq.get(i), dir.get(j)) < 0) {
                    escolhidos.set(k++, esq.get(i++));
					mov++;
                } else {
                    escolhidos.set(k++, dir.get(j++));
					mov++;
                }
            }

            while (i < esq.size()) {
                escolhidos.set(k++, esq.get(i++));
				mov++;
            }

            while (j < dir.size()) {
                escolhidos.set(k++, dir.get(j++));
				mov++;
            }
        }
    }
	
}