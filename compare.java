import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class editdistance {

  private String word2;

  public void recievuser() {
    Scanner get = new Scanner(System.in);

    word2 = get.nextLine().toLowerCase();
    iterate();
  }
/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
  private ArrayList<String> wordstoarray() {
    File dictionaryFile = new File("dictionary.txt");
    String words;

    ArrayList<String> wordinarray = new ArrayList<>();

    try (Scanner scan = new Scanner(dictionaryFile)) {
      int count = 1;
      while (scan.hasNextLine()) {
        for (int i = 0; i < count; i++) {
          while (scan.hasNextLine()) {
            words = scan.nextLine();

            wordinarray.add(i, words);
            count++;
          }
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return (wordinarray); //return array list
  }
/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
  private void iterate() {
    ArrayList<String> last = new ArrayList<>();
    ArrayList<String> a = wordstoarray();
    for (String words : a) {
      int dist = discalc(words, word2);
      if (dist <= 2) {
        last.add(words);
      }
    }
    if (last.size() > 0) {
      System.out.println(" Did you mean ? ");
      for (String sug : last) {
        System.out.print(sug + " ");
      }
    }
  }
/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
  private int discalc(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();

   
    int[][] array = new int[len1 + 1][len2 + 1];

    for (int i = 0; i <= len1; i++) {
      array[i][0] = i;   // to convert the word to empty char
    }

    for (int j = 0; j <= len2; j++) {
      array[0][j] = j;
    }
    for (int i = 0; i < len1; i++) {
      char char1 = word1.charAt(i);
      for (int j = 0; j < len2; j++) {
        char char2 = word2.charAt(j);

       
        if (char1 == char2) {
          array[i + 1][j + 1] = array[i][j];
        } else {
          int replace = array[i][j] + 1;
          int insert = array[i][j + 1] + 1;
          int delete = array[i + 1][j] + 1;
         int min= Math.min(replace,Math.min(insert, delete));

          array[i + 1][j + 1] = min;
        }
      }
    }
    return array[len1][len2];
  }
}
