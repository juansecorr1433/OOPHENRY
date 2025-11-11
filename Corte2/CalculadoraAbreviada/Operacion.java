package modelo;

// Clase base para todas las operaciones aritméticas
public class Operacion {
    protected int numero1;
    protected int numero2;

    public Operacion(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    // Getters y Setters
    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    
    public int calcular() {
        return 0;
    }
}