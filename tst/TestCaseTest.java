import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mahesh on 12/25/16.
 */
public class TestCaseTest {
    @Test
    public void testFactorial() {
        int[] array = new int[]{1,2,3};
        int numQueries = 2;
        int[] maxE = new int[]{1};
        TestCase tc = new TestCase(array, numQueries, maxE);
        assertTrue(tc.factorial(5) == 120);

    }
}