package modelo;

// Implementación de la suma.
public class Suma extends Operacion {

    public Suma(int numero1, int numero2) {
        super(numero1, numero2);
    }

    @Override
    public int calcular() {
        return numero1 + numero2;
    }
}