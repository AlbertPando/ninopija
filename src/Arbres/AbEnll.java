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

        public void inserir(Comparable c) throws ArbreException {
            int compare = c.compareTo(this.inf);
            if (compare == 0)
                throw new ArbreException("Està repetit " + c);
            else if (compare < 0){
                if (this.left != null)
                this.left.inserir(c);
                else
                    this.left = new NodeA(c);
            }
            else{
                if (this.right != null)
                    this.right.inserir(c);
                else
                    this.right = new NodeA(c);
            }
        }

        public boolean hiEs (Comparable c){
            int compare = c.compareTo(this.inf);

            if (compare == 0)
                return true;

            if (compare < 0){
                if (this.left == null)
                    return false;
                return this.left.hiEs(c);
            }
            else{
                if (this.right == null)
                    return false;
                return this.right.hiEs(c);
            }
        }

        public NodeA esborrar(Comparable c) throws ArbreException {
            int compare = c.compareTo(this.inf);

            if (compare < 0) { // Es va a l'esquerra per eliminar
                if (this.left != null) {
                    this.left = this.left.esborrar(c);
                    return this;
                } else
                    throw new ArbreException("No es pot esborrar, no hi és.");
            } else if (compare > 0) { // Si no, cap a la dreta
                if (this.right != null) {
                    this.right = this.right.esborrar(c);
                    return this;
                } else
                    throw new ArbreException("No es pot esborrar, no hi és.");
            } else { // Es el que volem eliminar
                if (this.left == null && this.right == null) { // Es fulla
                    this.inf = this.right.buscarMinim();
                    this.right = this.right.esborrar((Comparable) this.inf);

                    return this;
                } else if (this.left != null && this.right != null)
                    return null;
                else if (this.left == null)
                    return this.right;
                else
                    return this.left;
            }
        }

        private E buscarMinim() {
            if (this.left == null)
                return (E) this.inf;

            NodeA aux = this.left;
            while (aux.left != null)
                aux = aux.left;

            return (E) aux.inf;
        }
    }
}
