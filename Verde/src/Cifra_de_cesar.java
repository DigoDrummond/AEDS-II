
import java.util.*;

public class Cifra_de_cesar {

    public static final int KEY = 3;

    public static void main(String[] args) {
        /* usa a chave para imprimir os números com a cifra de César
         * Ex: "ABCD" SE TRANSFORMA EM "DEFG" movendo cada elemento 3 posições na tabela ASCII
         */
        String file1 = "";
        Scanner sc = new Scanner(System.in);
        while (!file1.equals("FIM")) {
            file1 = sc.nextLine();
            if (!file1.equals("FIM")) {
                char[] array = file1.toCharArray();
                int size = file1.length();
                int[] ascii = new int[size];

                for (int i = 0; i < size; i++) {
                	if(array[i]<32 || array[i] >126)
                		array[i] = array[i];
                	else
                    ascii[i] = (int) array[i] + KEY;
                }
                char[] cesarArray = new char[size];

                for (int i = 0; i < size; i++)
                    cesarArray[i] = (char) ascii[i];

                String encryptedText = new String(cesarArray);

                System.out.println(encryptedText + "\n");
            }
        }
    }

}
