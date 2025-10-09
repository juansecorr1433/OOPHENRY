public class Vista {

    
    public static final String RESET = "\u001B[0m"; // Para restablecer el color
    
    // Colores de Texto
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    

    


    public void escribirNumero() {
        
        System.out.print(VERDE + "Digite un numero: " + RESET);
    }

    public void mostrarSalidaS(Numero resultado) {
        
        System.out.println(AZUL + " La suma es: " + resultado.getNumero() + RESET);
    }

    public void mostrarSalidaR(Numero resultado1) {
        // Texto en AZUL para el resultado de la Resta
        System.out.println(AZUL + " La resta es: " + resultado1.getNumero() + RESET);
    }

    public void mostrarSalidaM(Numero resultado2) {
        // Texto en MORADO  para el resultado de la Multiplicación
        System.out.println(MORADO + " La Multiplicacion es: " + resultado2.getNumero() + RESET);
    }
    
   
    public void mostrarSalidaD(Numero resultado3) {
        
        System.out.println(MORADO +  " La Division es: " + resultado3.getNumero() + RESET);
    }
    // ------------------------------------------------------------------
public void errorDivisionCero() {
    // Texto de error sin necesidad de un mensaje dinámico
    System.out.println(ROJO +  "\n ¡ERROR MATEMATICO! No se puede dividir por cero." + RESET);
}

    public void mostrarMenu() {
        System.out.println("");
        
        System.out.println(MORADO + "--- Menu de Operaciones ---" + RESET);
        
        
        System.out.println("1. Realizar una Suma" + VERDE + ("+") + RESET);
        System.out.println("2. Realizar una Resta" + ROJO + " (-)" + RESET);
        System.out.println("3. Realizar una Multiplicacion" + AZUL + " (*)" + RESET);
        System.out.println("4. Realizar una Division" + MORADO + " (/)" + RESET); // Opción de División
        System.out.println(ROJO + "5. Salir" + RESET); // Salir es la opción 5
        
        System.out.print(VERDE + "Seleccione una opcion: " + RESET); 
    }

    public void salirPrograma() {
       
        System.out.println(ROJO + "Adiós. Saliendo del programa..." + RESET);
    }

    public void mostrarDefault() {
        // Mensaje de error o inválido en ROJO 
        System.out.println(ROJO + "¡ERROR! Opción no válida. Por favor, intente de nuevo." + RESET);
    }
    
}
    // ------------------------------------------------------------------
