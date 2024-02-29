package es.iessoterohernandez.daw.endes.EjJUnit;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestBoa {

    private final Boa boa;
    private final boolean expectedIsHealthy;
    private final int cageLength;
    private final boolean expectedFitsInCage;

    public TestBoa (Boa boa, boolean expectedIsHealthy, int cageLength, boolean expectedFitsInCage) {
        this.boa = boa;
        this.expectedIsHealthy = expectedIsHealthy;
        this.cageLength = cageLength;
        this.expectedFitsInCage = expectedFitsInCage;
    }

    // Define los parámetros para las pruebas
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Boa("Boa1", 10, "granola bars"), true, 15, true},     // Longitud menor que la longitud de la jaula y comida favorita
                {new Boa("Boa2", 5, "mice"), false, 10, true},             // Longitud menor que la longitud de la jaula pero comida no favorita
                {new Boa("Boa3", 20, "granola bars"), true, 15, false},    // Longitud mayor que la longitud de la jaula pero comida favorita
                {new Boa("Boa4", 15, "mice"), false, 10, false}            // Longitud mayor que la longitud de la jaula y comida no favorita
        });
    }

    @Test
    public void testIsHealthy() {
        assertEquals(expectedIsHealthy, boa.isHealthy());
    }

    @Test
    public void testFitsInCage() {
        assertEquals(expectedFitsInCage, boa.fitsInCage(cageLength));
    }
}

