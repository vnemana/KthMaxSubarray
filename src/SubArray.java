import java.util.Comparator;

/**
 * Created by Mahesh on 12/29/16.
 */
public class SubArray implements Comparator<SubArray> {
    int[] s_array;
    int maxElem;
    boolean maxElemFound;

    public SubArray(int[] array) {
        this.s_array = array;
        this.maxElem = 0;
        this.maxElemFound = false;
    }

    @Override
    public int compare(SubArray o1, SubArray o2) {
        if(o1.s_array.length>o2.s_array.length)
            return 0;
        else if (o2.s_array.length>o1.s_array.length)
            return 1;
        else {
            for (int ii=0; ii<o1.s_array.length; ii++) {
                if (o1.s_array[ii] > o2.s_array[ii])
                    return 0;
                else if (o2.s_array[ii] > o1.s_array[ii])
                    return 1;
            }
        }
        return 0;
    }

    public int getMaxElement() {
        if (this.maxElemFound)
            return this.maxElem;
        int lclMaxElem = 0;
        for (int ii=0; ii < s_array.length; ii++) {
            if (s_array[ii]>lclMaxElem)
                lclMaxElem = s_array[ii];
        }
        this.maxElem = lclMaxElem;
        this.maxElemFound = true;
        return this.maxElem;
    }

    public void display() {
        for (int ii=0; ii<s_array.length; ii++)
            System.out.print (s_array[ii] + " ");
        System.out.println();
    }
}
