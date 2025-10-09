public class Division extends Operacion {

    public Division(Numero numero1, Numero numero2){
        super(numero1, numero2);
    }

    @Override
    public Numero calcular() {
        if (numero2.getNumero() == 0) {
            // 🚨 Lanzamos la excepción estándar.
            throw new ArithmeticException("Divisor no puede ser cero."); 
        }
        
        // La división estándar de enteros en Java maneja el truncamiento.
        return new Numero(numero1.getNumero() / numero2.getNumero());
    }
}