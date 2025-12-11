package vista;

import modelo.*;
import javax.swing.*;

public class VentanaPedido extends JFrame {

    private Restaurante restaurante;
    private Pedido pedidoActual = new Pedido(); 
    
    private JList<Plato> listaMenu;
    private JComboBox<Mesa> cbMesa;
    private JTextArea resumenPedido;

    public VentanaPedido(Restaurante r) {
        this.restaurante = r;
        
        setTitle("Nuevo Pedido (Multiples Platos)");
        setSize(580, 500);
        setLayout(null);

        //SELECCION DE MESA
        JLabel lblMesas = new JLabel("1. Seleccione Mesa Libre:");
        lblMesas.setBounds(20, 10, 200, 20);
        add(lblMesas);
        
        cbMesa = new JComboBox<>();
        r.mesas.stream().filter(m -> !m.isOcupada()).forEach(cbMesa::addItem);
        cbMesa.setBounds(20, 30, 250, 30);
        add(cbMesa);

        //SELECCION DE PLATO (MENÚ)
        JLabel lblMenu = new JLabel("2. Seleccione Plato del Menu:");
        lblMenu.setBounds(20, 80, 200, 20);
        add(lblMenu);
        
        DefaultListModel<Plato> modeloMenu = new DefaultListModel<>();
        r.menu.forEach(modeloMenu::addElement);
        listaMenu = new JList<>(modeloMenu);
        JScrollPane spMenu = new JScrollPane(listaMenu);
        spMenu.setBounds(20, 100, 250, 200);
        add(spMenu);
        
        JButton agregarPlato = new JButton(">> Agregar Plato al Pedido");
        agregarPlato.setBounds(30, 310, 230, 30);
        add(agregarPlato);
        
        //PEDIDO ACTUAL
        JLabel lblResumen = new JLabel("3. Pedido Actual (Agregados):");
        lblResumen.setBounds(300, 10, 250, 20);
        add(lblResumen);
        
        resumenPedido = new JTextArea();
        resumenPedido.setEditable(false);
        JScrollPane spResumen = new JScrollPane(resumenPedido);
        spResumen.setBounds(300, 30, 250, 300);
        add(spResumen);

        //FINALIZAR PEDIDO
        JButton finalizarPedido = new JButton("4. Finalizar Pedido y Ocupar Mesa");
        finalizarPedido.setBounds(300, 350, 250, 40);
        add(finalizarPedido);


        agregarPlato.addActionListener(e -> {
            Plato platoSeleccionado = listaMenu.getSelectedValue();
            if (platoSeleccionado != null) {
                pedidoActual.agregarPlato(platoSeleccionado);
                
                actualizarResumenPedido();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un plato del menu para agregar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        finalizarPedido.addActionListener(e -> {
            Mesa mesaSeleccionada = (Mesa) cbMesa.getSelectedItem();
            
            if (mesaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una mesa libre.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pedidoActual.getPlatos().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El pedido no puede estar vacío. Agregue al menos un plato.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                mesaSeleccionada.ocupar(pedidoActual);
                
                Factura nuevaFactura = new Factura(mesaSeleccionada, pedidoActual);
                restaurante.facturas.add(nuevaFactura);
                
                JOptionPane.showMessageDialog(this, "Pedido finalizado para Mesa " + mesaSeleccionada.getNumero() + 
                                              "\nTotal: $" + nuevaFactura.total(), "Exito", JOptionPane.INFORMATION_MESSAGE);
                
                dispose();
            }
        });
    }
    
    private void actualizarResumenPedido() {
        StringBuilder sb = new StringBuilder("Platos en el pedido:\n");
        for (Plato p : pedidoActual.getPlatos()) {
            sb.append("- ").append(p.getNombre()).append(" ($").append(p.getPrecio()).append(")\n");
        }
        sb.append("\nTOTAL ACTUAL: $").append(pedidoActual.total());
        resumenPedido.setText(sb.toString());
    }
}
