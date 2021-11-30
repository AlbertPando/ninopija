package Arbres;

import java.util.ArrayList;
import java.util.Queue;

public class AcbEnll<E extends Comparable<E>> extends AbEnll<E> implements Acb<E> {
    private Queue<E> cua;

    @Override
    public E arrel() throws ArbreException {
        return super.arrel();
    }

    @Override
    public Ab fillEsquerre() {
        return super.fillEsquerre();
    }

    @Override
    public Ab fillDret() {
        return super.fillDret();
    }

    @Override
    public boolean abBuit() {
        return super.abBuit();
    }

    @Override
    public void buidar() {
        super.buidar();
    }

    @Override
    public void inserir(Comparable c) throws ArbreException {
        this.arrel = inserirRecorrer(this.arrel, c);
    }

    private NodeA inserirRecorrer(NodeA n, Comparable c) throws ArbreException {
        if (n == null)
            n = new NodeA(c);
        else {
            int compare = c.compareTo(n.inf);
            if (compare == 0)
                throw new ArbreException("Està repetit " + c);

            if (compare < 0)
                n.left = inserirRecorrer(n.left, c);
            else
                n.right = inserirRecorrer(n.right, c);
        }

        return n;
    }

    @Override
    public void esborrar(Comparable c) throws ArbreException {
        this.arrel = esborrarRecorrer(this.arrel, c);
    }

    private NodeA esborrarMinim(NodeA n) {
        NodeA aux = n;
        if (aux.left == null)
            return aux.right;

        while (aux.left.left != null)
            aux = aux.left;

        aux.left = aux.left.right;

        return n;
    }

    private E buscarMinim(NodeA n) {
        while (n.left != null)
            n = n.left;

        return (E) n.inf;
    }

    private NodeA esborrarRecorrer(NodeA n, Comparable c) throws ArbreException {
        if (n == null)
            throw new ArbreException("No existeix " + c);

        int compare = c.compareTo(n.inf);

        if (compare < 0) // Es va a l'esquerra per eliminar
            n.left = esborrarRecorrer(n.left, c);
        else {
            if (compare > 0) // Si no, cap a la dreta
                n.right = esborrarRecorrer(n.right, c);
            else { // Es el que volem eliminar
                if (n.left == null && n.right == null) // Es fulla
                    n = null;
                else {
                    if (n.left != null && n.right != null) {
                        n.inf = buscarMinim(n);
                        n.right = esborrarMinim(n.right);
                    } else {
                        if (n.left == null)
                            n = n.right;
                        else
                            n = n.left;
                    }
                }
            }
        }

        return n;
    }

    @Override
    public boolean membre(Comparable c) {
        return membreRecorrer(super.arrel, c);
    }

    private boolean membreRecorrer(NodeA n, Comparable c) {
        if (n == null)
            return false;

        int compare = c.compareTo(n.inf);

        if (compare == 0)
            return true;

        if (compare < 0)
            return membreRecorrer(n.left, c);
        else
            return membreRecorrer(n.right, c);
    }

    public void iniRecorregut(boolean sentit) {
        this.cua = (Queue<E>) new ArrayList<E>();
    }
    /* prepara l’arbre per a ser recorregut en inordre. Després d’invocar
    aquest mètode, la invocació del mètode segRecorregut retornarà el
    primer element en inordre de l’arbre. Aquest mètode ha de emplenar la
    cua amb els elements de l’arbre aplicant un recorregut en inordre. Cal
    tenir present el paràmetre alhora d’emplenar la cua */

    public boolean finalRecorregut() {
        return false;
    }
    /* retorna true si ja s’ha arribat al final del recorregut en inordre
    de l’arbre. Això és si:
    ‐ l’arbre és buit
    ‐ la darrera vegada que es va invocar segRecorregut aquest mètode
    ja va retornar el darrer element en inordre de l’arbre.
    Tot això és el mateix que dir que retorna true quan no té sentit
    invocar el mètode segRecorregut */

    public NodeA segRecorregut() throws ArbreException {
        if (this.cua == null)
            throw new ArbreException("No s'ha invocat el mètode iniRecorregut");

        return (NodeA) super.arrel;
    }
    /*retorna el següent element en inordre, si n’hi ha.
    Llença una excepció si:
    ‐ abans d’invocar‐lo no s’ha invocat el mètode iniRecorregut
    ‐ la darrera vegada que es va invocar ja va retornar
    el darrer element del recorregut (finalRecorregut retornaria true)
    ‐ s’invoca quan entre la invocació de iniRecorregut i la del
    mètode s’ha produït una modificació de l’arbre, això és, s’ha
    fet ús del mètode inserir, esborrar, buidar*/
}

