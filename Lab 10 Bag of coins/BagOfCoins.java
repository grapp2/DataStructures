package solution;

import java.util.HashMap;
/**
 * Bag of coins class. Lab Final Exam
 * 
 * @author GregRapp
 * @version 1.0
 */
public class BagOfCoins
{
    private HashMap<Integer, Integer> bag;
    /**
     * constructor method.
     */
    public BagOfCoins()
    {
        bag = new HashMap<Integer, Integer>(10);
    }

    /**
     * Argument constructor.
     * @param initialCapacity 
     */
    public BagOfCoins(int initialCapacity)
    {
        bag = new HashMap<Integer, Integer>(initialCapacity);
    }

    /**
     * add new coin.
     * @param coin 
     */
    public void add(int coin)
    {
        Integer value;

        if (bag.containsKey(coin))
        {
            value = bag.get(coin);
        }
        else
        {
            value = 0;
        }

        bag.put(coin, ++value);
    }

    /**
     * accessor method.
     * @param coin 
     * @return number of times coin occurs 
     */
    public int countOccurrences(int coin)
    {
        if (bag.containsKey(coin))
            return bag.get(coin);
        else
            return 0;
    }

    /**
     * remove method.
     * @param coin 
     * @return boolean 
     */
    public boolean remove(int coin)
    {
        if (bag.containsKey(coin))
        {
            Integer value = bag.get(coin);
            if (value > 0)
            {
                bag.put(coin, --value);
                return true;
            }
            else if (value == 0)
            {
                bag.remove(coin);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * accessor for size.
     * @return size
     */
    public int size()
    {
        return bag.size();
    }

    /**
     * total value of coins in bag
     * @return total value
     */
    public int totalValue()
    {
        int numberOfPennies = 0;
        int numberOfNickels = 0;
        int numberOfDimes = 0;
        int numberOfQuarters = 0;
        if (bag.containsKey(1))
        {
            numberOfPennies = bag.get(1);
        }
        else if (bag.containsKey(5))
        {
            numberOfNickels = bag.get(5);
        }
        if (bag.containsKey(10))
        {
            numberOfDimes = bag.get(10);
        }
        if (bag.containsKey(25))
        {
            numberOfQuarters = bag.get(25);
        }
        

        return (numberOfPennies + numberOfNickels * 5 + numberOfDimes * 10 + numberOfQuarters * 25);
    }

    public static void main(String[] args)
    {
        BagOfCoins a = new BagOfCoins(5);
        a.add(10);
        a.add(10);
        a.add(10);

        System.out.println(a.size());

    }
}
/*
test change
*/
