package org.example.autoDemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-11
 * @Description:
 */
public class tokenTest {


    @Test
    public  void testToken() throws UnsupportedEncodingException {
        HashMap<String, Object> map = new HashMap<>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60);
        String token = JWT.create()
                .withHeader(map) //header
                .withClaim("userId", "21")//payload
                .withClaim("userName", "xiaoming")
                .withExpiresAt(instance.getTime())//指定令牌过期时间
                .sign(Algorithm.HMAC256("!Q#$2R@@#"));

        System.out.println(token);
    }



}
