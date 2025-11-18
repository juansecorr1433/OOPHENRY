package vista;

import javax.swing.*;
import java.awt.*;

public class PanelBotones extends JPanel {

    // Se añade el botón de Potenciación
    private JButton btnLimpiar, btnSuma, btnResta, btnProducto, btnDivision, btnPotencia;

    public PanelBotones(){
        
        setLayout(new GridLayout(1, 6, 8, 8)); 
        setBackground(new Color(248, 248, 255)); 
        setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12)); 

        btnLimpiar = createStyledButton("🧹 Limpiar", "LIMPIAR", new Color(220, 20, 60)); // Carmesí para limpiar
        btnSuma = createStyledButton("Suma ➕", "SUMA", new Color(60, 179, 113)); // Verde medio
        btnResta = createStyledButton("Resta ➖", "RESTA", new Color(255, 140, 0)); // Naranja
        btnProducto = createStyledButton("Producto ✖️", "PRODUCTO", new Color(100, 149, 237)); // Azul de maiz
        btnDivision = createStyledButton("División ➗", "DIVISION", new Color(70, 130, 180)); // Azul acero
        btnPotencia = createStyledButton("Potencia xⁿ", "POTENCIA", new Color(138, 43, 226)); // Azul violeta

        add(btnLimpiar);
        add(btnSuma);
        add(btnResta);
        add(btnProducto);
        add(btnDivision);
        add(btnPotencia);
    }
    
    
    private JButton createStyledButton(String text, String command, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        button.setActionCommand(command);
        return button;
    }


    public JButton getBtnLimpiar() {return btnLimpiar;}
    public JButton getBtnSuma() {return btnSuma;}
    public JButton getBtnProducto() {return btnProducto;}
    public JButton getBtnResta() {return btnResta;}
    public JButton getBtnDivision() {return btnDivision;}
    public JButton getBtnPotencia() {return btnPotencia;}
}