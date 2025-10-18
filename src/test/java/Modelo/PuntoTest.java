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
public class PuntoTest {
      

    @Test
    void testConstructorAndGetters() {
        Punto p = new Punto(10.0, 20.0);
        assertEquals(10.0, p.getX(), 0.001);
        assertEquals(20.0, p.getY(), 0.001);
    }

    @Test
    void testSetters() {
        Punto p = new Punto(0.0, 0.0);
        p.setX(5.5);
        p.setY(15.5);
        assertEquals(5.5, p.getX(), 0.001);
        assertEquals(15.5, p.getY(), 0.001);
    }

    @Test
    void testToString() {
        Punto p = new Punto(1.0, 2.0);
        assertEquals("(1.0, 2.0)", p.toString());
    }
}
