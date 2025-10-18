/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author migue
 */
public class DimensionTest {
    

        @Test
    void testConstructorAndGetters() {
        Dimension d = new Dimension(10.0, 20.0);
        assertEquals(10.0, d.getAncho(), 0.001);
        assertEquals(20.0, d.getAlto(), 0.001);
    }

    @Test
    void testSetters() {
        Dimension d = new Dimension(0.0, 0.0);
        d.setAncho(5.5);
        d.setAlto(15.5);
        assertEquals(5.5, d.getAncho(), 0.001);
        assertEquals(15.5, d.getAlto(), 0.001);
    }

    @Test
    void testToString() {
        Dimension d = new Dimension(10.0, 20.0);
        assertEquals("Ancho: 10.0, Alto: 20.0", d.toString());
    }
    
}
