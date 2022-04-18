package SPClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class jdbcHelper {
    //Các phần tử dùng để kế nối
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=TheDuckGym";
    private static String username = "sa";
    private static String password = "";
    //Hàm truyền vào câu lệnh sql và các giá trị của câu lệnh, trả về phần tử statement
    public static PreparedStatement prepareStatement(String sql, Object...args) throws SQLException{
        try{
            Class.forName(driver);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement pstmt = null;
        pstmt = connection.prepareStatement(sql);
        for(int i=0;i<args.length;i++){
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }
    //ExecuteUpdate, trả về kết quả int, nếu kết quả int > 0 thì thực thi thành công
    public static int executeUpdate(String sql, Object...args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            try {
                return stmt.executeUpdate();
            } 
            finally{
                stmt.getConnection().close();
            }
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //ExecuteQuery, trả về kết quả bản ghi trong table database
    public static ResultSet executeQuery(String sql, Object...args) {
        try{
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
