import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * A class that is for our Lab 3.
 */
public class Sept19Lab {
    /**
     * The main for Lab 3.
     * @param args is an argument
     */
    public static void main(final String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a word to find in the source: ");
       String wordToFind = sc.nextLine();
       String urlText = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
       System.out.println(wordCount(urlText));
       System.out.println(wordInstances(urlText, wordToFind));
    }

    /**
     * Determines how many instances of a word are in the string that is looked at.
     * @param textToCheck is the string that is looked at
     * @param wordToFind is the word being searched for
     * @return returns the number of words in the text
     */
    public static int wordInstances(final String textToCheck, final String wordToFind) {
        int wordCount = 0;
        int textToCheckLength = textToCheck.length();
        int wordToFindLength = wordToFind.length();
        for (int i = 0; i < textToCheckLength - wordToFindLength; i++) {
            if (textToCheck.substring(i, i + wordToFindLength).equalsIgnoreCase(wordToFind)) {
                wordCount++;
            }
        }
        return wordCount;
     }

    /**
     * Determines how many words are in the string being looked at.
     * @param textToCheck is the string that is looked at
     * @return returns the number of words in the text
     */
    public static int wordCount(final String textToCheck) {
        int wordCount = 0;
        int textToCheckLength = textToCheck.length();
        for (int i = 0; i < textToCheckLength - 1; i++) {
            if (textToCheck.charAt(i) == ' ' || textToCheck.charAt(i) == '\t') {
                if (textToCheck.charAt(i + 1) != ' ' && textToCheck.charAt(i + 1) != '\t') {
                    wordCount++;
                }
            }
        }
        wordCount++;
        return wordCount;
     }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
