import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mahesh on 12/20/16.
 */
public class KthMaxSubarrayTest {

    @Test
    public void testConstructor() {
        int[] array = {1, 2, 3, 4};
        KthMaxSubarray k = new KthMaxSubarray(array);
        assertNotNull(k);

    }
}