package vista;

import modelo.*;
import javax.swing.*;

public class VentanaMenu extends JFrame {

    public VentanaMenu(Restaurante r) {
        setTitle("Menu");
        setSize(300,400);
        setLayout(null);

        DefaultListModel<Plato> modelo = new DefaultListModel<>();
        r.menu.forEach(modelo::addElement);
        JList<Plato> lista = new JList<>(modelo);

        JScrollPane sp = new JScrollPane(lista);
        sp.setBounds(20,20,250,200);
        add(sp);

        JTextField nombre = new JTextField();
        JTextField precio = new JTextField();

        nombre.setBounds(20,230,150,25);
        precio.setBounds(180,230,80,25);

        add(nombre); add(precio);

        JButton agregar = new JButton("Agregar");
        JButton eliminar = new JButton("Eliminar");

        agregar.setBounds(20,270,100,30);
        eliminar.setBounds(150,270,100,30);

        add(agregar); add(eliminar);

        agregar.addActionListener(e -> {
            r.menu.add(new Plato(nombre.getText(), Double.parseDouble(precio.getText())));
            modelo.addElement(r.menu.get(r.menu.size()-1));
        });

        eliminar.addActionListener(e -> {
            Plato p = lista.getSelectedValue();
            if (p != null) {
                r.menu.remove(p);
                modelo.removeElement(p);
            }
        });
    }
}
