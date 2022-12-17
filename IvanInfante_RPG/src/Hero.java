package src;

public class Hero {

    // attributes all heroes have
    private String name, heroClasse;
    private int PVmax, PV, maxAR, AR, dmgpoints, maxdmgpoints, healpoints, specialpoints, maxSpecialPoints;

    // constructeur de héro
    public Hero(String name, String heroClasse, int PVmax, int maxAR, int maxdmgpoints, int healpoints, int maxSpecialPoints) {
        this.name = name;
        this.heroClasse = heroClasse;
        this.PVmax = PVmax;
        this.PV = PVmax;
        this.maxAR = maxAR;
        this.AR = maxAR;
        this.maxdmgpoints = maxdmgpoints;
        this.dmgpoints = maxdmgpoints;
        this.healpoints = healpoints;
        this.maxSpecialPoints = maxSpecialPoints;
        this.specialpoints = maxSpecialPoints;
    }

    public String getName() {
        return name;
    }

    public String getHeroClasse() {
        return heroClasse;
    }

    public int getMaxdmgpoints() {
        return maxdmgpoints;
    }
    public void setMaxdmgpoints(int maxdmgpoints) {
        this.maxdmgpoints = maxdmgpoints;
    }

    public int getDmgpoints() {
        return dmgpoints;
    }
    public void setDmgpoints(int dmgpoints) {
        this.dmgpoints = dmgpoints;
    }

    public int getHealpoints() {
        return healpoints;
    }
    public void setHealpoints(int healpoints) {
        this.healpoints = healpoints;
    }

    public int getPVmax() {
        return PVmax;
    }
    public void setPVmax(int PVmax) {
        this.PVmax = PVmax;
    }

    public int getPV() {
        return PV;
    }
    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getMaxAR() {
        return maxAR;
    }
    public void setMaxAR(int maxAR) {
        this.maxAR = maxAR;
    }

    public int getAR() {
        return AR;
    }
    public void setAR(int AR) {
        this.AR = AR;
    }

    public int getMaxSpecialPoints() {
        return maxSpecialPoints;
    }
    public void setMaxSpecialPoints(int maxSpecialPoints) {
        this.maxSpecialPoints = maxSpecialPoints;
    }

    public int getSpecialpoints() {
        return specialpoints;
    }
    public void setSpecialpoints(int specialpoints) {
        this.specialpoints = specialpoints;
    }
}
