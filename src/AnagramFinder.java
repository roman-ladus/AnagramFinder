import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * AnagramFinder reads a .txt file and groups words that are anagrams.
 */
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

    /**
     * Generates a sorted character signature for a string.
     *
     * @param word Input string
     * @return Sorted characters as a string
     */
    private static String toSignature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * Prints all groups of anagrams.
     */
    private static void printDict(Map<String, List<String>> dict) {
        for (List<String> values : dict.values()) {
            System.out.println(String.join(" ", values));
        }
    }

}