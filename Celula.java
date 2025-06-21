public class Celula {
    int valor;
    boolean fixa;

    public Celula(int valor, boolean fixa) {
        this.valor = valor;
        this.fixa = fixa;
    }

    public int getValor() {
        return valor;
    }

    public boolean isFixa() {
        return fixa;
    }

    public void setValor(int valor) {
        if (!fixa) {
            this.valor = valor;
        }
    }

    @Override
    public String toString() {
        return valor == 0 ? "." : String.valueOf(valor);
    }
}
