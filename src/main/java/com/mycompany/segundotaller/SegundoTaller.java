/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.segundotaller;

import Modelo.Punto;
import Modelo.Rectangulo;
import Vista.RectanguloControlador;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class SegundoTaller {

    public static void main(String[] args) {
    Rectangulo miRectangulo = crearRectanguloDesdeUsuario();
        if (miRectangulo == null) {
            RectanguloControlador.mostrarMensaje("Operación cancelada. Saliendo del programa.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
            return; 
        }

        int opcion;
        do {
            String menu = "Seleccione una opción:\n"
                        + "1. Mostrar información del rectángulo\n"
                        + "2. Calcular área\n"
                        + "3. Cambiar escala\n"
                        + "4. Determinar si un punto está dentro\n"
                        + "5. Mover rectángulo\n"
                        + "0. Salir";

            String input = JOptionPane.showInputDialog(null, menu, "Menú de Operaciones", JOptionPane.QUESTION_MESSAGE);

            if (input == null) { 
                opcion = 0;
            } else {
                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    RectanguloControlador.mostrarMensaje("Entrada inválida. Por favor, ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    opcion = -1; 
                }
            }

            switch (opcion) {
                case 1:
                    RectanguloControlador.mostrarInformacionRectangulo(miRectangulo);
                    break;
                case 2:
                    RectanguloControlador.mostrarMensaje("El área del rectángulo es: " + miRectangulo.calcularArea(), "Área", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    double factor = RectanguloControlador.solicitarFactorEscala("Ingrese el factor de escala (mayor que 0):");
                    if (!Double.isNaN(factor)) {
                        miRectangulo.cambiarEscala(factor);
                        RectanguloControlador.mostrarMensaje("Escala cambiada. Nueva información del rectángulo:\n" + miRectangulo.toString(), "Escala", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 4:
                    Punto puntoAComprobar = crearPuntoDesdeUsuario("Ingrese las coordenadas del punto a comprobar:");
                    if (puntoAComprobar != null) {
                        if (miRectangulo.contienePunto(puntoAComprobar)) {
                            RectanguloControlador.mostrarMensaje("El punto " + puntoAComprobar + " SÍ está dentro del rectángulo.", "Punto en Rectángulo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            RectanguloControlador.mostrarMensaje("El punto " + puntoAComprobar + " NO está dentro del rectángulo.", "Punto en Rectángulo", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;
                case 5:
                    double deltaX = RectanguloControlador.solicitarMovimiento("Ingrese las unidades para mover horizontalmente (positivo para derecha, negativo para izquierda):");
                    if (Double.isNaN(deltaX)) break;
                    double deltaY = RectanguloControlador.solicitarMovimiento("Ingrese las unidades para mover verticalmente (positivo para arriba, negativo para abajo):");
                    if (Double.isNaN(deltaY)) break;

                    miRectangulo.mover(deltaX, deltaY);
                    RectanguloControlador.mostrarMensaje("Rectángulo movido. Nueva información:\n" + miRectangulo.toString(), "Mover Rectángulo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 0:
                    RectanguloControlador.mostrarMensaje("Saliendo del programa.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    RectanguloControlador.mostrarMensaje("Opción no válida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 0);
    }

    private static Rectangulo crearRectanguloDesdeUsuario() {
        RectanguloControlador.mostrarMensaje("Por favor, ingrese las coordenadas de dos puntos opuestos para crear el rectángulo.", "Crear Rectángulo", JOptionPane.INFORMATION_MESSAGE);

        Punto p1 = crearPuntoDesdeUsuario("Ingrese las coordenadas del PRIMER punto (X y Y):");
        if (p1 == null) return null;

        Punto p2 = crearPuntoDesdeUsuario("Ingrese las coordenadas del SEGUNDO punto (X y Y):");
        if (p2 == null) return null;

        return new Rectangulo(p1, p2);
    }

    private static Punto crearPuntoDesdeUsuario(String mensaje) {
        double x = RectanguloControlador.solicitarCoordenada(mensaje + "\nX:");
        if (Double.isNaN(x)) return null;

        double y = RectanguloControlador.solicitarCoordenada(mensaje + "\nY:");
        if (Double.isNaN(y)) return null;

        return new Punto(x, y);
    }
}
