public class Division extends Operacion {

    public Division(Numero numero1, Numero numero2){
        super(numero1, numero2);
    }

    @Override
    public Numero calcular() {
        
        if (numero2.getNumero() == 0.0) {
            // Esto asegura que el 'catch' en Calculadora se ejecute.
            throw new ArithmeticException("El divisor no puede ser cero."); 
        }
        
        return new Numero(numero1.getNumero() / numero2.getNumero());
    }
}