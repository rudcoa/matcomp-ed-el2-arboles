package clases;
import java.util.List;

// TAD ÁRBOL BINARIO DE BÚSQUEDA
public class  ArbolBinarioDeBusqueda<T extends Comparable<T>> implements InterfazABDB<T> {
    // Elemento imprescindible de la estructura/arquitectura de este TAD...
    private Nodo<T> raiz;
    // 1. "¿incluir grado como parámetro en el TAD o en los nodos?"
    // 2. "no hay metodo remove(), porque si no, ¿eso quitaría todas las aristas asociadas al vértice no? o hay otra manera de quitar el dato asociado al nodo"

    // Constructor POR DEFECTO del árbol binario
    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    // Constructor del árbol binario
    public ArbolBinarioDeBusqueda(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    // Metodo para añadir elementos al arbol
    public void add(Elemento<T> elemento) {
        // CASO 1: Si el nodo raiz está vacío
        if (raiz == null) {
            Nodo<T> nuevo = new Nodo<>(elemento);
            this.raiz = nuevo;
        }

        // CASO 2: Si el nodo raiz ya no está vacío
        else {
            T valor = raiz.getInicial().getValor();
            T otrovalor = elemento.getValor();
            // AQUÍ IRIA EL METODO COMPARE TO Y SERIA:
            if (otrovalor.compareTo(valor) < 0) {
                // Y ahora hay que ver si no está vacío o no
                if (raiz.getIzquierda() == null) {
                    raiz.setIzquierda(new Nodo<>(elemento));
                }
                // Si no estuviese vacio
                else {
                    ArbolBinarioDeBusqueda<T> arbol = new ArbolBinarioDeBusqueda<>(raiz.getIzquierda());
                    arbol.add(elemento);
                }
            }
            // En este caso es si el valor fuese mayor...
            else {
                // Si no hay nada a la derecha, se establece el nuevo nodo
                if (raiz.getDerecha() == null) {
                    raiz.setDerecha(new Nodo<>(elemento));
                }
                // Lo mismo en caso de que toque ir a la derecha
                else {
                    ArbolBinarioDeBusqueda<T> arbol = new ArbolBinarioDeBusqueda<>(raiz.getDerecha());
                    arbol.add(elemento);
                }
            }
        }
    }

    /* Metodo para obtener el subárbol de la izquierda
    public ArbolBinarioDeBusqueda<T> getSubArbolIzquierda() {

    }
    */


    /* Metodo para obtener el subárbol de la derecha
    public ArbolBinarioDeBusqueda<T> getSubArbolDerecha() {

    }
     */

    // Metodo para comprobar si el árbol está vacio
    public boolean isArbolEmpty() {
        return raiz == null;
    }

    // METODOS QUE HAN SIDO IMPLEMENTADOS POR LA INTERFAZ
    @Override
    public int getGrado() {
        return 0;
    }

    @Override
    public int getAltura() {
        return 0;
    }

    @Override
    public List<T> getListaDatosNivel(int nivel) {
        return List.of();
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
    public List<Nodo<T>> getCamino() {
        return List.of();
    }

    @Override
    public List<T> getListaPreorden() {
        return List.of();
    }

    @Override
    public List<T> getListaPostorden() {
        return List.of();
    }

    @Override
    public List<T> getListaOrdenCentral() {
        return List.of();
    }

    // SEA LA LISTA: [9,7,3,5,8,10,22]
    // PREORDEN: (sale la misma lista)
    // POSTORDEN: [5,3,8,7,22,10,9]
    // ORDEN CENTRAL: [3,5,7,8,9,10,22] (lista ordenada)
}
