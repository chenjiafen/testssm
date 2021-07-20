import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author chenjiafeng2
 * @create 2021-07-19 20:56
 * @desc 测试jwt
 **/
public class jwtdemo01 {
    public static void main(String[] args) {
        //为了方便测试，我们将过期时间设置为1分钟
         long now = System.currentTimeMillis();
        // 当前时间
         long exp = now + 1000*300;//过期时间为1分钟
        JwtBuilder testdemo = Jwts.builder().setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "testdemo")
                .setExpiration(new Date(exp));

        //加密
        System.out.println(testdemo.compact());

//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJpYXQiOjE2MjY2OTk1NTJ9.R1iiJNHJO36lEdFegRetEETUYjlrMHUuBGYiojla1fY";
//
//        Claims testdemo1 = Jwts.parser().setSigningKey("testdemo").parseClaimsJws(token).getBody();
//        System.out.println(testdemo1);
    }
}
