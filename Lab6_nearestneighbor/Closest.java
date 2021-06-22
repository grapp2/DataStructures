import java.io.File;
import java.util.Scanner;
public class Closest
{
    private static final int b = 100;
    private StringNode[][] grid;


    public Closest()
    {
        grid = new StringNode[b][b];
    }

    public void findClosestInSet(String file)
    {
        File f = new File(file);
        int numPoints = 0;
        double minDistance = 100;
        try {
            Scanner sc =i new Scanner(f);
            while (sc.hasNext())
            {
                String x = sc.next();
                String y = sc.next();
                if (grid[hash(x)][hash(y)] != null)
                {
                    grid[hash(x)][hash(y)] = new StringNode(x + " " + y, grid[hash(x)][hash(y)]);
                }
                else
                {
                    grid[hash(x)][hash(y)] = new StringNode(x + " " + y, null);
                }
                numPoints++;
            }
            for (int i = 0; i < b; i++)
            {
                for (int j = 0; j < b; j++)
                {
                    StringNode cur = grid[i][j];
                    while (cur != null)
                    {
                        Scanner sc2 = new Scanner(cur.getKey());
                        String x = sc2.next();
                        String y = sc2.next();
//                        System.out.println(hash(x) + " " + hash(y));
                        double distance = comparePoints(x,y);
//                        System.out.println(distance);

                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
//                        System.out.println(minDistance);
                        cur = cur.getNext();
                        sc2.close();
                    }
                }
            }
            sc.close();
            System.out.println(minDistance);
        }
        catch (Exception e) {
            System.out.println("Cannot open file " + f.getAbsolutePath());
            System.out.println(e);
        }
    }

    public double comparePoints(String x1, String y1)
    {
        double minDistance = 100;
        if (hash(x1) != 0 && hash(x1) != b-1 && hash(y1) != 0 && hash(y1) != b-1)
        {

            for (int i = -1; i <= 1; i++)
            {
                for (int j = -1; j <= 1; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();

                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }
                        System.out.println(distance);
                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        else if (hash(x1) == 0 && hash(y1) == 0)
        {
            for (int i = 0; i <= 1; i++)
            {
                for (int j = 0; j <= 1; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();

                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }
                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        else if (hash(x1) == b-1 && hash(y1) == b-1)
        {
            for (int i = -1; i <= 0; i++)
            {
                for (int j = -1; j <= 0; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();

                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }
                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        else if (hash(x1) == 0 && hash(y1) == b-1)
        {
            for (int i = 0; i <= 1; i++)
            {
                for (int j = -1; j <= 0; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();

                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }
                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        else if (hash(x1) == b-1 && hash(y1) == 0)
        {
            for (int i = -1; i <= 0; i++)
            {
                for (int j = 0; j <= 1; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();

                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }
                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        else if (hash(y1) == 0)
        {
            for (int i = -1; i <= 1; i++)
            {
                for (int j = 0; j <= 1; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();

                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }
                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        else if (hash(y1) == b-1)
        {
            for (int i = -1; i <= 1; i++)
            {
                for (int j = -1; j <= 0; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();

                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }
                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        else if (hash(x1) == 0)
        {
            for (int i = 0; i <= 1; i++)
            {
                for (int j = -1; j <= 1; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();
                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }

                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        else if (hash(x1) == b-1)
        {
            for (int i = -1; i <= 0; i++)
            {
                for (int j = -1; j <= 1; j++)
                {
                    StringNode cur = grid[hash(x1) + i] [hash(y1) + j];
                    while (cur != null)
                    {
                        Scanner sc = new Scanner(cur.getKey());
                        double x2 = sc.nextDouble();
                        double y2 = sc.nextDouble();

                        double distance = 100;
                        if (x2 != Double.parseDouble(x1) && y2 != Double.parseDouble(y1))
                        {
                            distance = Math.sqrt(Math.pow(Double.parseDouble(x1) - x2,2) +
                                Math.pow(Double.parseDouble(y1) - y2, 2));
                        }
                        if (distance < minDistance)
                        {
                            minDistance = distance;
                        }
                        cur = cur.getNext();
                    }
                }
            }
        }
        return minDistance;
    }

    public int hash(String num)
    {
        int index = (int) (Double.parseDouble(num) * b);
        return index;
    }

    public static void main(String[] args)
    {
        Closest a = new Closest();
        a.findClosestInSet("points.txt");
    }
}
