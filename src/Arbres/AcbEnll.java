package Arbres;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AcbEnll<E extends Comparable<E>> extends AbEnll<E> implements Acb<E>, Cloneable {
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
        if (this.arrel == null)
            this.arrel = new NodeA(c);
        else
            this.arrel.inserir(c);
    }

    @Override
    public void esborrar(Comparable c) throws ArbreException {
        if (this.arrel == null)
            throw new ArbreException("L'arbre és buit");

        this.arrel = this.arrel.esborrar(c);
    }

    @Override
    public boolean membre(Comparable c) {
        if (this.arrel == null)
            return false;
        else
            return this.arrel.hiEs(c);
    }

    /* prepara l’arbre per a ser recorregut en inordre. Després d’invocar
    aquest mètode, la invocació del mètode segRecorregut retornarà el
    primer element en inordre de l’arbre. Aquest mètode ha de emplenar la
    cua amb els elements de l’arbre aplicant un recorregut en inordre. Cal
    tenir present el paràmetre alhora d’emplenar la cua */
    public void iniRecorregut(boolean sentit) {
        this.cua = new LinkedList<>();

        if (!sentit)
            this.iniEncuarMenorAMajor(this.arrel);
        else
            this.iniEncuarMajorAMenor(this.arrel);
    }

    private void iniEncuarMenorAMajor(NodeA a) {
        if (a != null) {
            iniEncuarMenorAMajor(a.left);
            this.cua.add((E) a.inf);
            iniEncuarMenorAMajor(a.right);
        }
    }

    private void iniEncuarMajorAMenor(NodeA a) {
        if (a != null) {
            iniEncuarMajorAMenor(a.right);
            this.cua.add((E) a.inf);
            iniEncuarMajorAMenor(a.left);
        }
    }

    public boolean finalRecorregut() {
        return this.cua.isEmpty();
    }
    /* retorna true si ja s’ha arribat al final del recorregut en inordre
    de l’arbre. Això és si:
    ‐ l’arbre és buit
    ‐ la darrera vegada que es va invocar segRecorregut aquest mètode
    ja va retornar el darrer element en inordre de l’arbre.
    Tot això és el mateix que dir que retorna true quan no té sentit
    invocar el mètode segRecorregut */

    public E segRecorregut() throws ArbreException {
        if (this.cua == null)
            throw new ArbreException("No s'ha invocat el mètode iniRecorregut");
        else if (this.finalRecorregut())
            throw new ArbreException("Ja s'ha acabat el recorregut");
        else if (this.abBuit())
            throw new ArbreException("S'ha buidat l'arbre!");

        E elementToReturn = this.cua.peek();
        if (!this.membre(elementToReturn))
            throw new ArbreException("S'ha usat el mètode esborrar a l'arbre");

//        Queue<E> auxCua = this.cua;
//        this.iniRecorregut(this.sentitCua());
//
//        if (!this.cua.containsAll(auxCua))
//            throw new ArbreException("S'ha usat el mètode d'inserir");

        elementToReturn = this.cua.poll();

        return elementToReturn;
    }
    /*retorna el següent element en inordre, si n’hi ha.
    Llença una excepció si:
    ‐ abans d’invocar‐lo no s’ha invocat el mètode iniRecorregut
    ‐ la darrera vegada que es va invocar ja va retornar
    el darrer element del recorregut (finalRecorregut retornaria true)
    ‐ s’invoca quan entre la invocació de iniRecorregut i la del
    mètode s’ha produït una modificació de l’arbre, això és, s’ha
    fet ús del mètode inserir, esborrar, buidar*/

    private boolean sentitCua() {
        Iterator<E> iterator = this.cua.iterator();
        E firstElement = iterator.next();

        if (iterator.hasNext()) {
            E secondElement = iterator.next();

            if (firstElement.compareTo(secondElement) > 0)
                return true;
            else
                return false;
        } else
            return false;
    }

    public int cardinalitat() {
        return iniRecorrer(this.arrel);
    }

    private int iniRecorrer(NodeA a) {
        if (a == null)
            return 0;

        if (a.left != null)
            return iniRecorrer(a.left) + 1;
        if (a.right != null)
            return iniRecorrer(a.right) + 1;

        return 0;
    }

    @Override
    public Object clone() {
        AcbEnll clon;
        try {
            clon = (AcbEnll) super.clone();

            if (this.arrel != null){
                clon.arrel = new NodeA(this.arrel.inf);

                Queue<E> auxCua = this.cua;
                Comparable<E> e;

                this.iniRecorregut(false);
                while (!this.finalRecorregut()){
                    try {
                        e = this.segRecorregut();
                        clon.inserir(e);
                    }catch (ArbreException exception) {
                        exception.printStackTrace();
                    }
                }

                // Tornem la this.cua al seu estat original
                this.cua = auxCua;
            }
        } catch (CloneNotSupportedException e){
            return null;
        }
        return clon;
    }
}
