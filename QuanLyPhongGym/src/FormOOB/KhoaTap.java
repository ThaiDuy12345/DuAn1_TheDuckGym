package FormOOB;
public class KhoaTap {
   private String MaKT;
   private String TenKT;
   private String TenHLV;
   private float Gia;
   private String SDT;
   private int SoBuoiTap;
   private String GhiChu;
    public String getMaKT() {
        return MaKT;
    }

    public void setMaKT(String MaKT) {
        this.MaKT = MaKT;
    }

    public String getTenKT() {
        return TenKT;
    }

    public void setTenKT(String TenKT) {
        this.TenKT = TenKT;
    }

    public String getTenHLV() {
        return TenHLV;
    }

    public void setTenHLV(String TenHLV) {
        this.TenHLV = TenHLV;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getSoBuoiTap() {
        return SoBuoiTap;
    }

    public void setSoBuoiTap(int SoBuoiTap) {
        this.SoBuoiTap = SoBuoiTap;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public KhoaTap() {
    }

    public KhoaTap(String MaKT, String TenKT, String TenHLV, float Gia, String SDT, int SoBuoiTap, String GhiChu) {
        this.MaKT = MaKT;
        this.TenKT = TenKT;
        this.TenHLV = TenHLV;
        this.Gia = Gia;
        this.SDT = SDT;
        this.SoBuoiTap = SoBuoiTap;
        this.GhiChu = GhiChu;
    }
   
}
