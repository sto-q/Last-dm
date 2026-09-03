public class dy {
    private Zhi zhi;
    private Mohe mohe;
    public dy() {};
    public dy(Zhi zhi, Mohe mohe) {
        this.zhi = zhi;
        this.mohe = mohe;
    }
    public void print() {
        System.out.printf("打印机使用%s墨盒在%s纸张上打印\n",mohe.getcolor(),zhi.getZhi());
    }

    public Zhi getZhi() {
        return zhi;
    }

    public void setZhi(Zhi zhi) {
        this.zhi = zhi;
    }

    public Mohe getMohe() {
        return mohe;
    }

    public void setMohe(Mohe mohe) {
        this.mohe = mohe;
    }
}
