package lesson_38._01_bate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static final String PATH_TO_INPUT = "src/lesson_38/_resources/input.file";
    public static final String PATH_TO_OUTPUT = "src/lesson_38/_resources/output.file";

    public static void main(String[] args) {
        System.out.println("==============Scanner=====================");
     /*   try (Scanner sc = new Scanner(new FileInputStream(PATH_TO_INPUT)); // считать
             OutputStream os = new FileOutputStream(PATH_TO_OUTPUT)) { // записать
            while (sc.hasNextLine()) {
                byte[] bytes = sc.nextLine().getBytes();
                os.write(bytes);
                os.write("\n".getBytes());
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
*/
        System.out.println("==============BufferedReader==================");
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_INPUT));
             Stream<String> stream = br.lines();
             Writer wr = new FileWriter(PATH_TO_OUTPUT)) { // можно сочетать FileOutputStream
            String resulString = stream.collect(Collectors.joining("\n"));
            wr.write(resulString);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
