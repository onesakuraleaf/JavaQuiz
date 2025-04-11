//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadContentFromDatabase {

    public static String readFileContent(String fileName) {
        StringBuilder content = new StringBuilder();

        try {
            String line;
            try (
                    InputStream inputStream = ReadContentFromDatabase.class.getResourceAsStream("content/" + fileName);
                    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            ) {
                try (BufferedReader br = new BufferedReader(reader)) {
                    if (inputStream != null) {
                        while((line = br.readLine()) != null) {
                            content.append(line).append("\n");
                        }

                        return content.toString();
                    }

                    System.out.println("A fájl nem található: " + fileName);
                    line = "HIBA: A fájl nem található!";
                }
            }

            return line;
        } catch (Exception e) {
            e.printStackTrace();
            return "HIBA: Nem sikerült beolvasni a fájlt!";
        }
    }
}
