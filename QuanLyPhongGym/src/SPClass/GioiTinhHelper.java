package SPClass;
public class GioiTinhHelper {
    public static String getGioiTinh(boolean gender){
        if(gender == true){
            return "Nam";
        }else{
            return "Nữ";
        }
    }
    public static boolean setGioiTinh(String gender){
        if(gender.equals("Nam")){
            return true;
        }else{
            return false;
        }
    }
}
