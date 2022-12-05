package Parser;

/*
    Given a block of text, please write a parser that can generate a list of unique word pairs and their corresponding
    occurrence count in the text.  The parser should spit out the word pair sorted from most frequently occurring to
    least.  Please include the result files for the 2 input documents we provided.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WordPairParser {

    public static void main(String[] args) {

            // Using a hashmap to store the word pairs, using the paired string as the key
            HashMap<String, Integer> wordPairs = new HashMap<>();
            ArrayList<Object> sortedList = new ArrayList<>();
            Scanner input = new Scanner(System.in);

            System.out.print("Please type the file (including extension) to parse: ");
            String fileName = input.nextLine();
            input.close();

            // Store the file contents in the wordPairs hashmap
            storeHashMap(wordPairs, fileName);

            // Sort the hashmap by value into an arraylist
            sortHashMap(wordPairs, sortedList);

            // Write the sorted list to a file
            writeSortedData(sortedList);
    }

    // Private method for storing the word pairs in a hashmap
    private static void storeHashMap(HashMap<String, Integer> hashMap, String fileName) {
        try {
            /* Read in file */
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            // Regex to filter non-alphabet characters
            String nonAlpha = "[^a-zA-Z]+";

            String word1, word2;
            // Initialize word1 to have the first word of the file
            word1 = String.valueOf(fileScanner.next()).replaceAll(nonAlpha, "").toLowerCase();

            // Iterate through the words in the file
            while (fileScanner.hasNext()) {
                // Remove any non-alpha characters in the word, and convert it to lowercase
                word2 = String.valueOf(fileScanner.next()).replaceAll(nonAlpha, "").toLowerCase();

                // Handling edge case of extra spaces creating empty string words
                if (word2.equals("")) {
                    continue;
                }

                // Add word pairing into the hashmap, incrementing the value if it exists
                hashMap.put(word1+"-"+word2, hashMap.getOrDefault(word1+"-"+word2, 0) + 1);

                // Going into the next loop iteration, shift the words over (word2 -> word1)
                word1 = word2;
            }

            fileScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error while reading in file");
            e.printStackTrace();
        }
    }

    // Private method to sort the word pairings into an arraylist
    private static void sortHashMap(HashMap<String, Integer> hashMap, ArrayList<Object> arrayList) {

        // This works to sort the hashmap entries by value, but reverses order (1 -> 100)
        hashMap.entrySet()
                // From the documentation online, I think this is unavoidable because of stream()
                .stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(stringIntegerEntry -> arrayList.add(stringIntegerEntry));
    }

    // Private method for writing the sorted word pairs to a file
    private static void writeSortedData(ArrayList<Object> reversedList) {
        // Because we have stored the word pairings in the reverse order that we want,
        // File entry will take place from high index to low index
        try {
            // Create a new file to store our word pair output
            FileWriter fileWriter = new FileWriter("Word_Pairs.txt");

            for (int i = reversedList.size() - 1; i > 0; i--) {
                fileWriter.write(reversedList.get(i).toString() + "\n");
            }

            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
