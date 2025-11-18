package vista;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Interfaz extends JFrame implements IVista{

    private PanelLogo panelLogo;
    private PanelProducto panelProducto;
    private PanelBotones panelBotones;

    public Interfaz() {
        super("Calculadora No Abreviada (MVC)");

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Cambiamos el fondo general a un color muy claro para mejor contraste
        setBackground(new Color(248, 248, 255)); // Ghost White

        panelLogo = new PanelLogo();
        panelProducto = new PanelProducto();
        panelBotones = new PanelBotones();

        add(panelLogo, BorderLayout.NORTH);
        add(panelProducto, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // SE ELIMINA el setPreferredSize para que el tamaño lo dicte el pack() 
        // basado en el tamaño real de los componentes (incluida la imagen del logo).
        // setPreferredSize(new Dimension(450, 480)); 
        
        pack(); // Empaqueta la ventana al tamaño mínimo de los componentes.
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void mostrarResultado(String texto) {
        panelProducto.getResultado().setText(texto);
    }

    @Override
    public void mostrarError(String mensaje){
        // Usamos JOptionPane para mostrar la alerta
        JOptionPane.showMessageDialog(this, mensaje, "Error de Cálculo", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void limpiarCampos(){
        panelProducto.getNumero1().setText("");
        panelProducto.getNumero2().setText("");
        panelProducto.getResultado().setText("");
    }

    public PanelProducto getPanelProducto(){return panelProducto;}
    public PanelBotones gPanelBotones(){return panelBotones;}
    
}