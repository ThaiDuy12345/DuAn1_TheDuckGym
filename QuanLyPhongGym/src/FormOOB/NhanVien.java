package FormOOB;
public class NhanVien {
    private String IDNV;
    private String DienThoai;
    private String HoTen; 
    public String getIDNV() {
        return IDNV;
    }

    public void setIDNV(String IDNV) {
        this.IDNV = IDNV;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public NhanVien(String IDNV, String DienThoai, String HoTen) {
        this.IDNV = IDNV;
        this.DienThoai = DienThoai;
        this.HoTen = HoTen;
    }

    public NhanVien() {
    }
    
}
