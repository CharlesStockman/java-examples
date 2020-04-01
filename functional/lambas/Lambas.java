/**
 * Basic lambdas. Make an array containing a few Strings. Sort it by
 * length (i.e., shortest to longest)
 *
 * reverse length (i.e., longest to shortest)
 *
 * alphabetically by the first character only
 */
package functional.lambas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Lambas {

    /**
     * A function to call the lamba and print the results
     * 
     * data         The List of String being operated on
     * function     The function that will manipulate the data
     * prefix       The string print out before the data is.
     */
    public static void convenienceFunction(List<String> data, Consumer<List<String>> function, String prefix) {
        function.accept(data);
        System.out.println(prefix + data);
    }

    public static void main(String... args) {

        String[] names = new String[] { "Charles", "Barry ", "Alice Stockman", "Dennis", "Elanne" };
        List<String> nameList = Arrays.asList(names);
        System.out.println("The list of names are \t\t\t" + nameList);

        // Shortest to longest 
        Consumer<List<String>> shortestToLongest  = ( strList ) -> Collections.sort( strList, (s1, s2) -> s1.length() -  s2.length() );
        Lambas.convenienceFunction(nameList, shortestToLongest, "The shortest to the longest are\t\t" );

        // Longest to shortest
        Consumer<List<String>> longestToShortest = ( strList ) -> Collections.sort( strList, (s1, s2) -> s2.length() - s1.length() );
        Lambas.convenienceFunction(nameList, longestToShortest, "The longest to the shortest are\t\t" );

        // Alphabetically by first character only 
        Consumer<List<String>> sortByFirstCharacter = ( strList ) -> Collections.sort( strList, (s1, s2) -> s1.charAt(0) - s2.charAt(0) );
        Lambas.convenienceFunction(nameList, sortByFirstCharacter, "The shortest to the longest are\t\t" );
    }
}