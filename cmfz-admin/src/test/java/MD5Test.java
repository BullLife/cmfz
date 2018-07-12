import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/12 9:25
 **/
public class MD5Test {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123", "xyz", 512);
        System.out.println(md5Hash.toString());
    }
}
