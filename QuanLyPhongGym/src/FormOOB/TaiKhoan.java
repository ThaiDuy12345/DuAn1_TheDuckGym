package FormOOB;
public class TaiKhoan {
    private String ID;
    private String MatKhau;
    private String NgayDK;
    private String VaiTro;
    public TaiKhoan() {
    }

    public TaiKhoan(String ID, String MatKhau, String NgayDK, String VaiTro) {
        this.ID = ID;
        this.MatKhau = MatKhau;
        this.NgayDK = NgayDK;
        this.VaiTro = VaiTro;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(String NgayDK) {
        this.NgayDK = NgayDK;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }
    
}
