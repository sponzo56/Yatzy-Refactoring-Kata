public class Die implements IDie {

    private int face;

    public Die(int face) {
        this.face = face;
    }

    public int getFaceValue() {
        return this.face;
    }
}
