import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirthdayChocolate {

    public static void main (String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 2));
        System.out.println(birthday(list, 3, 2));
    }

    public static int birthday(List<Integer> chocolateSquares, int bDay, int bMonth) {
        int waysToDivideChocolate = 0;
        int chocolateCount;
        boolean bMonthMatch = true;

        //Want to iterate through the chocolate bar until we've reached the end
        // minus the number of months in the birthday.
        for (int chunk = 0; chunk <= chocolateSquares.size() - bMonth; chunk++) {
            chocolateCount = chocolateSquares.get(chunk);

            //Iterate until we have as many segments as the birthmonth number
            for (int segments = 1; segments < bMonth; segments++) {
                chocolateCount += chocolateSquares.get(chunk + segments);

                //If our count is greater than the birthday, we can exit this loop early
                if (chocolateCount > bDay) {
                    bMonthMatch = false;
                    break;
                }
            }
            //Double check that we didn't exit early, and see if we have the correct value
            if (bMonthMatch && chocolateCount == bDay) {
                waysToDivideChocolate++;
            }
            bMonthMatch = true;
        }
        return waysToDivideChocolate;
    }
}
