package FormDAO;
import FormOOB.DoanhThu;
import SPClass.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DoanhThuDao {
    public static ResultSet result(){
        String sql = "exec sp_ThongKeDoanhThu";
        ResultSet rs = null;
        try{
            rs = jdbcHelper.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    //Truy Vấn Select, trả về danh sách các bản ghi Dung Cu
    public static ArrayList<DoanhThu> Select() throws SQLException{
        ResultSet rs = result();
        ArrayList<DoanhThu> list = new ArrayList<DoanhThu>();
        while(rs.next()){
            DoanhThu dt = new DoanhThu(
                    rs.getString("IDHV"),
                    rs.getFloat("HocPhi"),
                    rs.getString("NgayDongHP")
            );
            list.add(dt);
        }
        return list;
    }
}
