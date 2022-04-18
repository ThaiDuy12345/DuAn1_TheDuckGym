package FormDAO;
import FormOOB.NhanVien;
import SPClass.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
public class NhanVienDao {
    public static int insert(NhanVien model){
        String sql = "exec sp_Them_QuanLyNhanVien ?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getIDNV(),
                model.getDienThoai(),
                model.getHoTen()
        );
    }
    public static int update(NhanVien model){
        String sql = "exec sp_Sua_QuanLyNhanVien ?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getIDNV(),
                model.getDienThoai(),
                model.getHoTen()
        );
    }
    public static int delete(NhanVien model){
        String sql = "exec sp_Xoa_QuanLyNhanVien ?";
        return jdbcHelper.executeUpdate(sql,
                model.getIDNV()
        );
    }
    public static ResultSet result(){
        String sql = "exec sp_Select_NhanVien";
        ResultSet rs = null;
        try{
            rs = jdbcHelper.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    public static ArrayList<NhanVien> Select() throws SQLException{
        ResultSet rs = result();
        ArrayList<NhanVien> list = new ArrayList<NhanVien>();
        while(rs.next()){
            NhanVien nv = new NhanVien(
                    rs.getString("IDNV"),
                    rs.getString("DienThoai"),
                    rs.getString("HoTen")
            );
            list.add(nv);
        }
        return list;
    }
}
