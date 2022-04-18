package FormOOB;
public class DSDK {
    private int MaDK; 
    private String IDHV;
    private String MaKT;
    private String HoTen;
    private float HocPhi;
    private String NgayDongHP;
    private int SoBuoiTap;
    private String TinhTrangKT;
    private String GhiChu;
    public DSDK(int MaDK, String IDHV, String MaKT, String HoTen, float HocPhi, String NgayDongHP, int SoBuoiTap, String TinhTrangKT, String GhiChu) {
        this.MaDK = MaDK;
        this.IDHV = IDHV;
        this.MaKT = MaKT;
        this.HoTen = HoTen;
        this.HocPhi = HocPhi;
        this.NgayDongHP = NgayDongHP;
        this.SoBuoiTap = SoBuoiTap;
        this.TinhTrangKT = TinhTrangKT;
        this.GhiChu = GhiChu;
    }

    public int getMaDK() {
        return MaDK;
    }

    public void setMaDK(int MaDK) {
        this.MaDK = MaDK;
    }

    public String getIDHV() {
        return IDHV;
    }

    public void setIDHV(String IDHV) {
        this.IDHV = IDHV;
    }

    public String getMaKT() {
        return MaKT;
    }

    public void setMaKT(String MaKT) {
        this.MaKT = MaKT;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
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

    public int getSoBuoiTap() {
        return SoBuoiTap;
    }

    public void setSoBuoiTap(int SoBuoiTap) {
        this.SoBuoiTap = SoBuoiTap;
    }

    public String getTinhTrangKT() {
        return TinhTrangKT;
    }

    public void setTinhTrangKT(String TinhTrangKT) {
        this.TinhTrangKT = TinhTrangKT;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public DSDK() {
    }

}
