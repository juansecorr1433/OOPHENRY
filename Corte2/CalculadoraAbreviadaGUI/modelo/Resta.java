package modelo;

// La resta se considera fundamental en este contexto
public class Resta implements Operacion {

    public Resta() {}

    @Override
    public int ejecutar(int a, int b) throws ArithmeticException {
        return a - b;
    }
}