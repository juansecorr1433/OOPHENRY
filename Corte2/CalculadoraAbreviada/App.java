import controlador.Controlador;
import vista.Vista;

// Clase principal que inicia la aplicación de calculadora
public class App {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        controlador.iniciar();
    }
}