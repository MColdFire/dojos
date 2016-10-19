package com.coldfire;


import com.google.common.collect.Lists;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class PrimeFactorsTest {

    @Test
    public void primeFactorsOf_2(){
        assertEquals(Lists.newArrayList(2), PrimeFactors.generate(2));
    }

    @Test
    public void primeFactorsOf_3(){
        assertEquals(Lists.newArrayList(3), PrimeFactors.generate(3));
    }

    @Test
    public void primeFactorsOf_4(){
        assertEquals(Lists.newArrayList(2,2), PrimeFactors.generate(4));
    }

    @Test
    public void primeFactorsOf_5(){
        assertEquals(Lists.newArrayList(5), PrimeFactors.generate(5));
    }

    @Test
    public void primeFactorsOf_6(){
        assertEquals(Lists.newArrayList(2,3), PrimeFactors.generate(6));
    }


    @Test
    public void primeFactorsOf_9(){
        assertEquals(Lists.newArrayList(3,3), PrimeFactors.generate(9));
    }

    @Test
    public void primeFactorsOf_10(){
        assertEquals(Lists.newArrayList(2,5), PrimeFactors.generate(10));
    }

    @Test
    public void primeFactorsOf_11(){
        assertEquals(Lists.newArrayList(11), PrimeFactors.generate(11));
    }

    @Test
    public void primeFactorsOf_15(){
        assertEquals(Lists.newArrayList(3,5), PrimeFactors.generate(15));
    }

    @Test
    public void primeFactorsOf_30(){
        assertEquals(Lists.newArrayList(2,3,5), PrimeFactors.generate(30));
    }
}
