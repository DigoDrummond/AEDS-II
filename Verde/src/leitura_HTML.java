//vogal normal, circunflexo, crase, tiu(a,o), chapeuzinho
//consoantes

import java.net.*;
import java.io.*;
import java.util.*;

public class leitura_HTML {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String name = "";
		while (!isFim(name)) {
			name = sc.nextLine();
			if (!isFim(name)) {
				String address = sc.nextLine();
				// String encodedAddress = URLEncoder.encode(address, "UTF-8");
				int consoante = 0;
				int aNormal = 0, aCircunflexo = 0, aCrase = 0, aTiu = 0, aChapeu = 0;
				int eNormal = 0, eCircunflexo = 0, eCrase = 0, eChapeu = 0;
				int iNormal = 0, iCircunflexo = 0, iCrase = 0, iChapeu = 0;
				int oNormal = 0, oCircunflexo = 0, oCrase = 0, oTiu = 0, oChapeu = 0;
				int uNormal = 0, uCircunflexo = 0, uCrase = 0, uChapeu = 0;
				int temBr = 0, temTable = 0;

				URL url = new URL(address);
				URLConnection connect = url.openConnection();
				InputStream is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				PrintStream ps = new PrintStream(System.out, true, "UTF-8"); // Especificando a codificação UTF-8
				System.setOut(ps);


				String linha = br.readLine();

				while (linha != null) {

					// System.out.println(linha);
					char[] line = linha.toCharArray();
					for (int i = 0; i < line.length; i++) {
						// a
						if (line[i] == '\u0061' )
							aNormal++;
						else if (line[i] == '\u00E1' )
							aCircunflexo++;
						else if (line[i] == '\u00E0' )
							aCrase++;
						else if (line[i] == '\u00E3' )
							aTiu++;
						else if (line[i] == '\u00E2' )
							aChapeu++;
						// e
						else if (line[i] == '\u0065' )
							eNormal++;
						else if (line[i] == '\u00E9' )
							eCircunflexo++;
						else if (line[i] == '\u00E8' )
							eCrase++;
						else if (line[i] == '\u00EA' )
							eChapeu++;
						// i
						else if (line[i] == '\u0069' )
							iNormal++;
						else if (line[i] == '\u00ED' )
							iCircunflexo++;
						else if (line[i] == '\u00EC' )
							iCrase++;
						else if (line[i] == '\u00EE' )
							iChapeu++;
						// o
						else if (line[i] == '\u006F' )
							oNormal++;
						else if (line[i] == '\u00F3' )
							oCircunflexo++;
						else if (line[i] == '\u00F2' )
							oCrase++;
						else if (line[i] == '\u00F5' )
							oTiu++;
						else if (line[i] == '\u00F4' )
							oChapeu++;
						// u
						else if (line[i] == '\u0075' )
							uNormal++;
						else if (line[i] == '\u00FA' )
							uCircunflexo++;
						else if (line[i] == '\u00F9' )
							uCrase++;
						else if (line[i] == '\u00FB' )
							uChapeu++;
						// FIM VOGAIS
						// Consoantes
						else if (isConsonant(line[i]))
							consoante++;
						if (isBr(linha))
							temBr++;
						if (isTable(linha))
							temTable++;
					}
					linha = br.readLine();

				}
				// int aFinal = aNormal - aCircunflexo - aCrase - aTiu - aChapeu;
				System.out.printf("a(" + aNormal + ") " + "e(" + eNormal + ") " + "i(" + iNormal + ") " + "o(" + oNormal
						+ ") " + "u(" + uNormal + ") ");
				System.out.printf('\u00E1' + "(" + aCircunflexo + ") " + '\u00E9'+ "(" + eCircunflexo + ") " + '\u00ED'+"(" + iCircunflexo + ") "
						+ '\u00F3'+"(" + oCircunflexo + ") " + '\u00FA'+"(" + uCircunflexo + ") ");
				System.out.printf('\u00E0'+"(" + aCrase + ") " + '\u00E8'+"(" + eCrase + ") " + '\u00EC'+"(" + iCrase + ") " + '\u00F2'+"(" + oCrase
						+ ") " + '\u00F9'+"(" + uCrase + ") ");
				System.out.printf('\u00E3'+"(" + aTiu + ") " + '\u00F5'+"(" + oTiu + ") ");
				System.out.printf('\u00E2'+"(" + aChapeu + ") " + '\u00EA'+"(" + eChapeu + ") " + '\u00EE'+"(" + iChapeu + ") " + '\u00F4'+"(" + oChapeu
						+ ") " + '\u00FB'+"(" + uChapeu + ") ");
				System.out.printf(
						"consoante(" + consoante + ") " + "<br>(" + temBr + ") " + "<table>(" + temTable + ") " + name + "\n");
				
				br.close();
				isr.close();
				is.close();
			}
		}
		sc.close();
		
	}

	public static boolean isConsonant(char c) {
		String consonants = "bcdfghjklmnpqrstvwxyz";
		return consonants.indexOf(c) >= 0;
	}

	public static boolean isBr(String linha) {
		String br = "<br>";
		if (linha.contains(br))
			return true;
		return false;
	}

	public static boolean isTable(String linha) {
		String table = "<table>";
		if (linha.contains(table))
			return true;
		return false;
	}

	public static boolean isFim(String str) {
		if (str.length() != 3)
			return false;

		char[] fim = { 'F', 'I', 'M' };

		for (int i = 0; i < 3; i++) {
			if (str.charAt(i) != fim[i]) {
				return false;
			}
		}

		return true;
	}

}
