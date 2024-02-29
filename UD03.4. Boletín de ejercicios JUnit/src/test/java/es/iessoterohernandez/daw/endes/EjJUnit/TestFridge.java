package es.iessoterohernandez.daw.endes.EjJUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


import static org.junit.jupiter.api.Assertions.*;


@RunWith(Parameterized.class)
public class TestFridge {

    private final Fridge fridge;
    private final String item;
    private final boolean expectedPutResult;
    private final boolean expectedContainsResult;
    private final boolean expectedTakeResult;

    public TestFridge (Fridge fridge, String item, boolean expectedPutResult, boolean expectedContainsResult, boolean expectedTakeResult) {
        this.fridge = fridge;
        this.item = item;
        this.expectedPutResult = expectedPutResult;
        this.expectedContainsResult = expectedContainsResult;
        this.expectedTakeResult = expectedTakeResult;
    }

    // Define los parámetros para las pruebas
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Fridge emptyFridge = new Fridge();
        Fridge fridgeWithItem = new Fridge();
        fridgeWithItem.put("Apple");

        return Arrays.asList(new Object[][]{
                {emptyFridge, "Apple", true, true, false},          // Item no está en la nevera
                {emptyFridge, "Banana", true, false, false},        // Item no está en la nevera
                {fridgeWithItem, "Apple", false, true, true},       // Item está en la nevera
                {fridgeWithItem, "Banana", true, false, false}      // Item no está en la nevera
        });
    }

    @Test
    public void testPut() {
        assertEquals(expectedPutResult, fridge.put(item));
    }

    @Test
    public void testContains() {
        assertEquals(expectedContainsResult, fridge.contains(item));
    }

    @Test
    public void testTake() {
        boolean exceptionThrown = false;
        try {
            fridge.take(item);
        } catch (NoSuchItemException e) {
            exceptionThrown = true;
        }
        assertEquals(expectedTakeResult, exceptionThrown);
    }
}
