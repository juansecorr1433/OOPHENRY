public class AreaCuadrado extends CalculoGeometrico {
    public AreaCuadrado(Numero lado, Numero dummy) {
        super(lado, dummy); // Solo usamos num1 (lado)
    }

    @Override
    public Numero calcular() {
        double lado = num1.getNumero();
        if (lado <= 0) throw new ArithmeticException("El lado debe ser un número positivo.");
        return new Numero(lado * lado);
    }
}