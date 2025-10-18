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
public class RectanguloTest {
    
    @Test
    void testConstructor() {
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);

        assertEquals(0, rect.getVerticeSuperiorIzquierdo().getX(), 0.001);
        assertEquals(10, rect.getVerticeSuperiorIzquierdo().getY(), 0.001);
        assertEquals(10, rect.getDimensiones().getAncho(), 0.001);
        assertEquals(10, rect.getDimensiones().getAlto(), 0.001);
    }

    @Test
    void testCalcularArea() {
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);
        assertEquals(100.0, rect.calcularArea(), 0.001);
    }

    @Test
    void testCambiarEscala() {
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);

        rect.cambiarEscala(2.0);
        assertEquals(20.0, rect.getDimensiones().getAncho(), 0.001);
        assertEquals(20.0, rect.getDimensiones().getAlto(), 0.001);
        assertEquals(400.0, rect.calcularArea(), 0.001);


        rect.cambiarEscala(-1.0);
        assertEquals(20.0, rect.getDimensiones().getAncho(), 0.001);
        assertEquals(20.0, rect.getDimensiones().getAlto(), 0.001);
    }

    @Test
    void testContienePunto() {
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);


        assertTrue(rect.contienePunto(new Punto(5, 5)));

        assertTrue(rect.contienePunto(new Punto(0, 10))); 
        assertTrue(rect.contienePunto(new Punto(10, 0))); 
        assertTrue(rect.contienePunto(new Punto(0, 0))); 
        assertTrue(rect.contienePunto(new Punto(10, 10))); 
        assertTrue(rect.contienePunto(new Punto(5, 10))); 
        assertTrue(rect.contienePunto(new Punto(0, 5))); 

        // Punto fuera
        assertFalse(rect.contienePunto(new Punto(-1, 5)));
        assertFalse(rect.contienePunto(new Punto(11, 5)));
        assertFalse(rect.contienePunto(new Punto(5, -1)));
        assertFalse(rect.contienePunto(new Punto(5, 11)));
    }

    @Test
    void testMover() {
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);

        rect.mover(5, -3);
        assertEquals(5, rect.getVerticeSuperiorIzquierdo().getX(), 0.001);
        assertEquals(7, rect.getVerticeSuperiorIzquierdo().getY(), 0.001);
    }

    @Test
    void testToString() {
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);
        String expected = "Rectángulo [Vértice Superior Izquierdo: (0.0, 10.0), Dimensiones: Ancho: 10.0, Alto: 10.0, Área: 100.0]";
        assertEquals(expected, rect.toString());
    }
}
