package FormDAO;
import FormOOB.DSDK;
import SPClass.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DSDKDao {
    public static int update(DSDK model){
        String sql = "exec sp_Sua_QuanLyDSDK ?,?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getMaDK(),
                model.getTinhTrangKT(),
                model.getGhiChu()
        );
    }
    public static ResultSet result(){
        String sql = "exec sp_Select_DSDK";
        ResultSet rs = null;
        try{
            rs = jdbcHelper.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    public static int dangKy(DSDK model){
        String sql = "exec sp_DangKyKhoaTap ?,?";
        return jdbcHelper.executeUpdate(sql,
                model.getMaKT(),
                model.getIDHV()
        );
    }
    public static ArrayList<DSDK> Select() throws SQLException{
        ResultSet rs = result();
        ArrayList<DSDK> list = new ArrayList<DSDK>();
        while(rs.next()){
            DSDK dsdk = new DSDK(
                    rs.getInt("MaDK"),
                    rs.getString("IDHV"),
                    rs.getString("MaKT"),
                    rs.getString("HoTen"),
                    rs.getFloat("HocPhi"),
                    rs.getString("NgayDongHP"),
                    rs.getInt("SoBuoiTap"),
                    rs.getString("TinhTrangKT"),
                    rs.getString("GhiChu")
            );
            list.add(dsdk);
        }
        return list;
    }
}
