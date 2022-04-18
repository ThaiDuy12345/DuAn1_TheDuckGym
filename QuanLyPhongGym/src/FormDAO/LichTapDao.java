package FormDAO;

import FormOOB.LichTap;
import SPClass.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LichTapDao {
      // Thêm dữ liệu vào bảng tài Lịch Tập
    public static int insert(LichTap model){
        String sql = "exec sp_Them_QuanLyLichTap ?,?,?,?,?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getIDHV(),
                model.getMaKT(),
                model.getHoTen(),
                model.getTenHLV(),
                model.getTenKT(),
                model.getNgayTap(),
                model.getGhiChu()
        );
    }
    
     //Sửa 1 bản ghi dữ liệu trong bảng Lịch Tập
    public static int update(LichTap model){
        String sql = "exec sp_Sua_QuanLyLichTap ?,?,?,?,?,?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getSTT(),
                model.getIDHV(),
                model.getMaKT(),
                model.getHoTen(),
                model.getTenHLV(),
                model.getTenKT(),
                model.getNgayTap(),
                model.getGhiChu()
        );
    }
    //Xoá 1 bản ghi Lịch Tập
    public static int delete(LichTap model){
        String sql = "exec sp_Xoa_QuanLyLichTap ?";
        return jdbcHelper.executeUpdate(sql, model.getMaKT());
    } 
     //Hàm thực thi execute, trả về kết quả ResultSet
    public static ResultSet result(){
        String sql = "exec sp_Select_LichTap";
        ResultSet rs = null;
        try{
            rs = jdbcHelper.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    //Truy Vấn Select, trả về danh sách các bản ghi Dung Cu
   public static ArrayList<LichTap> Select() throws SQLException{
        ResultSet rs = result();
        ArrayList<LichTap> list = new ArrayList<LichTap>();
        while(rs.next()){
            LichTap lt = new LichTap(
                    rs.getInt("STT"),
                    rs.getString("IDHV"),
                    rs.getString("MaKT"),
                    rs.getString("HoTen"),
                    rs.getString("TenHLV"),
                    rs.getString("TenKT"),
                    rs.getString("NgayTap"),
                    rs.getString("GhiChu")
            );
            list.add(lt);
        }
        return list;
    }
    
}
    
   
