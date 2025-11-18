package modelo;

/**
 * Implementación de la división usando restas sucesivas (lógica no abreviada).
 * Solo calcula el cociente entero. Utiliza las clases Resta y Suma.
 */
public class Division implements Operacion {

    public Division() {}

    @Override
    public int ejecutar(int numero1, int numero2) throws ArithmeticException {
        if (numero2 == 0) {
            throw new ArithmeticException("Error: No se permite la división por cero.");
        }

        int cociente = 0;
        int dividendo = Math.abs(numero1);
        int divisor = Math.abs(numero2);
        
        Resta resta = new Resta();
        Suma suma = new Suma();

        // Restar el divisor del dividendo hasta que el dividendo sea menor que el divisor
        while (dividendo >= divisor) {
            dividendo = resta.ejecutar(dividendo, divisor);
            cociente = suma.ejecutar(cociente, 1);
        }

        // Aplicar el signo correcto al cociente
        if ((numero1 < 0 && numero2 > 0) || (numero1 > 0 && numero2 < 0)) {
            return resta.ejecutar(0, cociente);
        }

        return cociente;
    }
}