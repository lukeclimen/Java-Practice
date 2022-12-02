import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchingStrings {

    public static void main (String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("aba", "baba", "aba", "xzxb"));
        List<String> queries = new ArrayList<>(Arrays.asList("aba", "xzxb", "ab"));
        System.out.println(matchingStrings(strings, queries));
    }

    private static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        //Creating a list for the query matches
        List<Integer> matches = new ArrayList<>();

        //Creating a boolean array to skip over already-matched elements
        //boolean[] hasMatched = new boolean[strings.size()];

        //Iterate through the query array
        for (int queryElement = 0; queryElement < queries.size(); queryElement++) {

            //Capture the current query string, and initialize its counter to 0
            String queryString = queries.get(queryElement);
            int queryMatches = 0;

            //Also grab the current size of the strings array
            int stringArraySize = strings.size();

            //Iterate through the strings array to check for matches
            for (int stringElement = 0; stringElement < stringArraySize; stringElement++) {

                if (queryString == strings.get(stringElement)) {

                    //If we find a match, increment the counter and remove this element from the
                    //Strings array, assuming there is no duplicate queries
                    queryMatches++;
                    strings.remove(stringElement);
                    stringArraySize -= 1;
                }
            }

            //Add the amount of matches to our matches list
            matches.add(queryMatches);
        }
        return matches;
    }
}
