package es.iessoterohernandez.daw.endes.EjJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
public class TestSubscripcion {

    @Test
    public void testPrecioPorMes_PositiveValues() {
        Subscripcion subscripcion = new Subscripcion(100, 12);
        assertEquals(8.34, subscripcion.precioPorMes(), 0.01);
    }

    @Test
    public void testPrecioPorMes_ZeroPeriod() {
        Subscripcion subscripcion = new Subscripcion(100, 0);
        assertEquals(0, subscripcion.precioPorMes(), 0.01);
    }

    @Test
    public void testPrecioPorMes_NegativeValues() {
        Subscripcion subscripcion = new Subscripcion(-100, -12);
        assertEquals(0, subscripcion.precioPorMes(), 0.01);
    }

    @Test
    public void testPrecioPorMes_ZeroPrice() {
        Subscripcion subscripcion = new Subscripcion(0, 12);
        assertEquals(0, subscripcion.precioPorMes(), 0.01);
    }

    @Test
    public void testPrecioPorMes_ZeroPriceAndZeroPeriod() {
        Subscripcion subscripcion = new Subscripcion(0, 0);
        assertEquals(0, subscripcion.precioPorMes(), 0.01);
    }

    @Test
    public void testPrecioPorMes_FractionalResult() {
        Subscripcion subscripcion = new Subscripcion(10, 3);
        assertEquals(3.34, subscripcion.precioPorMes(), 0.01);
    }

    @Test
    public void testCancel() {
        Subscripcion subscripcion = new Subscripcion(100, 12);
        subscripcion.cancel();
        assertEquals(0, subscripcion.precioPorMes(), 0.01);
    }
}

