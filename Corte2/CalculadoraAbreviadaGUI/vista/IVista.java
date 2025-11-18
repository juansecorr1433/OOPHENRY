package vista;

// Interfaz adaptada para trabajar con resultados enteros
public interface IVista {
    void mostrarResultado(String texto);
    void mostrarError(String mensaje);
    void limpiarCampos();
    
}