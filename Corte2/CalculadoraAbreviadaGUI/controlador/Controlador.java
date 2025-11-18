package controlador;

import modelo.*;
import util.ValidadorEntrada;
import vista.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener { 

    private final Interfaz vista;
    private final Modelo modelo;

    public Controlador(Interfaz vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Registrar ActionListeners en los botones del panel
        vista.getPanelProducto().getBotonCalcular().addActionListener(this);
        vista.gPanelBotones().getBtnProducto().addActionListener(this);
        vista.gPanelBotones().getBtnSuma().addActionListener(this);
        vista.gPanelBotones().getBtnResta().addActionListener(this); 
        vista.gPanelBotones().getBtnDivision().addActionListener(this); 
        vista.gPanelBotones().getBtnPotencia().addActionListener(this); // Botón de Potencia
        vista.gPanelBotones().getBtnLimpiar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String modo = "MODO: SUMAS Y RESTAS SUCESIVAS"; // Título inicial
        
        switch (e.getActionCommand()) {
            case "CALCULAR":
                manejarCalculo();
                return; 
            case "LIMPIAR":
                vista.limpiarCampos();
                break;
            // Configuraciones de operación (Patrón Estrategia)
            case "SUMA":
                modelo.setOperacion(new Suma());
                modo = "MODO: SUMA (A + B)";
                break;
            case "RESTA":
                modelo.setOperacion(new Resta());
                modo = "MODO: RESTA (A - B)";
                break;
            case "PRODUCTO":
                modelo.setOperacion(new Multiplicacion());
                modo = "MODO: MULTIPLICACIÓN (Suma Sucesiva)";
                break;
            case "DIVISION":
                modelo.setOperacion(new Division());
                modo = "MODO: DIVISIÓN (Resta Sucesiva - Entero)";
                break;
            case "POTENCIA":
                modelo.setOperacion(new Potenciacion());
                modo = "MODO: POTENCIACIÓN (Multiplicación Sucesiva)";
                break;
        }
        
        // Actualizar el título del borde del panel central con el nuevo modo
        vista.getPanelProducto().setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 149, 237), 2),
            modo,
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new java.awt.Font("Arial", java.awt.Font.BOLD, 14),
            new java.awt.Color(0, 51, 153)));
    }

    private void manejarCalculo() {
        String val1 = vista.getPanelProducto().getNumero1().getText();
        String val2 = vista.getPanelProducto().getNumero2().getText();

        // Validación para enteros
        if (!ValidadorEntrada.esEnteroValido(val1) || !ValidadorEntrada.esEnteroValido(val2)) {
            vista.mostrarError("Por favor, ingrese números enteros válidos.");
            return;
        }

        int n1 = Integer.parseInt(val1);
        int n2 = Integer.parseInt(val2);

        try {
            // Llama al método calcular del Modelo, usando la lógica no abreviada
            int resultado = modelo.calcular(n1, n2);
            vista.mostrarResultado(String.valueOf(resultado));
        } catch (ArithmeticException ex) {
            // Captura excepciones aritméticas (división por cero, exponente negativo)
            vista.mostrarError(ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Ocurrió un error inesperado durante el cálculo.");
        }
    }

}