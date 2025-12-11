package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private ArrayList<Plato> platos = new ArrayList<>();

    public void agregarPlato(Plato p) {
        platos.add(p);
    }

    public double total() {
        return platos.stream().mapToDouble(Plato::getPrecio).sum();
    }

    public ArrayList<Plato> getPlatos() { return platos; }
}
