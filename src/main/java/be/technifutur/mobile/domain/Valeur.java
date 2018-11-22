package be.technifutur.mobile.domain;

public enum Valeur {

    AS(3,1,11,11),
    ROI(5,3,4,4),
    DAME(6,4,3,3),
    VALET(1,5,20,2),
    N10(4,2,10,10),
    N9(2,6,14,0),
    N8(7,7,0,0),
    N7(8,8,0,0);



    private int ordreAtout;
    private int ordreNA;
    private int pointsAtout;
    private int pointsNA;

    Valeur(int ordreAtout, int ordreNA, int pointsAtout, int pointsNA) {
        this.ordreAtout = ordreAtout;
        this.ordreNA = ordreNA;
        this.pointsAtout = pointsAtout;
        this.pointsNA = pointsNA;
    }

    public int getOrdreAtout() {
        return ordreAtout;
    }

    public int getOrdreNA() {
        return ordreNA;
    }

    public int getPointsAtout() {
        return pointsAtout;
    }

    public int getPointsNA() {
        return pointsNA;
    }
}
