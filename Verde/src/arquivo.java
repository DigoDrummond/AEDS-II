import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;

public class arquivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "C:\\temp\\ws-eclipse\\Verde\\verde.txt";
        int n = sc.nextInt();
        sc.nextLine();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLine();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String num : nums) {
                bw.write(num);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (RandomAccessFile random = new RandomAccessFile(path, "r")) {
            long position = random.length();
            for (int i = nums.length - 1; i >= 0; i--) {
                position -= (nums[i].length() + System.lineSeparator().length());
                random.seek(position);

                String line = random.readLine();

                if (line != null) {
                    double parsedValue = Double.parseDouble(line);
                    String formattedValue;
                    if (parsedValue == (int) parsedValue) {
                        formattedValue = Integer.toString((int) parsedValue);
                    } else {
                        DecimalFormat decimalFormat = new DecimalFormat("0.000#");
                        formattedValue = decimalFormat.format(parsedValue);
                    }
                    System.out.println(formattedValue);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
