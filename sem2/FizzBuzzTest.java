import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FizzBuzzTest {

    @Test
    void testEval(){

        for(int i=1; i<100; i+=15){
            assertEquals(""+i, FizzBuzz.evaluate(i));
        }
        for(int i=3; i<100; i+=15){
            assertEquals("Fizz", FizzBuzz.evaluate(i));
        }
        for(int i=5; i<100; i+=15){
            assertEquals("Buzz", FizzBuzz.evaluate(i));
        }
        for(int i=15; i<100; i+=15){
            assertEquals("FizzBuzz", FizzBuzz.evaluate(i));
        }

    }

}