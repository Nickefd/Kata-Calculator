public enum Roman {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
    XI(11), XII(12), XIII(13), XIV(14), XV(15), L(50), C(100), D(500), M(1000);
    private final int value;
    private Roman(int value) {
        this.value = value;
    }
    public int toInt() {
        return value;
    }
}
