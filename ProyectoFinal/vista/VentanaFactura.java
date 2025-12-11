package vista;

import modelo.*;
import javax.swing.*;

public class VentanaFactura extends JFrame {

    public VentanaFactura(Restaurante r) {
        setTitle("Facturas");
        setSize(300,400);
        setLayout(null);

        DefaultListModel<Factura> modelo = new DefaultListModel<>();
        r.facturas.forEach(modelo::addElement);

        JList<Factura> lista = new JList<>(modelo);
        JScrollPane sp = new JScrollPane(lista);
        sp.setBounds(20,20,250,250);
        add(sp);

        JButton pagar = new JButton("Pagar");
        pagar.setBounds(80,290,120,40);
        add(pagar);

        pagar.addActionListener(e -> {
            Factura f = lista.getSelectedValue();
            if (f != null) {
                f.pagar();
                lista.repaint();
            }
        });
    }
}
