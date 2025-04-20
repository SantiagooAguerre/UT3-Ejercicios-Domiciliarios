package paquete;

public abstract class Lista<T> implements ILista<T> {
    private Nodo<T> primero;
    
    public Lista() {
        primero = null;
    }
    
    @Override
    public boolean esVacia() {
        return primero == null;
    }
    
    @Override
    public void setPrimero(Nodo<T> unNodo) {
        primero = unNodo;
    }
    
    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(etiqueta, dato);
        insertar(nuevoNodo);
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nodo);
        }

    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> temp = primero;
        while (temp != null) {
            if (temp.getEtiqueta().compareTo(clave) == 0) {
                return temp;
            }
            temp=temp.getSiguiente();
        }
        return null;
    }
    
    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> temp = primero;
        while (temp != null) {
            sb.append(temp.getEtiqueta().toString()).append(" ");
            temp = temp.getSiguiente();
        }
        return sb.toString();
    }
    
    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> temp = primero;
        while (temp != null) {
            contador++;
            temp = temp.getSiguiente();
        }
        return contador;
    }
    @Override
    public boolean eliminar(Comparable clave) {
        Nodo<T> temp = primero;
        Nodo<T> previo = null;
        while (temp != null) {
            if (temp.getEtiqueta().compareTo(clave) == 0) {
                if (previo == null) {
                    primero = temp.getSiguiente();
                } else {
                    previo.setSiguiente(temp.getSiguiente());
                }
                return true;
            }
            previo = temp;
            temp = temp.getSiguiente();
        }
        return false;
    }
    
    
    
}
