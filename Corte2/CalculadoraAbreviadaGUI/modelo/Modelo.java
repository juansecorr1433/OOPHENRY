package modelo;

public class Modelo {
    
    private int numero1;
    private int numero2;
    // Operacion usa la interfaz Operacion (Patrón Estrategia)
    private Operacion operacion; 

    public Modelo(){
        // Operación inicial por defecto: Suma
        this.operacion = new Suma(); 
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    /**
     * Calcula el resultado aplicando la operación actualmente establecida.
     */
    public int calcular(int numero1, int numero2) throws ArithmeticException {
        this.numero1 = numero1;
        this.numero2 = numero2;
        
        // Delega la ejecución a la estrategia de operación actual.
        return this.operacion.ejecutar(numero1, numero2); 
    }
}