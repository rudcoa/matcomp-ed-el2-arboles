package clasesarbol.abdb;
import extra.Lista;

// TAD ÁRBOL BINARIO DE BÚSQUEDA
public class  ArbolBinarioDeBusqueda<T extends Comparable<T>> implements InterfazABDB<T> {
    // Elemento imprescindible de la estructura/arquitectura de este TAD...
    private NodoArbol<T> raiz;
    // 1. "¿incluir grado como parámetro en el TAD o en los nodos?"
    // 2. "no hay metodo remove(), porque si no, ¿eso quitaría todas las aristas asociadas al vértice no? o hay otra manera de quitar el dato asociado al nodo"

    // Constructor POR DEFECTO del árbol binario
    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    // Constructor del árbol binario
    public ArbolBinarioDeBusqueda(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    // Metodo para añadir elementos al arbol
    public void add(Elemento<T> elemento) {
        // CASO 1: Si el nodo raiz está vacío
        if (raiz == null) {
            NodoArbol<T> nuevo = new NodoArbol<>(elemento);
            this.raiz = nuevo;
        }

        // CASO 2: Si el nodo raiz ya no está vacío
        else {
            T valor = raiz.getInicial().getValor();
            T otrovalor = elemento.getValor();
            // AQUÍ IRIA EL METODO COMPARE TO Y SERIA:
            if (otrovalor.compareTo(valor) < 0) {
                // Y ahora hay que ver si no está vacío o no
                NodoArbol<T> copia = raiz.getIzquierda();
                if (copia == null) {
                    raiz.setIzquierda(new NodoArbol<>(elemento));
                }
                // Si no estuviese vacio
                else {
                }
            }
            // En este caso es si el valor fuese mayor...
            else {
                // Si no hay nada a la derecha, se establece el nuevo nodo
                if (raiz.getDerecha() == null) {
                    raiz.setDerecha(new NodoArbol<>(elemento));
                }
                // Lo mismo en caso de que toque ir a la derecha
                else {
                    ArbolBinarioDeBusqueda<T> arbol = new ArbolBinarioDeBusqueda<>(raiz.getDerecha());
                    arbol.add(elemento);
                }
            }
        }
    }

    // Metodo para obtener el subárbol de la izquierda - SON METODOS EQUIVALENTES
    public ArbolBinarioDeBusqueda<T> getSubArbolIzquierda() {
        NodoArbol<T> copia = raiz;
        // 1. HAY QUE VER QUE LA RAIZ NO ESTÉ VACÍA
        if (copia == null) {
            // No se puede devolver ningún subárbol binario...
            System.out.println("No hay subárboles que se puedan devolver ya que este arbol no contiene ningún dato");
        }
        // 2. EN CASO DE QUE NO ESTÉ VACÍA -> Izquierda
        NodoArbol<T> nuevaraiz = copia.getIzquierda();
        if (nuevaraiz == null) {
            System.out.println("Este subárbol está vacío");
        }
        ArbolBinarioDeBusqueda<T> arbol = new ArbolBinarioDeBusqueda<>(nuevaraiz);
        return arbol;
    }

    // Metodo para obtener el subárbol de la derecha - SON METODOS EQUIVALENTES
    public ArbolBinarioDeBusqueda<T> getSubArbolDerecha() {
        NodoArbol<T> copia = raiz;
        //1. TENEMOS QUE VER QUE LA RAÍZ NO ESTÉ VACÍA
        if (copia == null) {
            // No se puede devolver ningún subárbol binario...
            System.out.println("No hay subárboles que se puedan devolver");
        }
        // 2. EN CASO DE QUE NO ESTÉ VACÍA -> Derecha
        NodoArbol<T> nuevaraiz = copia.getDerecha();
        if (nuevaraiz == null) {
            System.out.println("Este subárbol está vacío");
        }
        ArbolBinarioDeBusqueda<T> arbol = new ArbolBinarioDeBusqueda<>(nuevaraiz);
        return arbol;
    }

    // Metodo para comprobar si el árbol está vacio
    public boolean isArbolEmpty() {
        // Si el único nodo del árbol está vacío (debería de ser lo mismo que preguntar, "¿hay raíz?"), entonces, es verdad
        return raiz == null;
    }

    // METODOS QUE HAN SIDO IMPLEMENTADOS POR LA INTERFAZ
    @Override
    public int getGrado() {
        // HAY QUE CONSIDERAR LOS TRES TIPOS DE CASOS
        return 2;       // lo dejaremos como 2 de momento, luego habria que considerar las posibilidades de que sea: 0 (nodo hoja), 1 ó 2 (nodo rama/nodo raiz)
    }

    @Override
    public int getAltura() {
        NodoArbol<T> copia = raiz;
        // Inicializamos unos contadores que simbolizan qué hay a la derecha y a la izquierda
        int izquierda = 0;
        int derecha = 0;

        // Ahora lo que tenemos que hacer es preguntar recursivamente en cada uno, "¿quién tiene más, la derecha, o la izquierda?"
        while (copia != null || izquierda < 2) {
            // Consigo el subarbol que contiene toda la rama izquierda
            copia = copia.getIzquierda();
            izquierda = izquierda + 1;
        }

        while (copia != null || derecha < 2) {
            // Consigo el subárbol que contiene toda la rama derecha
            copia = copia.getDerecha();
            derecha = derecha + 1;
        }

        if (izquierda > derecha) {
            return izquierda;
        }
        return derecha;
    }

    @Override
    public Lista<T> getListaDatosNivel(int nivel) {
        return Lista.of();
    }

    @Override
    public boolean isArbolHomogeneo() {
        return false;
    }

    @Override
    public boolean isArbolCompleto() {
        return false;
    }

    @Override
    public boolean isArbolCasiCompleto() {
        return false;
    }

    @Override
    public Lista<NodoArbol<T>> getCamino() {
        return Lista();
    }

    // SEA LA LISTA: [9,7,3,5,8,10,22]
    @Override
    public Lista<T> getListaPreorden() {         // PREORDEN: (sale la misma lista)
        return Lista.of();
    }

    @Override
    public Lista<T> getListaPostorden() {        // POSTORDEN: [5,3,8,7,22,10,9]
        return Lista.of();
    }

    @Override
    public Lista<T> getListaOrdenCentral() {     // ORDEN CENTRAL: [3,5,7,8,9,10,22] (lista ordenada)
        return Lista.of();
    }
}
