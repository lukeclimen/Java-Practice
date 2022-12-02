public class KangarooHops {

//    You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
//
//    The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
//    The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
//
//    You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.
//
//    Returns string: either YES or NO


    public static String kangaroo(int x1, int v1, int x2, int v2) {

        /*
         * We know that the movement formula (if they meet) looks like
         * x1 + n*v1 = x2 + n*v2; where n is the number of hops
         * Rearranging, we find that if they do line up, the number of hops it takes is:
         * n = (x1 - x2) / (v2 - v1), where n must be an integer >= 0
         * So instead of iterating through, we can just mathematically check
         */

        //First, we must make sure that we aren't dividing by zero
        if (v1 == v2) {
            if (x1 == x2)
                return "YES";
            else
                return "NO";
        }
        else {
            //Next check if n is an integer
            if ((x1-x2) % (v2 - v1) == 0) {
                //Using hops as n from the above formula
                int hops = (x1-x2) / (v2 - v1);
                //Evaluate if hops is a non-negative number
                if (hops >= 0) {
                    //Check for equality
                    if ((x1 + hops * v1) == (x2 + hops * v2))
                        return "YES";
                    else
                        return "NO";
                }
                else
                    return "NO";
            }
            else
                return "NO";
        }
    }
}
