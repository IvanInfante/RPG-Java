package src;

public class Item {

    String name;
    int nbrInInv;
    int maxnbrInInv;
    int heal;

    public Item(String name, int heal, int nbrInInv, int maxnbrInInv) {
        this.name = name;
        this.heal = heal;
        this.maxnbrInInv = maxnbrInInv;
        this.nbrInInv = nbrInInv;
    }

    public String getName() {
        return name;
    }

    public int getHeal() {
        return heal;
    }

    public int getNbrInInv() {
        return nbrInInv;
    }
    public void setNbrInInv(int nbrInInv) {
        this.nbrInInv = nbrInInv;
    }

    public int getMaxnbrInInv() {
        return maxnbrInInv;
    }
    public void setMaxnbrInInv(int maxnbrInInv) {
        this.maxnbrInInv = maxnbrInInv;
    }
}
