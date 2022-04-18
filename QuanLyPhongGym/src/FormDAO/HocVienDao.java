package FormDAO;
import FormOOB.HocVien;
import SPClass.GioiTinhHelper;
import SPClass.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
public class HocVienDao {
    public static int insert(HocVien model){
        String sql = "exec sp_Them_QuanLyHocVien ?,?,?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getIDHV(),
                model.getHoTen(),
                GioiTinhHelper.setGioiTinh(model.getGioiTinh()),
                model.getDienThoai(),
                model.getGhiChu()
        );
    }
    public static int update(HocVien model){
        String sql = "exec sp_Sua_QuanLyHocVien ?,?,?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getIDHV(),
                model.getHoTen(),
                GioiTinhHelper.setGioiTinh(model.getGioiTinh()),
                model.getDienThoai(),
                model.getGhiChu()
        );
    }
    public static int delete(HocVien model){
        String sql = "exec sp_Xoa_QuanLyHocVien ?";
        return jdbcHelper.executeUpdate(sql, model.getIDHV());
    }
    public static ResultSet result(){
        String sql = "exec sp_Select_HocVien";
        ResultSet rs = null;
        try{
            rs = jdbcHelper.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    public static ArrayList<HocVien> Select() throws SQLException{
        ResultSet rs = result();
        ArrayList<HocVien> list = new ArrayList<HocVien>();
        while(rs.next()){
            HocVien hv = new HocVien(
                    rs.getString("IDHV"),
                    rs.getString("HoTen"),
                    GioiTinhHelper.getGioiTinh(rs.getBoolean("GioiTinh")),
                    rs.getString("DienThoai"),
                    rs.getString("GhiChu")
            );
            list.add(hv);
        }
        return list;
    }
}
