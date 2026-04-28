package clasesgrafo;
public class Arista<DatoArista, DatoVertice> {
    private long id;
    private DatoArista dato;
    private Vertice<DatoVertice> origen;
    private Vertice<DatoVertice> fin;


    public Arista() {
        this.id = (long)(Math.random()*99999);
        this.dato = null;
        this.origen = null;
        this.fin = null;
    }

    public Arista(long id, DatoArista dato, Vertice<DatoVertice> origen, Vertice<DatoVertice> fin) {
        this.id = id;
        this.dato = dato;
        this.origen = origen;
        this.fin = fin;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arista)) return false;
        Arista<DatoArista, DatoVertice> a = (Arista<DatoArista, DatoVertice>) o;
        return id.equals(a.id);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DatoArista getDato() {
        return dato;
    }

    public void SetDato(DatoArista dato) {
        this.dato = dato;
    }

    public Vertice<DatoVertice> GetOrigen() {
        return origen;
    }

    public void SetOrigen(Vertice<DatoVertice> origen) {
        this.origen = origen;
    }

    public Vertice<DatoVertice> GetFin() {
        return fin;
    }

    public void SetFin(Vertice<DatoVertice> fin) {
        this.fin = fin;
    }


}
