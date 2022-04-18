package SPClass;
public class DoiMatKhauHelper {
    public static int DoiMatKhau(String ID, String MatKhau){
        String sql = "exec sp_DoiMatKhau ?,?";
        return jdbcHelper.executeUpdate(sql,ID,MatKhau);
    }
}
