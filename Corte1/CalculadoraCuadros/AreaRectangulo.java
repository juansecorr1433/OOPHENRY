public class AreaRectangulo extends CalculoGeometrico {
    public AreaRectangulo(Numero base, Numero altura) {
        super(base, altura); // Usamos num1 (base) y num2 (altura)
    }

    @Override
    public Numero calcular() {
        double base = num1.getNumero();
        double altura = num2.getNumero();
        if (base <= 0 || altura <= 0) throw new ArithmeticException("La base y la altura deben ser números positivos.");
        return new Numero(base * altura);
    }
}