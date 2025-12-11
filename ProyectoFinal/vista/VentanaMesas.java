package vista;

import modelo.*;
import javax.swing.*;

public class VentanaMesas extends JFrame {

    public VentanaMesas(Restaurante r) {

        setTitle("Mesas");
        setSize(300,400);

        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Mesa m : r.mesas) modelo.addElement(m.toString());
        JList<String> lista = new JList<>(modelo);

        add(new JScrollPane(lista));
    }
}
