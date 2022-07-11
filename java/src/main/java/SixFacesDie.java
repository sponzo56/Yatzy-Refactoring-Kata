public class SixFacesDie implements IDie {

    public static int nbFaces = 6;
    private int face;

    public SixFacesDie(int face) {
        this.face = face;
    }

    @Override
    public int getFaceValue() {
        return this.face;
    }
}
