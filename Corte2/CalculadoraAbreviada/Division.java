package modelo;

// Implementación de la división usando restas sucesivas (solo cociente entero),
// reemplazando la resta directa con la clase Resta.
public class Division extends Operacion {

    public Division(int numero1, int numero2) {
        super(numero1, numero2);
    }

    @Override
    public int calcular() {
        if (numero2 == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }

        int cociente = 0;
        int dividendo = Math.abs(numero1);
        int divisor = Math.abs(numero2);

        
        while (dividendo >= divisor) {
           
            Resta resta = new Resta(dividendo, divisor);
            dividendo = resta.calcular();
            
            
            Suma incremento = new Suma(cociente, 1);
            cociente = incremento.calcular();
        }

        
        if ((numero1 < 0 && numero2 > 0) || (numero1 > 0 && numero2 < 0)) {
            Resta negacion = new Resta(0, cociente);
            return negacion.calcular();
        }

        return cociente;
    }
}