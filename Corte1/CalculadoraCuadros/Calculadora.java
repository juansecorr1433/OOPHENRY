import javax.swing.JOptionPane;

public class Calculadora {

    public static void main(String[] args) {

        Object[] opciones = { 
            "Suma", "Resta", "Multiplicación", "División", 
            "Potenciación", "Raíz Cuadrada", "Factorial", 
            "Área Cuadrado", "Área Rectángulo", "Área Circunferencia", "Área Triángulo Rectángulo", 
            "Salir" 
        };

        // Bucle principal (solicita operación y luego números)
        while (true) {
            
            // --- 1. Selección de Operación ---
            Object seleccion = JOptionPane.showInputDialog(null, "Seleccione la operación que desea realizar:",
                "CALCULADORA AVANZADA", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Calculadora cerrada. ¡Adiós!", "Calculadora", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String operacionSeleccionada = (String) seleccion;
            double num1 = 0, num2 = 0;
            boolean requiereNum2 = switch (operacionSeleccionada) {
                case "Suma", "Resta", "Multiplicación", "División", "Potenciación", 
                     "Área Rectángulo", "Área Triángulo Rectángulo" -> true;
                default -> false; 
            };
            boolean entradaValida = false;
            boolean cancelado = false; // Nueva bandera para manejar cancelación

            // --- 2. Entrada y Validación de Números ---
            while (!entradaValida && !cancelado) {
                try {
                    String valor1Str = JOptionPane.showInputDialog(getPromptNum1(operacionSeleccionada));
                    if (valor1Str == null) {
                        cancelado = true; // El usuario canceló la entrada del primer número
                        break; 
                    }
                    num1 = Double.parseDouble(valor1Str);

                    if (requiereNum2) {
                        String valor2Str = JOptionPane.showInputDialog(getPromptNum2(operacionSeleccionada));
                        if (valor2Str == null) {
                            cancelado = true; // El usuario canceló la entrada del segundo número
                            break;
                        }
                        num2 = Double.parseDouble(valor2Str);
                    } else {
                        num2 = 0;
                    }

                    entradaValida = true; // Números válidos

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR! Por favor, introduzca números válidos.", "Error de Entrada",
                                JOptionPane.ERROR_MESSAGE);
                }
            }
            
            if (cancelado) {
                continue; // Vuelve a solicitar la operación
            }
            
            // --- 3. Ejecución de la Operación y Manejo de Excepciones ---
            Numero numero1 = new Numero(num1);
            Numero numero2 = new Numero(num2);
            String mensaje = "";
            int tipoMensaje = JOptionPane.INFORMATION_MESSAGE;

            try {
                Numero resultado = null;
                
                switch (operacionSeleccionada) {
                    case "Suma": 
                        resultado = new Suma(numero1, numero2).calcular(); 
                        mensaje = "El resultado de la Suma (" + num1 + " + " + num2 + ") es: ";
                        break;
                    case "Resta": 
                        resultado = new Resta(numero1, numero2).calcular(); 
                        mensaje = "El resultado de la Resta (" + num1 + " - " + num2 + ") es: ";
                        break;
                    case "Multiplicación": 
                        resultado = new Multiplicacion(numero1, numero2).calcular(); 
                        mensaje = "El resultado de la Multiplicación (" + num1 + " * " + num2 + ") es: ";
                        break;
                    case "División": 
                        resultado = new Division(numero1, numero2).calcular(); 
                        mensaje = "El resultado de la División (" + num1 + " / " + num2 + ") es: ";
                        break;
                    case "Potenciación": 
                        resultado = new Potenciacion(numero1, numero2).calcular(); 
                        mensaje = "El resultado de la Potenciación (" + num1 + " ^ " + num2 + ") es: ";
                        break;
                        
                    case "Raíz Cuadrada": 
                        resultado = new RaizCuadrada(numero1).calcular(); 
                        mensaje = "El resultado de la Raíz Cuadrada de " + num1 + " es: ";
                        break;
                    case "Factorial": 
                        resultado = new Factorial(numero1).calcular(); 
                        mensaje = "El resultado del Factorial (" + (long)num1 + "!) es: ";
                        break;
                        
                    case "Área Cuadrado": 
                        // Nota: Se pasa numero2 como 'dummy' pero no se usa en el cálculo.
                        resultado = new AreaCuadrado(numero1, numero2).calcular();
                        mensaje = "El área del cuadrado con lado " + num1 + " es: ";
                        break;
                    case "Área Rectángulo": 
                        resultado = new AreaRectangulo(numero1, numero2).calcular();
                        mensaje = "El área del rectángulo (" + num1 + "x" + num2 + ") es: ";
                        break;
                    case "Área Circunferencia": 
                        // Nota: Se pasa numero2 como 'dummy' pero no se usa en el cálculo.
                        resultado = new AreaCircunferencia(numero1, numero2).calcular();
                        mensaje = "El área del círculo con radio " + num1 + " es: ";
                        break;
                    case "Área Triángulo Rectángulo": 
                        resultado = new AreaTrianguloRectangulo(numero1, numero2).calcular();
                        mensaje = "El área del triángulo recto (" + num1 + "x" + num2 + ") es: ";
                        break;
                }
                
                if (resultado != null) {
                    mensaje += String.format("%.4f", resultado.getNumero());
                }

            } catch (ArithmeticException e) {
                mensaje = "¡ERROR de Cálculo! " + e.getMessage() + ". Intente de nuevo.";
                tipoMensaje = JOptionPane.ERROR_MESSAGE;
            } catch (Exception e) {
                mensaje = "¡ERROR inesperado! " + e.getMessage();
                tipoMensaje = JOptionPane.ERROR_MESSAGE;
            }

            // --- 4. Mostrar el Resultado (o el Error) ---
            JOptionPane.showMessageDialog(null, mensaje, "Resultado de la Operación", tipoMensaje);
            
        } 
    }
    
    // --- Métodos Auxiliares ---
    private static String getPromptNum1(String operacion) {
        return switch (operacion) {
            case "Raíz Cuadrada", "Factorial" -> "Introduzca el número (N):";
            case "Área Cuadrado" -> "Introduzca el lado:";
            case "Área Circunferencia" -> "Introduzca el radio:";
            case "Potenciación" -> "Introduzca la base:";
            case "División" -> "Introduzca el dividendo:";
            case "Área Rectángulo", "Área Triángulo Rectángulo" -> "Introduzca la base:";
            default -> "Introduzca el primer número:";
        };
    }
    
    // ** SOLUCIÓN: Hacemos explícitos los casos de Suma, Resta y Multiplicación **
    private static String getPromptNum2(String operacion) {
        return switch (operacion) {
            case "Potenciación" -> "Introduzca el exponente:";
            case "División" -> "Introduzca el divisor:";
            case "Área Rectángulo", "Área Triángulo Rectángulo" -> "Introduzca la altura:";
            // Incluir casos de operaciones básicas para mayor claridad y robustez:
            case "Suma", "Resta", "Multiplicación" -> "Introduzca el segundo número:";
            default -> "Introduzca el segundo número:"; // Redundante con los casos Suma, Resta, Multi, pero no afecta.
        };
    }
}