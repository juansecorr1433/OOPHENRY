package modelo;

import java.io.Serializable;

public class Mesa implements Serializable {
    private int numero;
    private boolean ocupada;
    private Pedido pedido;

    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.pedido = null;
    }

    public int getNumero() { return numero; }
    public boolean isOcupada() { return ocupada; }
    public Pedido getPedido() { return pedido; }

    public void ocupar(Pedido p) {
        this.ocupada = true;
        this.pedido = p;
    }

    public void liberar() {
        this.ocupada = false;
        this.pedido = null;
    }

    @Override
    public String toString() {
        return "Mesa " + numero + (ocupada ? " (Ocupada)" : " (Libre)");
    }
}

