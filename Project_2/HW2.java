import java.io.*;
import java.util.*;

public class HW2 {

  // Prints a list of words that appear in both files.
  public static void intersection(String filename1, String filename2) {
    Set<String> words = new HashSet<String>();
    try (Scanner in1 = new Scanner(new FileReader(filename1));
    Scanner in2 = new Scanner(new FileReader(filename2))) {
      while (in1.hasNextLine()) {         //put words from file1 in the hashSet
        String line = in1.nextLine();
        words.add(line);
      }
      while (in2.hasNextLine()) {
        String line = in2.nextLine();
        if(words.contains(line)){         //check if file2 words are in hashSet
          System.out.println(line);
        }
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  // Prints all words in the file that occur at least k times
  // (print the word followed by the number of occurrences in parentheses).
  // Each line in the file contains only one word.
  public static void frequentWords(String filename, int k) {
    Map<String, Integer> words = new HashMap<String, Integer>();
    try (Scanner in = new Scanner(new FileReader(filename))) {
      while (in.hasNextLine()){
        String line = in.nextLine();
        if(words.containsKey(line))             //if word is in map, increment value
          words.put(line, words.get(line) + 1);
        else                                    //if not, add to map w/ value 1
          words.put(line, 1);
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    for (Map.Entry<String, Integer> entry : words.entrySet()) { //map interation
      if(entry.getValue() >= k)           //if key is at least k, print the entry
        System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
    }
    System.out.println();
  }

  // Returns the string with the characters sorted alphabetically.
  private static String sortString(String s) {
    char[] array = s.toCharArray();
    Arrays.sort(array);
    return new String(array);
  }

  // Prints all sets of anagrams, one set per line.
  // Each line in the file contains only one word.
  public static void anagrams(String filename) {
    Map<String, HashSet<String>> words = new HashMap<String, HashSet<String>>();
    try (Scanner in = new Scanner(new FileReader(filename))) {
      while (in.hasNextLine()){
        String line = in.nextLine();
        //if the sorted word is in the map, add the unsorted word to its hashet
        if(words.containsKey(sortString(line))){
          words.get(sortString(line)).add(line);
        }
        //if the sorted word isn't in the map, add it(as a key) and insert the
        //unsorted word to its hashset
        else{
          words.put(sortString(line), new HashSet<String>());
          words.get(sortString(line)).add(line);
        }
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    for (Map.Entry<String, HashSet<String>> entry : words.entrySet()) { //map iteration
      //don't print unless the key's hashset (value) has more than 1 entry (word)
      if(entry.getValue().size() > 1){
        System.out.print("[");
        for(String i: entry.getValue()){  //print every element (word) in the hashset
          System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("***Intersection***");
    intersection("english_words.txt", "french_words.txt");

    System.out.println("***Frequent words***");
    frequentWords("english_words.txt", 2);

    System.out.println("***Anagrams***");
    anagrams("english_words.txt");
  }
}
