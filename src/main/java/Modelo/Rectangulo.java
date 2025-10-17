/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class Rectangulo {
        private Punto verticeSuperiorIzquierdo;
    private Dimension dimensiones;

    public Rectangulo(Punto p1, Punto p2) {
        double minX = Math.min(p1.getX(), p2.getX());
        double maxX = Math.max(p1.getX(), p2.getX());
        double minY = Math.min(p1.getY(), p2.getY());
        double maxY = Math.max(p1.getY(), p2.getY());

        this.verticeSuperiorIzquierdo = new Punto(minX, maxY); 
        this.dimensiones = new Dimension(maxX - minX, maxY - minY);
    }

    public double calcularArea() {
        return dimensiones.getAncho() * dimensiones.getAlto();
    }

    public void cambiarEscala(double factorEscala) {
        if (factorEscala > 0) {
            dimensiones.setAncho(dimensiones.getAncho() * factorEscala);
            dimensiones.setAlto(dimensiones.getAlto() * factorEscala);
        }
    }

    public boolean contienePunto(Punto punto) {
        double rectXMin = verticeSuperiorIzquierdo.getX();
        double rectXMax = verticeSuperiorIzquierdo.getX() + dimensiones.getAncho();
        double rectYMin = verticeSuperiorIzquierdo.getY() - dimensiones.getAlto();
        double rectYMax = verticeSuperiorIzquierdo.getY();

        return punto.getX() >= rectXMin && punto.getX() <= rectXMax &&
               punto.getY() >= rectYMin && punto.getY() <= rectYMax;
    }

    public void mover(double deltaX, double deltaY) {
        verticeSuperiorIzquierdo.setX(verticeSuperiorIzquierdo.getX() + deltaX);
        verticeSuperiorIzquierdo.setY(verticeSuperiorIzquierdo.getY() + deltaY);
    }

    public Punto getVerticeSuperiorIzquierdo() {
        return verticeSuperiorIzquierdo;
    }

    public Dimension getDimensiones() {
        return dimensiones;
    }


    public String toString() {
        return "Rectángulo [Vértice Superior Izquierdo: " + verticeSuperiorIzquierdo +
               ", Dimensiones: " + dimensiones + ", Área: " + calcularArea() + "]";
    }
}
