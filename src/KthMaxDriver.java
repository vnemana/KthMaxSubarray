import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KthMaxDriver {
    int numberOfTestCases;
    int arraySize;
    int numberOfQueries;
    ArrayList<TestCase> testCases;
    KthMaxDriver (String fileName, String outFileName) {
        testCases = new ArrayList<TestCase>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            line = reader.readLine();
            if (line != null) {
                numberOfTestCases = Integer.parseInt (line);
            }
            //For each test case
            for (int ii=0; ii<numberOfTestCases; ii++) {
                line = reader.readLine();
                arraySize = getArraySize (line);
                numberOfQueries = getNumberOfQueries (line);

                //Get array
                line = reader.readLine();
                int[] array = getArray(line, arraySize);
                int[] maxElements = new int[numberOfQueries];

                ////For each query
                ////Get Max Element
                for (int jj=0; jj<numberOfQueries; jj++) {
                    line = reader.readLine();
                    maxElements[jj] = getMaxElement(line);
                }
                TestCase testCase = new TestCase(array, numberOfQueries, maxElements);
                testCases.add(ii, testCase);
            }

            File f = new File(outFileName);
            FileOutputStream fos = new FileOutputStream(f);
            PrintStream ps = new PrintStream(fos);

            for (int ii=0; ii<testCases.size(); ii++) {
                TestCase testCase = testCases.get(ii);
                testCase.sortSubArrays();
                //testCase.showSubArrays();
                for (int jj=0; jj<testCase.numberOfQueries; jj++) {
                    //testCase.getMaxElement(testCase.maxElements[jj]);
                    testCase.showMaxElement(testCase.getMaxElement(jj), ps);
                }
            }
            ps.close();
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        System.out.println ("Num Test Cases: " + numberOfTestCases);
        for (int ii=0; ii<numberOfTestCases; ii++) {
            System.out.println ("--Test Case " + ii + " --");
            TestCase tCase = testCases.get(ii);
            System.out.println ("Number of Queries: " + tCase.numberOfQueries);
            System.out.println ("Array: ");
            int arraySize = tCase.array.length;
            for (int jj=0; jj<arraySize; jj++) {
                System.out.print (tCase.array[jj] + " ");
            }
            System.out.println();
            System.out.print("MaxElement: ");
            for (int kk=0; kk<tCase.maxElements.length; kk++)
                System.out.print (tCase.maxElements[kk] + " ");
            System.out.println();
            System.out.println ("-- End Test Case " + ii + "--");
        }
        return "";
    }

    private int getMaxElement(String line) {
        return Integer.parseInt(String.valueOf(line));
    }

    private int[] getArray(String line, int arraySize) {
        int[] array = new int[arraySize];
        StringTokenizer st = new StringTokenizer(line, " ");
        int ii = 0;
        while (st.hasMoreElements()) {
            array[ii++] = Integer.parseInt(String.valueOf(st.nextElement()));
        }
        return array;
    }

    private int getArraySize(String line) {
        StringTokenizer st = new StringTokenizer(line, " ");
        return Integer.parseInt(String.valueOf(st.nextElement()));
    }

    private int getNumberOfQueries(String line) {
        StringTokenizer st = new StringTokenizer(line, " ");
        st.nextElement();   //skip the first element
        return Integer.parseInt(String.valueOf(st.nextElement()));
    }
}
