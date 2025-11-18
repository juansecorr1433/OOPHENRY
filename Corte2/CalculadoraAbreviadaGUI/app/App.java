package app;

import controlador.Controlador;
import modelo.Modelo;
import vista.Interfaz;

public class App {
    public static void main(String[] args) {
       
        javax.swing.SwingUtilities.invokeLater(() -> {
            Interfaz vista = new Interfaz();
            Modelo modelo = new Modelo();
            // Inicializa el controlador, conectando la vista y el modelo
            new Controlador(vista, modelo);
        });
    }
}