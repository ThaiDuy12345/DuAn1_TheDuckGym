package FormOOB;
import java.util.Date;
public class HocVien {
    private String IDHV;
    private String HoTen;
    private String GioiTinh;
    private String DienThoai;
    private String GhiChu;
    public HocVien() {
    }

    public HocVien(String IDHV, String HoTen, String GioiTinh, String DienThoai, String GhiChu) {
        this.IDHV = IDHV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
    }

    public String getIDHV() {
        return IDHV;
    }

    public void setIDHV(String IDHV) {
        this.IDHV = IDHV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

}

