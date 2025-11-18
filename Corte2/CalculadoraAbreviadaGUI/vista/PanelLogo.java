package vista;

import java.awt.*;
import javax.swing.*;
import java.net.URL; 

public class PanelLogo extends JPanel{

    
    private static final String NOMBRE_IMAGEN = "Calculadora2.png";
    
    private JLabel logoEtiqueta; 

    public PanelLogo(){
        
        setBackground(new Color(255, 255, 255)); 
        
        setLayout(new BorderLayout()); 

        
        try {
           
            URL imageUrl = getClass().getResource("/imagenes/" + NOMBRE_IMAGEN);
            
            if (imageUrl != null) {
                ImageIcon logoIcon = new ImageIcon(imageUrl);
                
                
                logoEtiqueta = new JLabel(logoIcon); 
                
                
                add(logoEtiqueta, BorderLayout.CENTER);
            } else {
                
                System.err.println("Advertencia: No se encontró la imagen en /imagenes/" + NOMBRE_IMAGEN + ". Usando solo texto.");
                logoEtiqueta = new JLabel("LOGO: Imagen No Encontrada");
                logoEtiqueta.setForeground(Color.RED);
                add(logoEtiqueta, BorderLayout.CENTER); 
            }
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            // Fallback en caso de cualquier error
            logoEtiqueta = new JLabel("LOGO: Error de Carga");
            logoEtiqueta.setForeground(Color.RED);
            add(logoEtiqueta, BorderLayout.CENTER); 
        }

        
    }
    
}