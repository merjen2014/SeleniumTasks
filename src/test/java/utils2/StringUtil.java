package utils2;

public class StringUtil {
    public static void VerifyEquals(String expected, String actual){
        if(expected.equalsIgnoreCase(actual)){
            System.out.println("passed");
        }
        else{
            System.out.println("fail");
        }
    }
    public static void VerifyEquals(int expected, int actual){
        if(expected==actual){
            System.out.println("passed");
        }
        else{
            System.out.println("fail");
        }
    }
}
