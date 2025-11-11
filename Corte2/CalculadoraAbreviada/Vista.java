package vista;

import java.util.Scanner;

public class Vista {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        
        System.out.println("\n=== CALCULADORA CON OPERACIONES ABREVIADAS ==="); 
        System.out.println("1. Suma");          
        System.out.println("2. Resta");         
        System.out.println("3. Multiplicacion");  
        System.out.println("4. Division");      
        System.out.println("5. Potenciacion");  
        System.out.println("6. Salir");         
        System.out.print("Seleccione una opcion: ");
        
        
        try {
            return sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            sc.next(); 
            return -1; 
        }
    }

    public int leerNumero(String mensaje) {
        System.out.print(mensaje);
        try {
            return sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            sc.next(); 
            
            return 0; 
        }
    }

    public void mostrarResultado(int resultado) {
        System.out.println("Resultado: " + resultado);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}