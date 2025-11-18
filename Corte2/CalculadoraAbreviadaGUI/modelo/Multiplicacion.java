package modelo;

/**
 * Implementación de la multiplicación usando sumas sucesivas (lógica no abreviada).
 * Utiliza la clase Suma.
 */
public class Multiplicacion implements Operacion {

    public Multiplicacion() {}

    @Override
    public int ejecutar(int numero1, int numero2) throws ArithmeticException {
        int resultado = 0;
        int signo = 1;

        // Determinar el signo del resultado
        if ((numero1 < 0 && numero2 > 0) || (numero1 > 0 && numero2 < 0)) {
            signo = -1;
        }

        int a = Math.abs(numero1); 
        int b = Math.abs(numero2); 
        Suma suma = new Suma();

        // Sumar 'a' 'b' veces
        for (int i = 0; i < b; i++) {
            resultado = suma.ejecutar(resultado, a);
        }

        // Aplicar la corrección del signo usando la clase Resta para simular negación
        if (signo == -1) {
            Resta negacion = new Resta();
            return negacion.ejecutar(0, resultado);
        }

        return resultado;
    }
}