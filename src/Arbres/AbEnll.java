package Arbres;

public class AbEnll<E> implements Ab<E> {
    protected NodeA arrel;

    public AbEnll() {
        this.arrel = null;
    }

    public AbEnll(NodeA arrel){
        this.arrel = arrel;
    }

    public AbEnll(AbEnll a_esq, Object e, AbEnll a_dtr) {
        this.arrel = new NodeA(e, a_esq.arrel, a_dtr.arrel);
    }

    public E arrel() throws ArbreException {
        if (this.arrel == null) {
            throw new ArbreException("L'arbre està buit");
        }
        return (E) this.arrel.inf;
    }

    public Ab<E> fillEsquerre() {
        if(this.arrel.left == null)
            return null;

        return new AbEnll(this.arrel.left);
    }

    public Ab<E> fillDret() {
        if(this.arrel.right == null)
            return null;

        return new AbEnll(this.arrel.right);
    }

    @Override
    public boolean abBuit() {
        return arrel == null;
    }

    @Override
    public void buidar() {
        this.arrel = null;//recolector de sheet
    }


    protected class NodeA{
        NodeA left, right;
        Object inf;

        NodeA() {
            this(null);
        }

        NodeA(Object o) {
            this(o, null, null);
        }

        NodeA(Object o, NodeA e, NodeA d) {
            this.inf = o;
            this.left = e;
            this.right = d;
        }
    }
}
