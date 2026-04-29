package clasesgrafo;
import extra.NodoLista;

public class Grafo {
    // Un conjunto de un grafo, está definido tal que: G = {V,E}
    private Conjunto<Arista<DatoArista, DatoVertice>> aristas;          // donde E es el conjunto de las aristas
    private Conjunto<Vertice<DatoVertice>> vertices;                    // y V es el conjunto de todos los vértices del grafo

    // Para poder crear un grafo, solo bastaría con crear dos conjuntos vacíos: G = {{Ø}, {Ø}}
    public Grafo() {
        vertices = new Conjunto<>();
        aristas = new Conjunto<>();
    }

    // ¿Cómo podríamos buscar un vértice dentro del conjunto de los vértices? Solo hay que hacerlo según su identificador...
    public Vertice<DatoVertice> buscarVertice(Long id) {
        // Se copia la cabeza del conjunto es decir, la lista de los vértices
        NodoLista<Vertice<DatoVertice>> actual = vertices.getElementos().getCabeza();

        // Se itera sobre la cabeza elemento a elemento hasta que no quede ninguno, es decir, que esté vacía
        while (actual != null) {
            // Si en algún momento el identificador del vértice coincide con el id que hemos introducido, entonces se devolverá ese vértice (o su dato asociado, aún pendiente de decidir)
            if (actual.getDato().equals(id)) {
                // Devolver el dato del nodo equivale a devolver el elemento en esa posición de la lista, que en según el contexto de uso, se trataría de un vértice
                return actual.getDato();
            }
            // Si no sucede nada de lo anterior, se pasa al siguiente elemento
            actual.setSiguiente(actual.getSiguiente());
        }
        // Y si el identificador que hemos aportado no se encuentra en la lista de vértices, pues, no se devuelve nada como tal...
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
