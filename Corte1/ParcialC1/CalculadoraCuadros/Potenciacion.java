public class Potenciacion extends Operacion {

    public Potenciacion(Numero base, Numero exponente) {
        super(base, exponente);
    }

    @Override
    public Numero calcular() {
        // Utiliza la clase Math de Java
        return new Numero(Math.pow(numero1.getNumero(), numero2.getNumero()));
    }
}