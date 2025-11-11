package modelo;


public class Potenciacion extends Operacion {

    public Potenciacion(int base, int exponente) {
        super(base, exponente); 
    }

    @Override
    public int calcular() {
        if (numero2 == 0) return 1;

        if (numero2 < 0) {
            throw new IllegalArgumentException("La potenciación con exponente negativo no está soportada para resultados enteros.");
        }

        int base = numero1;
        int exponente = numero2;
        int resultado = 1; 
        
        for (int i = 0; i < exponente; i++) {
            
            Multiplicacion multiplicacion = new Multiplicacion(resultado, base);
            resultado = multiplicacion.calcular();
        }

        return resultado;
    }
}