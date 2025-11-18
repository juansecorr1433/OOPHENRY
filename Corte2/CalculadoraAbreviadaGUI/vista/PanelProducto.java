package vista;

import javax.swing.*;
import java.awt.*;

public class PanelProducto extends JPanel {

    private JLabel numero1L, numero2L, resultadoL;
    private JTextField numero1, numero2, resultado;
    private JButton botonCalcular;

    public PanelProducto(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 
        gbc.fill = GridBagConstraints.HORIZONTAL;

        setBackground(new Color(255, 255, 255)); 
        
       
        setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(176, 196, 222), 2), 
            "MODO: SUMAS Y RESTAS SUCESIVAS", 
            javax.swing.border.TitledBorder.CENTER, 
            javax.swing.border.TitledBorder.TOP, 
            new Font("Arial", Font.BOLD, 14), 
            new Color(0, 51, 153))); 

        // 1. Número 1
        numero1L = new JLabel("Número 1 (Entero):");
        numero1L.setFont(new Font("Arial", Font.BOLD, 14)); 
        numero1L.setForeground(new Color(50, 50, 50)); 
        numero1 = new JTextField(15);
        numero1.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222))); 
        
        gbc.gridx = 0; gbc.gridy = 0; add(numero1L, gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(numero1, gbc);

        // 2. Número 2
        numero2L = new JLabel("Número 2 (Entero):");
        numero2L.setFont(new Font("Arial", Font.BOLD, 14));
        numero2L.setForeground(new Color(50, 50, 50));
        numero2 = new JTextField(15);
        numero2.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222))); 

        gbc.gridx = 0; gbc.gridy = 1; add(numero2L, gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(numero2, gbc);

        // 3. Botón Calcular
        botonCalcular = new JButton("CALCULAR");
        botonCalcular.setFont(new Font("Arial", Font.BOLD, 16));
        botonCalcular.setBackground(new Color(0, 51, 153)); 
        botonCalcular.setForeground(Color.WHITE);
        botonCalcular.setFocusPainted(false);
        botonCalcular.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 
        botonCalcular.setActionCommand("CALCULAR");
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.ipady = 5; 
        add(botonCalcular, gbc);

        // 4. Resultado
        resultadoL = new JLabel("Resultado:");
        resultadoL.setFont(new Font("Arial", Font.BOLD, 16));
        resultadoL.setForeground(new Color(50, 50, 50));
        resultado = new JTextField(15);
        resultado.setEditable(false);
        resultado.setFont(new Font("Consolas", Font.BOLD, 16));
        resultado.setBackground(new Color(230, 240, 255)); 
        resultado.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 1)); 

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.ipady = 0;
        JPanel resultadoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        resultadoPanel.setBackground(Color.WHITE);
        resultadoPanel.add(resultadoL);
        resultadoPanel.add(resultado);
        add(resultadoPanel, gbc);
    }

    public JTextField getNumero1() { return numero1;}
    public JTextField getNumero2() { return numero2;}
    public JTextField getResultado() { return resultado;}
    public JButton getBotonCalcular() { return botonCalcular;}

}