package clasesgrafo;
import extra.*;

public class Conjunto<T> {

    private Lista<T> elementos;

    public Conjunto() {
        elementos = new Lista<>();
    }

    public void insertar(T elem) {
        if (!contiene(elem)) {
            elementos.insertar(elem);
        }
    }

    public boolean contiene(T elem) {
        NodoLista<T> actual = elementos.getCabeza();

        while (actual != null) {
            if (actual.dato.equals(elem)) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    public void eliminar(T elem) {
        elementos.eliminar(elem);
    }

    public int tamano() {
        int count = 0;
        NodoLista<T> actual = elementos.getCabeza();

        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }

        return count;
    }

    public boolean esVacio() {
        return elementos.getCabeza() == null;
    }


}