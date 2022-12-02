public class StringSubstring
{
    public static void main (String[] args) {
        String s = "12:05:39AM";
        System.out.println(timeConversion(s));
    }

    public static String timeConversion(String s) {

        String updatedHours;
        int hours = Integer.valueOf(s.substring(0,2));

        //Case that it is an AM time
        if (s.charAt(8) == 'A') {
            //Special cases occur when the hour is 12
            if (hours == 12) {
                //12:xx:xx AM is registered on a 24 clock as 00:xx:xx
                updatedHours = "00" + s.substring(2, 8);
            }
            else
                updatedHours = s.substring(0, 8);
        }
        //Case that it is a PM time
        else {
            //PM time means that we're actually 12 hours ahead on a 24h clock
            hours = hours + 12;

            //If we have exceeded 24 hours, we need to roll it over
            if (hours > 24) {
                hours = hours - 24;
                //Concatenate a 0 on the front of the single digit value
                updatedHours = "0" + String.valueOf(hours) + s.substring(2, 8);
            }
            //If our hours is 24 right on, we need to drop it back down to 12
            else if (hours == 24) {
                updatedHours = "12" + s.substring(2,8);
            }
            //Otherwise, we have a value between 12 and 23
            else
                updatedHours = String.valueOf(hours) + s.substring(2, 8);
        }
        return updatedHours;
    }
}

