import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sunli
 * @date 2020/3/24 1:11
 */
public class TestOne {
    public static void main(String[] args) {
        String password = "123";

        String password1 = new BCryptPasswordEncoder(16).encode(password);

        System.out.println(password1);

//        String str2 = "$2a$10$W/pEpRAsvANzINAJnhEnKuY2/lp6Azv51xQ7OJEz3FHCH05zq/Cs6";

//        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
//        // 第一个参数为明文，第二个参数为密文
//        Boolean t = encode.matches(password,password1);
//        System.out.println(t);
    }
}
