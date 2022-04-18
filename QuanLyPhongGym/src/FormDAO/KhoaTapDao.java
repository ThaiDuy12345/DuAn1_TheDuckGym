package FormDAO;

import FormOOB.KhoaTap;
import SPClass.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhoaTapDao {
    // Thêm dữ liệu vào bảng Khóa Tập
    public static int insert(KhoaTap model){
        String sql = "exec sp_Them_QuanLyKhoaTap ?,?,?,?,?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getMaKT(),
                model.getTenKT(),
                model.getTenHLV(),
                model.getGia(),
                model.getSDT(),
                model.getSoBuoiTap(),
                model.getGhiChu()
        );
    }
    
    //Sửa 1 bản ghi dữ liệu trong bảng Khóa Tập
    public static int update(KhoaTap model){
        String sql = "exec sp_Sua_QuanLyKhoaTap ?,?,?,?,?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getMaKT(),
                model.getTenKT(),
                model.getTenHLV(),
                model.getGia(),
                model.getSDT(),
                model.getSoBuoiTap(),
                model.getGhiChu()
        );
    }
    //Xoá 1 bản ghi Khóa Tập
    public static int delete(KhoaTap model){
        String sql = "exec sp_Xoa_QuanLyKhoaTap ?";
        return jdbcHelper.executeUpdate(sql, model.getMaKT());
    } 
     //Hàm thực thi execute, trả về kết quả ResultSet
    public static ResultSet result(){
        String sql = "exec sp_Select_KhoaTap";
        ResultSet rs = null;
        try{
            rs = jdbcHelper.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    //Truy Vấn Select, trả về danh sách các bản ghi Dung Cu
   public static ArrayList<KhoaTap> Select() throws SQLException{
        ResultSet rs = result();
        ArrayList<KhoaTap> list = new ArrayList<KhoaTap>();
        while(rs.next()){
            KhoaTap kt = new KhoaTap(
                    rs.getString("MaKT"),
                    rs.getString("TenKT"),
                    rs.getString("TenHLV"),
                    rs.getFloat("Gia"),
                    rs.getString("DienThoai"),
                    rs.getInt("SoBuoiTap"),
                    rs.getString("GhiChu")
            );
            list.add(kt);
        }
        return list;
    }
    
}
    
   

