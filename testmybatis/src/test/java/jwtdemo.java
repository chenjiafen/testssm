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
public class jwtdemo {
    public static void main(String[] args) {
        JwtBuilder testdemo = Jwts.builder().setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "testdemo");
        //加密
        System.out.println(testdemo.compact());

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJpYXQiOjE2MjY2OTk1NTJ9.R1iiJNHJO36lEdFegRetEETUYjlrMHUuBGYiojla1fY";

        Claims testdemo1 = Jwts.parser().setSigningKey("testdemo").parseClaimsJws(token).getBody();
        System.out.println(testdemo1);
    }
}
