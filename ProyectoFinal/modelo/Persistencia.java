package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Persistencia {
    
    public static void guardar(Restaurante r) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Restaurante.dat"))) {
            
            o.writeObject(r);
            
            escribirARchivoTxt(r);
            
        } catch (Exception e) {
            System.err.println("Error al guardar el estado del Restaurante: " + e.getMessage());
        }
    }

    public static Restaurante cargar() {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream("Restaurante.dat"))) {
            return (Restaurante) o.readObject();
        } catch (Exception e) {
            System.err.println("Error al cargar el estado del Restaurante: " + e.getMessage());
            return new Restaurante();
        }
    }
    
    private static void escribirARchivoTxt(Restaurante r) {
        String nombreArchivoTxt = "Restaurante.txt";
        try (FileWriter fileWriter = new FileWriter(nombreArchivoTxt);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            
            printWriter.println("=========================================");
            printWriter.println("||        EXPORTACIÓN DE DATOS         ||");
            printWriter.println("||         (Restaurante.txt)           ||");
            printWriter.println("=========================================");
            
            //SECCIÓN DE MESAS
            printWriter.println("\n--- LISTA DE MESAS (" + r.getMesas().size() + ") ---");
            for (Mesa mesa : r.getMesas()) {
                printWriter.println(mesa.toString()); 
            }

            //SECCIÓN DE MENÚ (PLATOS)
            printWriter.println("\n--- LISTA DE PLATOS EN EL MENÚ (" + r.getMenu().size() + ") ---");
            for (Plato plato : r.getMenu()) {
                printWriter.println(plato.toString());
            }
            
            //SECCIÓN DE FACTURAS
            printWriter.println("\n--- LISTA DE FACTURAS CREADAS (" + r.getFacturas().size() + ") ---");
            for (Factura factura : r.getFacturas()) {
                printWriter.println(factura.toString());
                printWriter.println("-------------------------");
            }
            
            System.out.println("✅ Datos del Restaurante guardados correctamente en: Restaurante.dat y " + nombreArchivoTxt);
            
        } catch (IOException e) {
            System.err.println("❌ Advertencia: Error al escribir en el archivo de texto (" + nombreArchivoTxt + "): " + e.getMessage());
        }
    }
}
