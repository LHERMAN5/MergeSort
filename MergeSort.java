/**
 * Lab 1: Java Basics, Merge Sort and Maven <br />
 * The {@code MergeSort} class
 * @author Lauren Herman
 */
public class MergeSort {

    /**
     * A procedure to merge two halves
     * @param leftside    {@code int[]} The left half of an array
     * @param rightside   {@code int[]} The right half of an array
     * @param number      {@code int[]} The array the two sides are merged into
     * @return returns a merged array of the two sides
     */
    public static int[] merge(int[] leftside, int[] rightside, int[] numbers) {

        //initialize counters for arrays
        int l = 0;
        int r = 0;
        int n = 0;

        //compare each side and sort into numbers
        while ((r<rightside.length)&&(l<leftside.length)) {
            if (leftside[l]<rightside[r]) {
                numbers[n]=leftside[l];
                l++;
            }
            else {
                numbers[n]=rightside[r];
                r++;
            }
            n++;
        }

        //put remaining values into numbers if any
        while (l<leftside.length) {
            numbers[n]=leftside[l];
            l++;
            n++;
        }
        while (r<rightside.length) {
            numbers[n]=rightside[r];
            r++;
            n++;
        }

        return numbers;
    }

    /**
     * The merge sort procedure
     * @param numbers   {@code int[]} The integer array to be sorted
     * @return returns a sorted array
     */
    public static int[] sort(int[] numbers) {
        
        //find center and initialize arrays split by center
        int center = numbers.length/2;
        int[] leftside = new int[center];
        int[] rightside = new int[numbers.length-center];

        //populate array of left half
        for (int i = 0; i < center; i++) {
            leftside[i] = numbers[i];
        }
        //populate array of right half
        for (int i = center; i < numbers.length; i++) {
            rightside[i-center] = numbers[i];
        }

        //sort the halves if they have a length greater than 1
        if (leftside.length>1) {
            leftside = sort(leftside);
        }
        if (rightside.length>1) {
            rightside = sort(rightside);
        }

        //merge the halves
        numbers = merge(leftside, rightside, numbers);

	return numbers;
    }

    /**
     * Main entry: test the HeapSort
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {

        //make/print an array populated with random numbers
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 200);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        //use mergesort to sort them
        numbers = sort(numbers);
        
        //print the sorted array
        for (int n: numbers) {
            System.out.print(n + " ");
        }
        System.out.println(); 
    }
}