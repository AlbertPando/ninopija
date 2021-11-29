package Arbres;

public interface Ab<E> {
    public E arrel() throws ArbreException;

    // cal llençar una excepció si es demana l’arrel d’un arbre buit
    public Ab<E> fillEsquerre();

    // no llença excepcions. Si no té fill esquerre retorna un arbre buit
    public Ab<E> fillDret();

    // no llença excepcions. Si no té fill dret retorna una arbre buit.
    public boolean abBuit();

    public void buidar();
}
