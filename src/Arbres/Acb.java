package Arbres;

public interface Acb<E extends Comparable<E>> extends Ab<E> {
    public void inserir(E e) throws ArbreException;
    // llença una excepció si l’element que s’insereix està repetit

    public void esborrar(E e) throws ArbreException;
    // llança una excepció si l’element no hi és i en conseqüència no es
    // realitza l’eliminació

    public boolean membre(E e);
    // retorna true si l’arbre conté un element com el donat com a
    // paràmetre
}
