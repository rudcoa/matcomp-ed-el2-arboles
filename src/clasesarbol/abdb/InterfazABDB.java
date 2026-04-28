package clasesarbol.abdb;
import extra.Lista;

public interface InterfazABDB<T extends Comparable<T>> {
    // Metodo para calcular el grado del árbol (al ser binario, siempre es dos)
    int getGrado();
    // Metodo para obtener la altura del arbol
    int getAltura();
    // Metodo para obtener una lista de datos DEL MISMO NIVEL
    Lista<T> getListaDatosNivel(int nivel);
    // Metodo para ver si el arbol es de tipo homogeneo
    boolean isArbolHomogeneo();
    // Metodo para ver si el arbol está COMPLETO
    boolean isArbolCompleto();
    // Metodo para ver si el arbol está CASI COMPLETO
    boolean isArbolCasiCompleto();
    // Metodo para obtener el camino (¿de un nodo a otro?)
    Lista<NodoArbol<T>> getCamino();
    // Se van a crear tres tipos de listas diferentes del árbol según el orden de la obtención de sus datos
    Lista<T> getListaPreorden();             // recorrido 1:
    Lista<T> getListaPostorden();            // recorrido 2:
    Lista<T> getListaOrdenCentral();         // recorrido 3:

}
