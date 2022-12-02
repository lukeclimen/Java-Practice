import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *
 * This class contains a function that receives a List object (up to n = 2x10^5) of the id's of
 * migratory birds. The program is currently set up for 5 different types of birds, Type 1 through
 * Type 5. The program will return the mode value of the set. Tiebreaks between two bird id's
 * having the same quantity in the set will go to the lower value id (Type 3 beats Type 5). *
 *
 */
public class MigratoryBirds {

    // Testing function
    public static void main (String[] args){
        // Initialize a list
        List<Integer> arr = new ArrayList<>();

        // User changeable size, min and max
        final int ARRAY_SIZE = 500;
        final int MIN = 1;
        final int MAX = 5;

        // Fill the list with random values between 1 and 5
        Random random = new Random();
        for (int i =0; i < ARRAY_SIZE; i++) {
            arr.add(random.nextInt(MAX - MIN) + MIN);
        }
        System.out.println(migratoryBirds(arr));
    }


    // Find the mode (tiebreaks result in smaller ID)
    public static int migratoryBirds(List<Integer> arr) {

        // Create array for the number of instances of each ID (1 - 5)
        int[] idInstances = {0, 0, 0, 0, 0};

        // Loop through the given array
        for (int i = 0; i < arr.size(); i++) {
            // Increment the corresponding array element
            idInstances[arr.get(i) - 1]++;
        }

        // Initialize the variable holding the mode value of id's
        // Initializing to 1 to handle the edge case of an empty set
        int birdType = 1;

        // Initialize the quantity of id's found
        int maxQuantity = 0;

        // Loop through the 5 elements of the id quantities
        for (int i = 0; i < idInstances.length; i++) {

            // Evaluate the mode of the set
            if (idInstances[i] > maxQuantity) {
                birdType = i + 1;
                maxQuantity = idInstances[i];
            }
        }

        return birdType;
    }

}
