package modelo;

/**
 * Implementación de la potenciación usando multiplicaciones sucesivas (lógica no abreviada).
 * Utiliza la clase Multiplicacion.
 */
public class Potenciacion implements Operacion {

    public Potenciacion() {}

    @Override
    public int ejecutar(int base, int exponente) throws ArithmeticException {
        if (exponente < 0) {
            throw new ArithmeticException("Exponente negativo no soportado para resultados enteros.");
        }
        if (exponente == 0) return 1;

        int resultado = 1; 
        Multiplicacion multiplicacion = new Multiplicacion();
        
        // Multiplicar 'base' por sí misma 'exponente' veces
        for (int i = 0; i < exponente; i++) {
            resultado = multiplicacion.ejecutar(resultado, base);
        }

        return resultado;
    }
}