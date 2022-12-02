import java.util.List;

public class ApplesAndOranges {

//    Sam's house has an apple tree and an orange tree that yield an abundance of fruit.
//    Using the information given below, determine the number of apples and oranges that land on Sam's house.
//
//    Given that leftHouse is the start point, and rightHouse is the endpoint of Sam's house,
//    the apple tree is to the left of the house, and the orange tree is to its right.
//    Assume the trees are located on a single point, where the apple tree is at point appleTree,
//    and the orange tree is at point orangeTree.
//
//    When a fruit falls from its tree, it lands d units of distance from its tree of origin along the x-axis.
//    *A negative value of means the fruit fell units to the tree's left, and a positive value of means it
//    falls units to the tree's right. *
//    Given the value of d for m apples and n oranges, determine how many apples and oranges will fall on
//    Sam's house (i.e., in the inclusive range )?

    public static void countApplesAndOranges(int leftHouse, int rightHouse, int appleTree, int orangeTree, List<Integer> apples, List<Integer> oranges) {

        int applesOnHouse = 0;
        int orangesOnHouse = 0;

        for (int i = 0; i < apples.size(); i++) {
            int distanceThrown = apples.get(i) + appleTree;
            if (distanceThrown >= leftHouse && distanceThrown <= rightHouse)
                applesOnHouse++;
        }

        System.out.println(applesOnHouse);

        for (int i = 0; i < oranges.size(); i++) {
            int distanceThrown = oranges.get(i) + orangeTree;
            if (distanceThrown >= leftHouse && distanceThrown <= rightHouse)
                orangesOnHouse++;
        }
        System.out.println(orangesOnHouse);
    }
}