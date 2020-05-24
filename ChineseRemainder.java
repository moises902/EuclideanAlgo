//Vince Lepatan

import java.util.ArrayList;

public class ChineseRemainder
{
    public static void main (String [] args)
    {
        int a = 892434, b = 2272019, m = 5, n = 3;

        long s, t;

        ArrayList <Integer> quotients = GettingQuotients(a,b);

        t = getTValue(quotients, gcd(a,b), a, b);

        s = getSValue(quotients, gcd(a, b), a, b);

        long theChineseRemainder = ((b * m * t) + (a * n * s)); // chinese remainder theorem

        System.out.println(theChineseRemainder);
    }


    // This method finds the gcd of a and b
    public static int gcd (int a, int b)
    {
        int remainder = a % b;
        int gcd = 0;

        while (remainder != 0)
        {
            a = b;
            b = remainder;

            remainder = a % b;

            if (remainder != 0)
            {
                gcd = remainder;
            }
        }

        return gcd;
    }

    // Puts the quotients into an array
    public static ArrayList<Integer> GettingQuotients (int a, int b)
    {
        if (b > a)
        {
           int hold = b;
           b = a;
           a = hold;
        }

        ArrayList <Integer> quotients = new ArrayList<>();
        int quotient, i = 0;

        int remainder = a % b;
        quotients.add(a / b);

        while (remainder != 0)
        {
            a = b;
            b = remainder;

            remainder = a % b;
            quotients.add(a / b);
        }

        return quotients;
    }

    // This method does the 'computer way' of the extended euclidean algorithm
    // returns the x value
    public static int getSValue (ArrayList <Integer> quotients, int gcd, int a, int b)
    {
        ArrayList <Integer> xValues = new ArrayList<>();
        ArrayList <Integer> yValues = new ArrayList<>();

        xValues.add(0,0);
        yValues.add(0,1);
        xValues.add(1,1);
        yValues.add(1,-quotients.get(0));

        int zValue = (a * xValues.get(1) + b *yValues.get(1));
        int i = 2;

        while (zValue != gcd && i < quotients.size())
        {
            xValues.add(i, xValues.get(i - 2) - (xValues.get(i - 1) * quotients.get(i - 1)));
            yValues.add(i, yValues.get(i - 2) - (yValues.get(i - 1) * quotients.get(i - 1)));

            zValue = (a * yValues.get(i)) + (b * xValues.get(i));

            if (zValue != 1)
                i++;
        }


        return yValues.get(i);
    }

    // This method does the 'computer way' of the extended euclidean algorithm
    // returns the y value
    public static int getTValue (ArrayList <Integer> quotients, int gcd, int a, int b)
    {
        ArrayList <Integer> xValues = new ArrayList<>();
        ArrayList <Integer> yValues = new ArrayList<>();

        xValues.add(0,0);
        yValues.add(0,1);
        xValues.add(1,1);
        yValues.add(1,-quotients.get(0));

        int zValue = (a * xValues.get(1) + b *yValues.get(1));
        int i = 2;

        while (zValue != gcd && i < quotients.size())
        {
            xValues.add(i, xValues.get(i - 2) - (xValues.get(i - 1) * quotients.get(i - 1)));
            yValues.add(i, yValues.get(i - 2) - (yValues.get(i - 1) * quotients.get(i - 1)));

            zValue = (a * yValues.get(i)) + (b * xValues.get(i));

            if (zValue != 1)
                i++;
        }


        return xValues.get(i);
    }
}
