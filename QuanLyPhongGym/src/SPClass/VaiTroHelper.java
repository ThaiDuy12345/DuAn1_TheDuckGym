package SPClass;
public class VaiTroHelper {
    public static String getVaiTro(int index){
        if(index == 0){
            return "Quản lý";
        }else if(index == 1){
            return "Nhân viên";
        }else{
            return "Học viên";
        }
    }
    public static int setVaiTro(String role){
        if(role.equals("Quản lý")){
            return 0;
        }else if(role.equals("Nhân viên")){
            return 1;
        }else{
            return 2;
        }
    }
}
