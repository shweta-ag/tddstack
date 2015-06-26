import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by alpha on 24/06/2015.
 */
public class PrimeFactorsTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void factors(){
       // assertThat(factorsOf(1), empty());
       // assertThat(factorsOf(2), contains(2));
    }

    private ArrayList<Integer> factorsOf(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
       for(int divisor =2; n > 1; divisor++)
          for (; n % divisor == 0; n /=divisor)
            factors.add(divisor);
          return factors;
    }

    @After
    public void tearDown() throws Exception {

    }
}
