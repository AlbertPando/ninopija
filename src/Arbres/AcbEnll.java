package Arbres;

import java.util.ArrayList;
import java.util.Queue;

public class AcbEnll <Carta extends Comparable<Carta>> extends AbEnll implements Acb  {
    private Queue<NodeA> cua;
    @Override
    public Object arrel() throws ArbreException {
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
    public void inserir(Comparable comparable) throws ArbreException {

    }

    @Override
    public void esborrar(Comparable comparable) throws ArbreException {

    }

    @Override
    public boolean membre(Comparable comparable) {
        return false;
    }

    public void iniRecorregut (boolean sentit){
        this.cua = (Queue<NodeA>) new ArrayList<NodeA>();
    }
    /* prepara l’arbre per a ser recorregut en inordre. Després d’invocar
    aquest mètode, la invocació del mètode segRecorregut retornarà el
    primer element en inordre de l’arbre. Aquest mètode ha de emplenar la
    cua amb els elements de l’arbre aplicant un recorregut en inordre. Cal
    tenir present el paràmetre alhora d’emplenar la cua */
    public boolean finalRecorregut (){

    }
    /* retorna true si ja s’ha arribat al final del recorregut en inordre
    de l’arbre. Això és si:
    ‐ l’arbre és buit
    ‐ la darrera vegada que es va invocar segRecorregut aquest mètode
    ja va retornar el darrer element en inordre de l’arbre.
    Tot això és el mateix que dir que retorna true quan no té sentit
    invocar el mètode segRecorregut */
    public E segRecorregut () throws ArbreException{

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

