package es.iessoterohernandez.daw.endes.EjJUnit;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOperadorAritmetico {

    @Test
    public void testSuma() {
        int result = OperadorAritmetico.suma(5, 3);
        assertEquals(8, result);
    }

    @Test
    public void testSuma_NegativeNumbers() {
        int result = OperadorAritmetico.suma(-5, -3);
        assertEquals(-8, result);
    }

    @Test
    public void testSuma_Zero() {
        int result = OperadorAritmetico.suma(0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testDivision() throws Exception {
        int result = OperadorAritmetico.division(10, 2);
        assertEquals(5, result);
    }

    @Test(expected = Exception.class)
    public void testDivision_ByZero() throws Exception {
        OperadorAritmetico.division(10, 0);
    }

    @Test
    public void testDivision_NegativeNumbers() throws Exception {
        int result = OperadorAritmetico.division(-10, -2);
        assertEquals(5, result);
    }
}
