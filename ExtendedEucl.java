// Vince Lepatan

import java.util.ArrayList;

public class ExtendedEucl
{
    public static void main (String [] args)
    {
        int a = 2272019, b = 892434;

        ArrayList <Integer> quotients = GettingQuotients(a,b);

        System.out.println(xValue(quotients));
    }

    // Puts the quotients into an array
    public static ArrayList <Integer> GettingQuotients (int a, int b)
    {
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
    public static int xValue (ArrayList <Integer> quotients)
    {
        int [] xValues = new int[13];
        int [] yValues = new int[13];

        xValues [0] = 0;
        yValues [0] = 1;
        xValues [1] = 1;
        yValues [1] = - quotients.get(0);
        System.out.println(yValues [1]);

        int zValue = (892434 * yValues [1]) + (2272019 * xValues [1]);
        int i = 2;

        while (zValue != 1)
        {
            xValues[i] = xValues[i - 2] - (xValues[i - 1] * quotients.get(i - 1));
            System.out.println("X = " + xValues [i]);
            yValues[i] = yValues[i - 2] - (yValues[i - 1] * quotients.get(i - 1));
            System.out.println("Y = " + yValues [i]);

            zValue = (892434 * yValues[i]) + (2272019 * xValues[i]);

            if (zValue != 1)
                i++;
        }

        return yValues [i];
    }

    // This method does the 'computer way' of the extended euclidean algorithm
    // returns the y value
    public static int yValue (ArrayList <Integer> quotients)
    {
        int [] xValues = new int[13];
        int [] yValues = new int[13];

        xValues [0] = 0;
        yValues [0] = 1;
        xValues [1] = 1;
        yValues [1] = - quotients.get(0);

        int zValue = (892434 * yValues [1]) + (2272019 * xValues [1]);
        int i = 2;

        while (zValue != 1)
        {
            xValues[i] = xValues[i - 2] - (xValues[i - 1] * quotients.get(i - 1));
            yValues[i] = yValues[i - 2] - (yValues[i - 1] * quotients.get(i - 1));

            zValue = (892434 * yValues[i]) + (2272019 * xValues[i]);

            if (zValue != 1)
                i++;
        }

        return xValues [i];
    }
}
