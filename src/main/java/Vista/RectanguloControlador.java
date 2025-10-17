/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Rectangulo;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class RectanguloControlador {
     public static double solicitarCoordenada(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) { 
                    return Double.NaN; 
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static double solicitarFactorEscala(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) { 
                    return Double.NaN; 
                }
                double factor = Double.parseDouble(input);
                if (factor <= 0) {
                    JOptionPane.showMessageDialog(null, "El factor de escala debe ser mayor que cero.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                } else {
                    return factor;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static double solicitarMovimiento(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) { 
                    return Double.NaN; 
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void mostrarInformacionRectangulo(Rectangulo rect) {
        String info = "Información del Rectángulo:\n" +
                      "  " + rect.toString();
        JOptionPane.showMessageDialog(null, info, "Información del Rectángulo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }
}
