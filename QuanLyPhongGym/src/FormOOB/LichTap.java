package FormOOB;
import java.util.Date;
public class LichTap {
    private int STT;
    private String IDHV;
    private String MaKT;
    private String HoTen;
    private String TenHLV;
    private String TenKT;
    private String NgayTap;
    private String GhiChu;
    public LichTap(int STT, String IDHV, String MaKT, String HoTen, String TenHLV, String TenKT, String NgayTap, String GhiChu) {
        this.STT = STT;
        this.IDHV = IDHV;
        this.MaKT = MaKT;
        this.HoTen = HoTen;
        this.TenHLV = TenHLV;
        this.TenKT = TenKT;
        this.NgayTap = NgayTap;
        this.GhiChu = GhiChu;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
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

    public String getTenHLV() {
        return TenHLV;
    }

    public void setTenHLV(String TenHLV) {
        this.TenHLV = TenHLV;
    }

    public String getTenKT() {
        return TenKT;
    }

    public void setTenKT(String TenKT) {
        this.TenKT = TenKT;
    }

    public String getNgayTap() {
        return NgayTap;
    }

    public void setNgayTap(String NgayTap) {
        this.NgayTap = NgayTap;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    public LichTap() {
    }

    
}
