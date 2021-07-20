import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenjiafeng2
 * @create 2021-07-19 20:56
 * @desc 测试jwt
 **/
public class jwtdemo03 {
    public static void main(String[] args) {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE2MjY3MDcxOTgsImV4cCI6MTYyNjcwNzQ5OH0.4VahqpioFcDV5BVXxRd2G2f6YvVOcFhYboNK5m7dtkM";
        Claims testdemo = Jwts.parser().setSigningKey("testdemo")
                .parseClaimsJws(token).getBody();
        System.out.println(testdemo);

        System.out.println("id"+testdemo.getId());
        System.out.println("subject"+testdemo.getSubject());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
        System.out.println("签发时间:"+sdf.format(testdemo.getIssuedAt()));
        System.out.println("过期时 间:"+sdf.format(testdemo.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()) );

    }
}
