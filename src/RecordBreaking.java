import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordBreaking {

    /*
     * A player tabulates the number of times she breaks her season record for most points and least points in a game.
     * Points scored in the first game establish her record for the season, and she begins counting from there.
     *
     * breakingRecords reads in a List of integers
     *
     * breakingRecords returns a List  with the numbers of times she broke her records.
     *      index 0 of the returned List is the number of times she broke her max points record
     *      index 0 of the returned List is the number of times she broke her min points record
     *
     */

    public static void main (String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10,5,20,4,5,2,25,1));
        System.out.println(breakingRecords(list));
    }

    private static List<Integer> breakingRecords(List<Integer> scores) {
        //Want to set the first value of the list as the min and max

        //Instantiate the list we will return
        List<Integer> maxMin = new ArrayList<>();

        //Check for an empty list
        if (scores.size() == 0) {
            maxMin.add(0);
            maxMin.add(0);
        }
        //Otherwise, if it's not empty, go ahead with analysis
        else {
            int min = scores.get(0);
            int minCount = 0;
            int max = scores.get(0);
            int maxCount = 0;

            //Iterate through the list starting with the second element
            for (int i = 1; i < scores.size(); i++) {
                if (scores.get(i) < min) {
                    minCount++;
                    min = scores.get(i);
                }
                else if (scores.get(i) > max) {
                    maxCount++;
                    max = scores.get(i);
                }
            }
            maxMin.add(maxCount);
            maxMin.add(minCount);
        }

        return maxMin;
    }
}
