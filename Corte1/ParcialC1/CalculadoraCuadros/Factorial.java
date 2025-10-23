public class Factorial extends OperacionCom {

    public Factorial(Numero numero) {
        super(numero);
    }

    @Override
    public Numero calcular() {
        double n = numero.getNumero();

        if (n < 0 || n != (long) n) {
            // El factorial solo está definido para enteros no negativos
            throw new ArithmeticException("El factorial solo se puede calcular para números enteros no negativos.");
        }
        
        if (n > 20) {
             // Limitar el cálculo para evitar desbordamiento con 'double'
             // El factorial crece muy rápido, 20! es el último que cabe en un long sin perder precisión
             throw new ArithmeticException("Número demasiado grande para calcular el factorial.");
        }

        long resultado = 1;
        for (long i = 2; i <= n; i++) {
            resultado *= i;
        }

        return new Numero(resultado);
    }
}