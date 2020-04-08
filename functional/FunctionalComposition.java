/**
 * Using the and method of Predicate [hard!]. Now, the point of all of this is that filter takes a single
 * Predicate, not multiple Predicates. The goal of this problem is to make filtering more flexible by
 * making similar filtering code, but that accepts any number of Predicates instead of a single Predicate. To accomplish this, 
 * first make a method called allPassPredicate that accepts any number of
 * generically typed Predicates (recall how to use varargs with “...”), and returns a single Predicate
 * that tests if the argument passes all of the input Predicates. Second, make a method called firstAllMatch that takes a Stream 
 * and any number of correspondingly-typed Predicates, and returns the
 * first entry that matches all of the Predicates. Your code will simply make the combined Predicate,
 * then call code like that at the top of the page. For example, if words is a List<String>, the following
 * would find the first word that both contains an “o” and has length greater than 5.
 * FunctionUtils.firstAllMatch(words.stream(),
 * word -> word.contains("o"),
 * word -> word.length() > 5);
* Assuming that you use varargs in your solutions, note that you will receive an odd-sounding warning (not error) 
* about potential heap pollution. It is safe to ignore this error for now, but in the file IO
* lecture we will briefly explain the warning and show how to suppress it with @SafeVarargs.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Optional;

public class FunctionalComposition {

    /**
     * Create a predicate using function composition ( and method )
     * 
     * @param predicates        A list of the conditions that will combined using the and method
     * 
     * @return A predicate with all the conditions
     */
    @SafeVarargs
    public static <T> Predicate<T> allPassPredicate(Predicate<T>... predicates) {

        Predicate<T> returnPredicate = (e) -> true;

        for (Predicate predicate : predicates) {
            returnPredicate.and(predicate);
        }

        return returnPredicate;
    }

    /**
     * Find the first match that matches all the predicates in the function composition
     * 
     * @param chainedPredicate      A predicate with one or more conditions anded together ( Functional Composition)
     * @param words                 The list of words that will be tested with the chained predicate
     */
    public static <T> T firstAllMatch(Stream<T> words, Predicate<T> andPredicates) {
        T result = words.filter(andPredicates).findFirst().orElse(null);

        return result;
    }

    /**
     * A routine to run the function and then print out the results
     * 
     * @param chainedPredicate      A Predicate with one or more conditions anded together
     * @param words                 The list of words that will be tested with the chained predicate
     * 
     */
    public static void conveinanceFunction(Predicate chainedPredicate, List<String> words ) {
        Stream<String> wordsStream = words.stream();
        String result = FunctionalComposition.firstAllMatch(wordsStream, chainedPredicate);
        System.out.printf("For the input %s The firstAllMatch result is %s\n", words.toString(), result);
    }



    public static void main(String... args) {

        List<String> words = new ArrayList<>( Arrays.asList("toaster", "cat", "looking"));
        Stream<String> wordsStream = words.stream();

        Predicate<String>  test1 = ( word ) -> word.contains("o");
        Predicate<String>  test2 = ( word ) -> word.length() > 5;
        
        Predicate chainedPredicate = FunctionalComposition.allPassPredicate(test1, test2);

        FunctionalComposition.conveinanceFunction(chainedPredicate, words);

        words.add(0,"I");
        FunctionalComposition.conveinanceFunction(chainedPredicate, words);
 



    }
}