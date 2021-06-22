import java.util.Arrays;
import java.util.Scanner;
public class Collatz
{
    public int length;
    public int[][] table;
    public int size;
    public int upperBound;
    public int lowerBound;
    public int count;
    public Collatz(int a, int b)
    {
        table = new int[b-a + 1][2];
        upperBound = b;
        lowerBound = a;
        size = 0;
        count = 0;
    }
    
    public int collatzLengthCall(int x)
    {
        length = 0;
        int collatz = collatzLength(x);
        table[x-lowerBound][0] = x;
        table[x-lowerBound][1] = collatz;
        size++;

        return collatz;
    }
    
    public int collatzLength(int x)
    {
        if (x - lowerBound < size && x - lowerBound >= 0)
        {
//            System.out.println("working");
            count++;
            return length + table[x-lowerBound][1];
        }
        if (x == 1)
        {
            length++;
            return length;
        }
        else if (x % 2 == 0)
        {
            length++;
            return collatzLength(x / 2);
        }
        else
        {
            length++;
            return collatzLength(3 * x + 1);
        }
    }
    public static void main(String[] args)
    {
        int cur;
        int maxCur = 0;
        int max = 0;

        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter the range: ");
        int a = sc1.nextInt();
        int b = sc1.nextInt();
        if (a < 1 || b > 100000000 || a > 100000000 || b < 1 || a > b)
        {
            System.out.println("Range is invalid.");
            throw new IllegalArgumentException();
        }
        Collatz c = new Collatz(a,b);

        for (int i = a; i <= b; i++)
        {
            cur = c.collatzLengthCall(i);
            if (cur > max)
            {
                max = cur; 
                maxCur = i;
            }
        }
//        for (int i = 0; i < c.size; i++)
//        {
//            for (int j = 0; j < 2; j++)
//            {
//                System.out.printf("%d ", c.table[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(c.count);
        System.out.printf("\nThe number with the maximum Collatz length in the range: %d\nIts Collatz length: %d", maxCur, max);
    }
}
