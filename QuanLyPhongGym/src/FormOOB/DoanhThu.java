package FormOOB;
public class DoanhThu {
    private String IDHV;
    private float HocPhi;
    private String NgayDongHP;
    public String getIDHV() {
        return IDHV;
    }

    public void setIDHV(String IDHV) {
        this.IDHV = IDHV;
    }

    public float getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(float HocPhi) {
        this.HocPhi = HocPhi;
    }

    public String getNgayDongHP() {
        return NgayDongHP;
    }

    public void setNgayDongHP(String NgayDongHP) {
        this.NgayDongHP = NgayDongHP;
    }

    public DoanhThu() {
    }

    public DoanhThu(String IDHV, float HocPhi, String NgayDongHP) {
        this.IDHV = IDHV;
        this.HocPhi = HocPhi;
        this.NgayDongHP = NgayDongHP;
    }
    
}
