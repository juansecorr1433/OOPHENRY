public class AreaCircunferencia extends CalculoGeometrico {
    public AreaCircunferencia(Numero radio, Numero dummy) {
        super(radio, dummy); // Solo usamos num1 (radio)
    }

    @Override
    public Numero calcular() {
        double radio = num1.getNumero();
        if (radio <= 0) throw new ArithmeticException("El radio debe ser un número positivo.");
        // Math.PI contiene el valor de Pi
        return new Numero(Math.PI * radio * radio);
    }
}