public abstract class CalculoGeometrico {
    protected Numero num1; // Generalmente base/lado/radio
    protected Numero num2; // Generalmente altura/lado

    public CalculoGeometrico(Numero num1, Numero num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract Numero calcular();
}