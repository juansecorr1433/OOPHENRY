package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurante implements Serializable {
    public ArrayList<Mesa> mesas = new ArrayList<>();
    public ArrayList<Plato> menu = new ArrayList<>();
    public ArrayList<Factura> facturas = new ArrayList<>();

    public ArrayList<Plato> getMenu() { return menu; }
    public ArrayList<Mesa> getMesas() { return mesas; }
    public ArrayList<Factura> getFacturas() { return facturas; }

    public Restaurante() {
        for (int i = 1; i <= 5; i++) {
            mesas.add(new Mesa(i));
        }
    }
}
