package clasesgrafo;

public class DatoVertice {
    private int valor;

    // Constructor por defecto de la clase (se trata como un conjunto vacío {∅})
    public DatoVertice() {
        this.valor = 0;
    }

    // Constructor de la clase,  con su argumento correspondiente
    public DatoVertice(int valor) {
        this.valor = valor;
    }

    // Getter del dato o atributo 'valor'
    public int getValor() {
        return valor;
    }

    // Setter del dato o atributo 'valor'
    public void setValor(int valor) {
        this.valor = valor;
    }
}
