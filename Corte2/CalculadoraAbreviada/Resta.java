package modelo;

// Implementación de la resta.
public class Resta extends Operacion {

    public Resta(int numero1, int numero2) {
        super(numero1, numero2);
    }

    @Override
    public int calcular() {
        return numero1 - numero2;
    }
}