public class RaizCuadrada extends OperacionCom {

    public RaizCuadrada(Numero numero) {
        super(numero);
    }

    @Override
    public Numero calcular() {
        if (numero.getNumero() < 0) {
            // Lanza una excepción si se intenta calcular la raíz de un número negativo
            throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        // Utiliza la clase Math de Java
        return new Numero(Math.sqrt(numero.getNumero()));
    }
}