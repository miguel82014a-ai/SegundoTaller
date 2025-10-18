/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Vista;

import Modelo.Rectangulo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.Punto;
/**
 *
 * @author migue
 */
public class RectanguloControladorTest {
    

    @Test
    void testCreacionYCalculoRectangulo() {
        // Simular la creación de un rectángulo con puntos válidos
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);

        // Verificar que el rectángulo se creó correctamente
        assertNotNull(rect);
        assertEquals(100.0, rect.calcularArea(), 0.001);
    }

    @Test
    void testEscalaYContienePunto() {
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);

        // Simular cambio de escala
        rect.cambiarEscala(0.5);
        assertEquals(5.0, rect.getDimensiones().getAncho(), 0.001);
        assertEquals(5.0, rect.getDimensiones().getAlto(), 0.001);
        assertEquals(25.0, rect.calcularArea(), 0.001);

        // Simular verificación de punto en el nuevo rectángulo
        assertTrue(rect.contienePunto(new Punto(2, 7)));
        assertFalse(rect.contienePunto(new Punto(8, 8)));
    }

    @Test
    void testMovimientoYContienePunto() {
        Punto p1 = new Punto(0, 10);
        Punto p2 = new Punto(10, 0);
        Rectangulo rect = new Rectangulo(p1, p2);

        // Simular movimiento
        rect.mover(10, -5);
        assertEquals(10, rect.getVerticeSuperiorIzquierdo().getX(), 0.001);
        assertEquals(5, rect.getVerticeSuperiorIzquierdo().getY(), 0.001);

        // Simular verificación de punto en el rectángulo movido
        assertTrue(rect.contienePunto(new Punto(15, 2)));
        assertFalse(rect.contienePunto(new Punto(5, 5)));
    }
}
