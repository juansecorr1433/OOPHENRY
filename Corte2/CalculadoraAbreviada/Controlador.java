package controlador;

import modelo.*;
import vista.Vista;

public class Controlador {
    private Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = vista.mostrarMenu();

            // Opción de salida (opción 6)
            if (opcion == 6) {
                vista.mostrarMensaje("Saliendo...");
                break;
            }
            
            // Si la opción no es Salir, pedimos los números
            if (opcion >= 1 && opcion <= 5) {
                int n1 = vista.leerNumero("Ingrese el primer numero: ");
                int n2 = vista.leerNumero("Ingrese el segundo numero: ");
                Operacion operacion;
                int resultado;

                try {
                    switch (opcion) {
                        case 1:
                            // Opción 1: Suma
                            operacion = new Suma(n1, n2);
                            resultado = operacion.calcular();
                            vista.mostrarResultado(resultado);
                            break;
                        case 2:
                            // Opción 2: Resta
                            operacion = new Resta(n1, n2);
                            resultado = operacion.calcular();
                            vista.mostrarResultado(resultado);
                            break;
                        case 3:
                            // Opción 3: Multiplicacion
                            operacion = new Multiplicacion(n1, n2);
                            resultado = operacion.calcular();
                            vista.mostrarResultado(resultado);
                            break;
                        case 4:
                            // Opción 4: Division
                            operacion = new Division(n1, n2);
                            resultado = operacion.calcular();
                            vista.mostrarResultado(resultado);
                            break;
                        case 5:
                            // Opción 5: Potenciacion
                            operacion = new Potenciacion(n1, n2);
                            resultado = operacion.calcular();
                            vista.mostrarResultado(resultado);
                            break;
                        default:
                            // Este caso no debería alcanzarse si el if previo funciona, 
                            // pero se mantiene por robustez.
                            vista.mostrarMensaje("Opción inválida");
                    }
                } catch (Exception e) {
                    vista.mostrarMensaje("Error: " + e.getMessage());
                }
            } else if (opcion != -1) {
                 vista.mostrarMensaje("Opción inválida");
            }
            // Si opcion es -1, significa que hubo un error de lectura en Vista,
            // y Vista ya mostró el mensaje de error.

        } while (opcion != 6);
    }
}