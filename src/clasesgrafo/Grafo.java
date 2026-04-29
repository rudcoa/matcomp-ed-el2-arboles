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
    public Vertice<DatoVertice> buscarVertice(long id) {
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

    // Y, ¿cómo se haría para poder agregar un nuevo vértice?
    public void agregarVertice(long id, DatoVertice dato) {
        // Se crea un nuevo vértice que contenga al identificador, y al dato que nosotros hemos pasado como parámetros
        Vertice<DatoVertice> v = new Vertice<>(id, dato);

        // Si no está contenido en el conjunto (y por ende, en la lista), entonces se insertará
        if (!vertices.contiene(v)) {
            vertices.insertar(v);
        }
    }

    // Para las aristas, sigue la misma estructura
    public void agregarArista(Long id, DatoArista dato, long idorigen, long iddestino) {
        // Primeramente, se buscan los vértices correspondientes según los identificadores que nosotros hemos pasado como argumentos
        Vertice<DatoVertice> origen = buscarVertice(idorigen);
        Vertice<DatoVertice> destino = buscarVertice(iddestino);

        // Hay un caso muy especial que es, que si la arista no posee origen o destino, entonces no es posible crearla (o añadirla formalmente al grafo)
        if (origen == null || destino == null) {
            // Porque por definición, una arista debe conectar a dos puntos, no puede ser algo tipo: "A -> null"
            return;
        }

        // Si no ha sucedido lo anterior, podemos proceder a crear a la arista
        Arista<DatoArista, DatoVertice> a = new Arista<>(id, dato, origen, destino);

        // Y hacemos lo mismo que en buscarVertice() ya que ambos tienen la estructura de un conjunto
        if (!aristas.contiene(a)) {
            // Es decir, si a ∉ Aristas -> ¡insertarla en el conjunto de las aristas!
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
