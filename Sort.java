/**
 * Implement a Java method that takes as arguments an array and another value.
 *
 * The method returns the position (index) of the value in the array.
 *         For example, given an array {21, 3, 67, -8} and value 3, the routine should
 *         return 1 (since 3 occurs at position 1 in the array (what is the first index in a Java array?)).
 *         If the value is not found in the array, return -1.
 *
 * Your method should accept generic parameters so that arrays and values of various types can be passed in.
 *         Any single method call will pass in a value and an array of the same type.
 *         Write your method to be as flexible as possible in other ways as well;
 *         e.g. do not hard-code the length of the array that is passed in.
 *
 * This method does not output anything to the screen.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Sort <T extends Comparable<T>> {

    public Sort() {
    }

    private ArrayList<T> inputList = new ArrayList<T>();

    public ArrayList<T> getList() {
        return inputList;
    }

    public void addItem(T item) {
        getList().add(item);
    }

    public T getItemFromPos(int pos) {
        return getList().get(pos);
    }

    public int getItem(T item) {
        try {
            for(int i = 0; i < getList().size(); i++) {
                try {
                    if(getItemFromPos(i).compareTo(item) == 0){
                        System.out.println("ArrayList item \"" + item + "\" found! (" + i + ")");
                        return i;
                    }
                } catch(Exception e){
                    System.out.println("ArrayList item \"" + item + "\" not found. (-1)");
                }
            }

            return -1;

        } catch(Exception e) {
            System.out.println("ERROR: Could not parse ArrayList. See stacktrace. (-2)");
            e.printStackTrace();
        }
        return -2;
    }

    public T userPrompt(Scanner scanner) {
        System.out.println("Enter the selection you'd like to find the position of.");
        return (T) scanner.next();
    }
    public void setPosition(T item, int pos) {
        getList().set(pos, item);
    }
}