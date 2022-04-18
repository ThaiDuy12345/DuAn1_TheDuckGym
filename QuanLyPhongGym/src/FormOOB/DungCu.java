package FormOOB;
public class DungCu {
    private String MaDC;
    private String TenDC;
    private int SoLuong;
    private String TinhTrang;
    private String HangSX;
    private String Ghichu;
    public DungCu() {
    }

    public DungCu(String MaDC, String TenDC, int SoLuong, String TinhTrang, String HangSX, String Ghichu) {
        this.MaDC = MaDC;
        this.TenDC = TenDC;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
        this.HangSX = HangSX;
        this.Ghichu = Ghichu;
    }

    public String getMaDC() {
        return MaDC;
    }

    public void setMaDC(String MaDC) {
        this.MaDC = MaDC;
    }

    public String getTenDC() {
        return TenDC;
    }

    public void setTenDC(String TenDC) {
        this.TenDC = TenDC;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getHangSX() {
        return HangSX;
    }

    public void setHangSX(String HangSX) {
        this.HangSX = HangSX;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String Ghichu) {
        this.Ghichu = Ghichu;
    }

}
