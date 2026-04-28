package clasesgrafo;
import extra.Lista;

public class Vertice<DatoVertice> {
    private Long id;
    private DatoVertice dato;

    public Vertice(Long id, DatoVertice dato) {
        this.id = id;
        this.dato = dato;
    }

    public Long getId() { return id; }
    public DatoVertice getDato() { return dato; }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertice)) return false;
        Vertice<DatoVertice> v = (Vertice<DatoVertice>) o;
        return id.equals(v.id);
    }

}
