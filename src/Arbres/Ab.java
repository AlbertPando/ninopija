package Arbres;

import Cartes.Carta;

public interface Ab {
    public Carta arrel () throws ArbreException;
    // cal llençar una excepció si es demana l’arrel d’un arbre buit
    public Ab fillEsquerre() throws ArbreException;
    // no llença excepcions. Si no té fill esquerre retorna un arbre buit
    public Ab fillDret() throws ArbreException;
    // no llença excepcions. Si no té fill dret retorna una arbre buit.
    public boolean abBuit();
    public void buidar();
}
