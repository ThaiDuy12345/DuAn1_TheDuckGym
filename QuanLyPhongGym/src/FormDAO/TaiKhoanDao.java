package FormDAO;
import FormOOB.TaiKhoan;
import SPClass.VaiTroHelper;
import SPClass.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TaiKhoanDao {
    //Thêm 1 bản ghi dữ liệu vào bảng TaiKhoan
    public static int insert(TaiKhoan model){
        String sql = "exec sp_Them_QuanLyTaiKhoan ?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getID(),
                model.getMatKhau(),
                VaiTroHelper.setVaiTro(model.getVaiTro())
        );
    }
    //Sửa 1 bản ghi dữ liệu trong bảng TaiKhoan
    public static int update(TaiKhoan model){
        String sql = "exec sp_Sua_QuanLyTaiKhoan ?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getID(),
                model.getMatKhau(),
                VaiTroHelper.setVaiTro(model.getVaiTro())
        );
    }
    //Xoá 1 bản ghi TaiKhoan
    public static int delete(TaiKhoan model){
        String sql = "exec sp_Xoa_QuanLyTaiKhoan ?";
        return jdbcHelper.executeUpdate(sql, model.getID());
    } 
    //Hàm thực thi execute, trả về kết quả ResultSet
    public static ResultSet result(){
        String sql = "exec sp_Select_TaiKhoan";
        ResultSet rs = null;
        try{
            rs = jdbcHelper.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    //Truy Vấn Select, trả về danh sách các bản ghi TaiKhoan
    public static ArrayList<TaiKhoan> Select() throws SQLException{
        ResultSet rs = result();
        ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
        while(rs.next()){
            TaiKhoan tk = new TaiKhoan(
                    rs.getString("ID"),
                    rs.getString("MatKhau"),
                    rs.getString("NgayDK"),
                    VaiTroHelper.getVaiTro(rs.getInt("VaiTro"))
            );
            list.add(tk);
        }
        return list;
    }
    //Truy vấn dữ liệu để kiểm tra đăng nhập, Nếu trả về 0,1,2 tương ứng với vai trò "Quản lý","Nhân viên","Học viên"
    //Thì đăng nhập thành công. Nếu trả về 3 thì đăng nhập thất bại
    public static int TruyVanTaiKhoan(String ID,String MatKhau) throws SQLException{
        ResultSet rs = result();
        while(rs.next()){
            if(rs.getString("ID").equals(ID) && rs.getString("MatKhau").equals(MatKhau)){
                return rs.getInt("VaiTro");
            }
        }
        return 3;
    } 
}
