public abstract class OperacionCom {
    protected Numero numero;

    public OperacionCom(Numero numero) {
        this.numero = numero;
    }

    public abstract Numero calcular();
}