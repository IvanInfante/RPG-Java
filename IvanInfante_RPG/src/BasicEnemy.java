package src;

public class BasicEnemy {

    private int PVmax, PV, dmgpoints;

    public BasicEnemy(int PVmax, int dmgpoints) {
        this.PVmax = PVmax;
        this.PV = PVmax;
        this.dmgpoints = dmgpoints;
    }

    public int getPV() {
        return PV;
    }
    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getPVmax() {
        return PVmax;
    }
    public void setPVmax(int PVmax) {
        this.PVmax = PVmax;
    }

    public int getDmgpoints() {
        return dmgpoints;
    }
    public void setDmgpoints(int dmgpoints) {
        this.dmgpoints = dmgpoints;
    }

}
