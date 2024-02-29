package es.iessoterohernandez.daw.endes.EjJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
public class TestPila {

    @Test
    public void testPush_ValidNumber() {
        Pila pila = new Pila();
        pila.push(5);
        assertFalse(pila.isEmpty());
        assertEquals(Integer.valueOf(5), pila.top());
    }

    @Test
    public void testPush_InvalidNumber() {
        Pila pila = new Pila();
        pila.push(1);
        assertTrue(pila.isEmpty());
    }

    @Test
    public void testPop_NotEmpty() {
        Pila pila = new Pila();
        pila.push(5);
        Integer result = pila.pop();
        assertEquals(Integer.valueOf(5), result);
        assertTrue(pila.isEmpty());
    }

    @Test
    public void testPop_Empty() {
        Pila pila = new Pila();
        Integer result = pila.pop();
        assertNull(result);
    }

    @Test
    public void testTop_NotEmpty() {
        Pila pila = new Pila();
        pila.push(5);
        assertEquals(Integer.valueOf(5), pila.top());
    }

    @Test
    public void testTop_Empty() {
        Pila pila = new Pila();
        assertNull(pila.top());
    }

    @Test
    public void testIsEmpty_NotEmpty() {
        Pila pila = new Pila();
        pila.push(5);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testIsEmpty_Empty() {
        Pila pila = new Pila();
        assertTrue(pila.isEmpty());
    }
}
