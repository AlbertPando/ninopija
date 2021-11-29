package Arbres;

import Cartes.Carta;

public class AbEnll implements Ab {
    protected NodeA arrel;
    public AbEnll(){
        arrel=null;
    }
    public AbEnll(AbEnll a_esq,Carta e,AbEnll a_dtr) {
        arrel= new NodeA(e,a_esq.arrel,a_dtr.arrel);
    }





public Carta arrel() throws ArbreException{
if(arrel==null){
    throw new ArbreException ("L arbre esta buit");}
 return  arrel.inf;
}
  public Ab fillEsquerre()throws ArbreException{
        if(arrel !=null){
            Ab v = new AbEnll();
            ((AbEnll)v).arrel=arrel.esq;
            return v;
        }else
            throw new ArbreException("l'arbre és buit");


    }
    public Ab fillDret()throws ArbreException{
if(arrel != null){
    Ab v = new AbEnll();
    ((AbEnll)v).arrel=arrel.dret;
    return v;
}else
    throw new ArbreException("l'arbre és buit");
    }

    @Override
    public boolean abBuit() {
        return arrel==null;
    }

    @Override
    public void buidar() {
arrel=null;//recolector de sheet
    }


    protected class NodeA{
        NodeA esq, dret;
        Carta inf;
NodeA(){
    this(null);
}
NodeA(Carta o){
    this(o,null,null);
}
NodeA(Carta o,NodeA e,NodeA d){
inf = o;
esq = e;
dret = d;
}

    }

}
