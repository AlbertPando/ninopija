package Arbres;

import Cartes.Carta;

public class AbEnll<Carta> implements Ab {
    protected NodeA arrel;

    public AbEnll() {
        this.arrel = null;
    }

    public AbEnll(NodeA arrel){
        this.arrel = arrel;
    }

    public AbEnll(AbEnll a_esq, Carta e, AbEnll a_dtr) {
        this.arrel = new NodeA(e, a_esq.arrel, a_dtr.arrel);
    }

    public Carta arrel() throws ArbreException {
        if (this.arrel == null) {
            throw new ArbreException("L arbre esta buit");
        }
        return this.arrel.inf;
    }

    public Ab<Carta> fillEsquerre() {
        return new AbEnll<Carta>(this.arrel.esq);
    }

    public Ab<Carta> fillDret() {
        return new AbEnll<Carta>(this.arrel.esq);
    }

    @Override
    public boolean abBuit() {
        return arrel == null;
    }

    @Override
    public void buidar() {
        this.arrel = null;//recolector de sheet
    }


    protected class NodeA {
        NodeA esq, dret;
        Carta inf;

        NodeA() {
            this(null);
        }

        NodeA(Carta o) {
            this(o, null, null);
        }

        NodeA(Carta o, NodeA e, NodeA d) {
            inf = o;
            esq = e;
            dret = d;
        }
    }
}
