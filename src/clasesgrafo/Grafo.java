package clasesgrafo;
import extra.Lista;
import extra.NodoLista;

public class Grafo {
    private Conjunto<Arista<DatoArista, DatoVertice>> aristas;
    private Conjunto<Vertice<DatoVertice>> vertices;

    public Grafo() {
        vertices = new Conjunto<>();
        aristas = new Conjunto<>();
    }

    private Vertice<DatoVertice> buscarVertice(Long id) {

        NodoLista<Vertice<DatoVertice>> actual = vertices.getCabeza();

        while (actual != null) {
            if (actual.dato.getId().equals(id)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    public void agregarVertice(Long id, DV dato) {

        Vertice<DV> v = new Vertice<>(id, dato);

        if (!vertices.contiene(v)) {
            vertices.insertar(v);
        }
    }

    public void agregarArista(Long id, DA dato, Long idOrigen, Long idDestino) {

        Vertice<DV> origen = buscarVertice(idOrigen);
        Vertice<DV> destino = buscarVertice(idDestino);

        if (origen == null || destino == null) return;

        Arista<DA, DV> a = new Arista<>(id, dato, origen, destino);

        if (!aristas.contiene(a)) {
            aristas.insertar(a);
        }
    }

    public void eliminarArista(Long id) {

        Nodo<Arista<DA, DV>> actual = aristas.getCabeza();

        while (actual != null) {
            if (actual.dato.getId().equals(id)) {
                aristas.eliminar(actual.dato);
                return;
            }
            actual = actual.siguiente;
        }
    }

    public void eliminarVertice(Long id) {

        Vertice<DV> v = buscarVertice(id);
        if (v == null) return;

        // eliminar aristas conectadas
        Nodo<Arista<DA, DV>> actual = aristas.getCabeza();

        while (actual != null) {

            Arista<DA, DV> a = actual.dato;

            if (a.getOrigen().equals(v) || a.getDestino().equals(v)) {
                aristas.eliminar(a);
            }

            actual = actual.siguiente;
        }

        vertices.eliminar(v);
    }

    public void imprimir() {

        Nodo<Vertice<DV>> v = vertices.getCabeza();

        while (v != null) {

            System.out.print(v.dato.getDato() + " -> ");

            Nodo<Arista<DA, DV>> a = aristas.getCabeza();

            while (a != null) {

                if (a.dato.getOrigen().equals(v.dato)) {
                    System.out.print(a.dato.getDestino().getDato() + " ");
                }

                a = a.siguiente;
            }

            System.out.println();
            v = v.siguiente;
        }
    }
}
