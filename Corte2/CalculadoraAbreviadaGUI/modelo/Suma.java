package modelo;

// La suma es la operación base
public class Suma implements Operacion {

    public Suma() {}

    @Override
    public int ejecutar(int a, int b) throws ArithmeticException {
        return a + b;
    }
}