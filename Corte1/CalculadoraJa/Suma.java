public class Suma extends Operacion{

    public Suma(Numero numero1, Numero numero2){
        super(numero1, numero2);
    }

    @Override
    public Numero calcular() {
        return new Numero(numero1.getNumero() + numero2.getNumero());
    }

   

}