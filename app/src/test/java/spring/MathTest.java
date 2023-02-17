package spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spring.Math.Math;

class MathTest {
    private Math math;

    @BeforeEach
    public void setup() {
        math = new Math();
    }

    @Test
    public void sumWith3Numbers() {
        int result = math.sum(1, 2, 3);
        System.out.println(result);
        assertEquals(6, result);
    }

    @Test
    public void sumWith1Number() {
        int result = math.sum(3);
        System.out.println(result);
        assertEquals(3, result);
    }
}
