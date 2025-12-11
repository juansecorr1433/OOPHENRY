package controlador;

import modelo.*;
import vista.*;

public class Controlador {

    private Restaurante restaurante;
    private VentanaPrincipal vp;

    public Controlador() {
        restaurante = Persistencia.cargar();
        vp = new VentanaPrincipal(this);
        vp.setVisible(true);
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void abrirMenu() {
        new VentanaMenu(restaurante).setVisible(true);
        Persistencia.guardar(restaurante);
    }

    public void abrirMesas() {
        new VentanaMesas(restaurante).setVisible(true);
    }

    public void abrirPedido() {
        new VentanaPedido(restaurante).setVisible(true);
    }

    public void abrirFacturas() {
        new VentanaFactura(restaurante).setVisible(true);
    }

    public void salir() {
        Persistencia.guardar(restaurante);
        System.exit(0);
    }
}
