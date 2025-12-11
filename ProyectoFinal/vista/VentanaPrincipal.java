package vista;

import controlador.Controlador;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal(Controlador c) {
        setTitle("Restaurante");
        setSize(300,400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton b1 = new JButton("Ver menu");
        JButton b2 = new JButton("Ver mesas");
        JButton b3 = new JButton("Nuevo pedido");
        JButton b4 = new JButton("Facturas");
        JButton b5 = new JButton("Salir");

        b1.setBounds(50,30,200,40);
        b2.setBounds(50,90,200,40);
        b3.setBounds(50,150,200,40);
        b4.setBounds(50,210,200,40);
        b5.setBounds(50,270,200,40);

        add(b1); add(b2); add(b3); add(b4); add(b5);

        b1.addActionListener(e -> c.abrirMenu());
        b2.addActionListener(e -> c.abrirMesas());
        b3.addActionListener(e -> c.abrirPedido());
        b4.addActionListener(e -> c.abrirFacturas());
        b5.addActionListener(e -> c.salir());
    }
}
