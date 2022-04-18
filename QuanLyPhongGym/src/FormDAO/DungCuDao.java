package FormDAO;

import FormOOB.DungCu;
import SPClass.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DungCuDao {
    // Thêm dữ liệu vào bảng tài Dụng cụ
    public static int insert(DungCu model){
        String sql = "exec sp_Them_QuanLyDungCu ?,?,?,?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getMaDC(),
                model.getTenDC(),
                model.getSoLuong(),
                model.getTinhTrang(),
                model.getHangSX(),
                model.getGhichu()
        );
    }
    
     //Sửa 1 bản ghi dữ liệu trong bảng Dụng Cụ
    public static int update(DungCu model){
        String sql = "exec sp_Sua_QuanLyDungCu ?,?,?,?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getMaDC(),
                model.getTenDC(),
                model.getSoLuong(),
                model.getTinhTrang(),
                model.getHangSX(),
                model.getGhichu()
        );
    }
    //Xoá 1 bản ghi Dụng cụ
    public static int delete(DungCu model){
        String sql = "exec sp_Xoa_QuanLyDungCu ?";
        return jdbcHelper.executeUpdate(sql, model.getMaDC());
    } 
    //Hàm thực thi execute, trả về kết quả ResultSet
    public static ResultSet result(){
        String sql = "exec sp_Select_DungCu";
        ResultSet rs = null;
        try{
            rs = jdbcHelper.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    //Truy Vấn Select, trả về danh sách các bản ghi Dung Cu
    public static ArrayList<DungCu> Select() throws SQLException{
        ResultSet rs = result();
        ArrayList<DungCu> list = new ArrayList<DungCu>();
        while(rs.next()){
            DungCu dc = new DungCu(
                    rs.getString("MaDC"),
                    rs.getString("TenDC"),
                    rs.getInt("SoLuong"),
                    rs.getString("TinhTrang"),
                    rs.getString("HangSX"),
                    rs.getString("GhiChu")
            );
            list.add(dc);
        }
        return list;
    }
    
}

