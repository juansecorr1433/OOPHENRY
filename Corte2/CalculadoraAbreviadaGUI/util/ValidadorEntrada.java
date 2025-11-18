package util;

public class ValidadorEntrada {
    
    /**
     * Valida si el string puede ser parseado como un entero.
     */
    public static boolean esEnteroValido(String valor){
        if (valor == null || valor.trim().isEmpty()) return false;
        try {
            // Intentamos parsear a Integer
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            // Captura si el usuario ingresa texto o un número fuera del rango int.
            return false;
        }
    }
}