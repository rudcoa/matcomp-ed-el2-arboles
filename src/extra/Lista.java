package extra;

public class Lista<T> {
    private NodoLista<T> cabeza;

    public Lista() {
        cabeza = null;
    }

    public void insertar(Object dato) {
        NodoLista<T> nuevo = new NodoLista<T> ((T) dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // ✔ ELIMINAR (bien hecho)
    public void eliminar(T dato) {

        if (cabeza == null) return;

        // caso 1: eliminar cabeza
        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            return;
        }

        NodoLista<T> actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(dato)) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }

    public boolean contiene(Object dato) {
        NodoLista<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public NodoLista<T> getCabeza() {
        return cabeza;
    }
}
