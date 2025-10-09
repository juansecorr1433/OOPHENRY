import java.util.Scanner;


public class AppSuma {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Vista vista = new Vista();
        int opcion = 0;

        do {
            vista.mostrarMenu();
            try {
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        vista.escribirNumero();
                        int n1 = entrada.nextInt();
                        vista.escribirNumero();
                        int n2 = entrada.nextInt();

                        Numero numero1 = new Numero(n1);
                        Numero numero2 = new Numero(n2);

                        Suma suma = new Suma(numero1, numero2);
                        Numero resultado = suma.calcular();
                        
                        vista.mostrarSalidaS(resultado);
                        break;
                    case 2:
                        vista.escribirNumero();
                         n1 = entrada.nextInt();
                        vista.escribirNumero();
                         n2 = entrada.nextInt();

                        numero1 = new Numero(n1);
                        numero2 = new Numero(n2);

                        Resta resta = new Resta(numero1, numero2);
                        Numero resultado1 = resta.calcular();
                        
                        vista.mostrarSalidaR(resultado1);
                        break;
                        
                    case 3:
                        vista.escribirNumero();
                         n1 = entrada.nextInt();
                        vista.escribirNumero();
                         n2 = entrada.nextInt();

                        numero1 = new Numero(n1);
                        numero2 = new Numero(n2);

                        Multiplicacion multiplicacion = new Multiplicacion(numero1, numero2);
                        Numero resultado2 = multiplicacion.calcular();
                        
                        vista.mostrarSalidaM(resultado2);
                        break;
                    case 4: // Caso para la División
                        vista.escribirNumero();
                        n1 = entrada.nextInt();
                        vista.escribirNumero();
                        n2 = entrada.nextInt();

                        numero1 = new Numero(n1);
                        numero2 = new Numero(n2);

                        Division division = new Division(numero1, numero2);
    
                        try {
                          Numero resultado3 = division.calcular();
                          vista.mostrarSalidaD(resultado3);
                        } catch (ArithmeticException e) {
                        // Capturamos la excepción estándar lanzada por la clase Division
                        vista.errorDivisionCero(); 
                        }
                        break;
                    case 5:
                        vista.salirPrograma();
                        break;
                    default:
                        vista.mostrarDefault();
                        break;
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: La entrada NO es un numero entero. Por favor, intente de nuevo");

                entrada.nextLine();
            }

        } while (opcion != 5);

        entrada.close();

    }
}