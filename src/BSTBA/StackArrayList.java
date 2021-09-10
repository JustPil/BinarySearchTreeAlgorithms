package BSTBA;

import java.util.ArrayList;

public class StackArrayList<T> implements StackInterface<T>
{
    private ArrayList<T> arr = new ArrayList<>();

    /**
     * isEmpty Tests if the ArrayList is empty.
     * @return True if the ArrayList is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return arr.isEmpty();
    }

    /**
     * isFull Relays that the ArrayList is not full.
     * @return False, an ArrayList has no maximum upper bound.
     */
    public boolean isFull()
    {
        return false;
    }

    /**
     * pop Removes the most recent addition to the ArrayList.
     */
    public void pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackPop("Pop attempted on an empty stack.");
        }
        arr.remove(arr.size() - 1);
    }

    /**
     * push Adds a new value to the end of the ArrayList.
     * @param t The value to add in the ArrayList.
     */
    public void push(T t)
    {
        arr.add(t);
    }

    /**
     * peek Returns the most recent addition to the ArrayList.
     * @return The value of the most recent addition to the ArrayList.
     */
    public T peek()
    {
        return isEmpty() ? null : arr.get(arr.size() - 1);
    }

    /**
     * clear Removes all additions to the ArrayList.
     */
    public void clear()
    {
        arr.clear();
    }

    /**
     * toString Concatenates the ArrayList values to a String.
     * @return The ArrayList values concatenated as a String.
     */
    public String toString()
    {
        String str = "[ ";
        for(int i = 0; i < arr.size(); i++)
        {
            str += arr.get(i) + " ";
        }
        return str + "]";
    }

    /**
     * swapStart Swaps the first and second elements that were added to the stack.
     */
    public void swapStart()
    {
        if(arr.isEmpty() || arr.get(1) == null)
        {
            return;
        }
        else
        {
            T temp = arr.get(0);
            arr.set(0, arr.get(1));
            arr.set(1, temp);
        }
    }

}
