import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahesh on 12/20/16.
 */

public class TestCase {
    int[] array;
    int numberOfQueries;
    int[] maxElements;
    private boolean areSubArraysSorted;
    List<SubArray> sortedSubArrays;

    public int getMaxElement(int queryNumber) {
        //int returnMaxElem = 0;
        return maxElements[queryNumber];
        //sortSubArrays();
        //return 0;
    }

    public void showMaxElement(int p, PrintStream ps) {
        SubArray s = sortedSubArrays.get(p-1);
        //System.out.println("Showing Max Element: " + p);
        ps.print(s.getMaxElement());
        ps.println();
        //System.out.println(s.getMaxElement());
    }

    public void sortSubArrays() {
        //Get Subarray
        //sort it
        if (areSubArraysSorted)
            return;
        getSubarrays();
        areSubArraysSorted = true;
    }

    private void getSubarrays() {
        int length = array.length;
        SubArray s = new SubArray(array);
        sortedSubArrays.add(s);

        while (length>0) {
            length--;
            getSubArraysOfLength(length);
        }
    }

    private void getSubArraysOfLength(int length) {
        int ii=0;
        while (ii<array.length-length) {
            sortedSubArrays.add(getSubArray(array,ii,length));
            ii++;
        }
    }

    private SubArray getSubArray(int[] array, int offset, int length) {
        int[] s_array= new int[length];
        int jj = 0;
        while(jj < length) {
            s_array[jj++] = array[offset];
            offset++;
        }
        SubArray subArray = new SubArray(s_array);
        return subArray;
    }

    public int factorial(int length) {
        if (length == 1 || length == 0)
            return 1;
        return length*factorial(length-1);
    }

    TestCase(int[] array, int numQueries, int[] maxE) {
        this.array = array;
        this.numberOfQueries = numQueries;
        this.maxElements = maxE;
        this.sortedSubArrays = new ArrayList<>();
        areSubArraysSorted = false;
    }

    public void showSubArrays() {
        for (int ii=0; ii<sortedSubArrays.size(); ii++) {
            sortedSubArrays.get(ii).display();
        }
    }
}
