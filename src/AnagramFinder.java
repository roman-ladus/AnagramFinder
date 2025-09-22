import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnagramFinder {

    // Map to store sorted signature as key and list of words as value
    private static Map<String, List<String>> dict = new HashMap<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String temp = toSignature(line);
                dict.computeIfAbsent(temp, k -> new ArrayList<>()).add(line);
            }
            printDict(dict);
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static String toSignature(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static void printDict(Map<String, List<String>> dict) {
        for (Map.Entry<String, List<String>> entry : dict.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            for (String val : values) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}