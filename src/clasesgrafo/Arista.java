package clasesgrafo;
public class Arista<DatoArista, DatoVertice> {
    // Parámetros necesarios para poder formalizar una arista
    private long id;
    private DatoArista dato;
    private Vertice<DatoVertice> origen;
    private Vertice<DatoVertice> fin;

    // Para poder crear una arista por defecto esta no debe de llevar ni datos ni nodos asociados...
    public Arista() {
        this.id = (long)(Math.random()*99999); // Tendrá multiplos de 99999...
        this.dato = null;
        this.origen = null;
        this.fin = null;
    }

    // Para poder construir una arista con ciertos datos
    public Arista(long id, DatoArista dato, Vertice<DatoVertice> origen, Vertice<DatoVertice> fin) {
        this.id = id;
        this.dato = dato;
        this.origen = origen;
        this.fin = fin;
    }

    // Getter del id, que será un número largo...
    public long getId() {
        return id;
    }

    // Setter del id, que será un número largo...
    public void setId(long id) {
        this.id = id;
    }

    // Getter del dato asociado a la arista
    public DatoArista getDato() {
        return dato;
    }

    // Setter del dato asociado a la arista
    public void SetDato(DatoArista dato) {
        this.dato = dato;
    }

    // Getter del origen (es decir, el vértice de origen) asociado a la arista
    public Vertice<DatoVertice> GetOrigen() {
        return origen;
    }

    // Setter del origen (es decir, el vértice de origen) que estará asociado a la arista
    public void SetOrigen(Vertice<DatoVertice> origen) {
        this.origen = origen;
    }

    // Getter del final (es decir, el vértice final) asociado a la arista
    public Vertice<DatoVertice> GetFin() {
        return fin;
    }

    // Setter del final (es decir, el vértice final) que estará asociado a la arista
    public void SetFin(Vertice<DatoVertice> fin) {
        this.fin = fin;
    }
}
