import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;


public class ackermann {
    public static int calls = 0;

    public static long calcAckermann(long n, long m, Calendar calendar,
                                     Date date, long timediff) {
        ackermann.calls = ackermann.calls + 1;

        Calendar newCalendar = Calendar.getInstance();
        Date NewTime = newCalendar.getTime();

        String milis, seconds, timeString = Long.toString(timediff);
        if (timediff > 999) {
            seconds = timeString.substring(0, timeString.length()-3);
            milis = timeString.substring(timeString.length()-3);
        } else {
            seconds = "0";
            milis = timeString;
        }
        System.out.println("Aufruf " + ackermann.calls + " mit: n = " + n + " , m = " + m +
                           ", timediff: " + seconds + "." + milis + " s");
        if (n == 0)
            return m + 1;
        else if (m == 0)
            return calcAckermann(n-1, 1, calendar, date, NewTime.getTime() -
                                 date.getTime());
        else
            return calcAckermann(n-1, calcAckermann(n, m-1, calendar,
                                                    date, NewTime.getTime() - 
                                                    date.getTime()),
                                 calendar, date, NewTime.getTime() -
                                 date.getTime());
    }

    public static void main(String[] args) {

        long n = 0, m = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("n (long) >>>  ");
            n = scanner.nextLong();
            System.out.printf("n (long) >>>  ");
            m = scanner.nextLong();
            scanner.close();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a long.");
            System.exit(1);
        }

        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        System.out.println(initDate.getTime());

        long result = calcAckermann(n, m, calendar, initDate, 0);
        System.out.println("=> " + result);
    }
}
