package extra;

public class NodoLista<T> {
    T dato;
    NodoLista siguiente;

    NodoLista(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
