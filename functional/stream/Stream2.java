/**
 * For these exercises, start with a List of Strings similar to this: List<String> words = Arrays.asList("hi", "hello", ...);
 *
 * Produce a single String that is the result of concatenating the uppercase versions of all of the
 *  Strings. E.g., the result should be "HIHELLO...". Use a single reduce operation, without using map.
 * 
 * Produce the same String as above, but this time via a map operation that turns the words into upper
 * case, followed by a reduce operation that concatenates them.
 *
 * Produce a String that is all the words concatenated together, but with commas in between. E.g., the
 * result should be "hi,hello,...". Note that there is no comma at the beginning, before “hi”, and also no
 * comma at the end, after the last word. Major hint: there are two versions of reduce discussed in the
 * notes.
 * 
 * Find the total number of characters (i.e., sum of the lengths) of the strings in the List.
 *
 * Find the number of words that contain an “h”.
 */

import java.util.List;
import java.util.Arrays;

public class Stream2 {

    public static void main(String... args) {

        List<String> words = Arrays.asList("hi", "hello", "aloh", "bye", "goodbye", "aloh");


        String answer = words.stream().reduce("", (x,y) -> x + y.toUpperCase());
        System.out.println("The answer is " + answer);
    



    }
}