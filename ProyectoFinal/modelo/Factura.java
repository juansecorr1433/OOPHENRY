package modelo;

import java.io.Serializable;

public class Factura implements Serializable {
    private Mesa mesa;
    private Pedido pedido;
    private boolean pagada;

    public Factura(Mesa mesa, Pedido pedido) {
        this.mesa = mesa;
        this.pedido = pedido;
        this.pagada = false;
    }

    public double total() {
        return pedido.total();
    }

    public void pagar() {
        pagada = true;
        mesa.liberar();
    }

    @Override
    public String toString() {
        return "Factura Mesa " + mesa.getNumero() +
               " - Total: $" + total() +
               " - " + (pagada ? "Pagada" : "Pendiente");
    }
}

