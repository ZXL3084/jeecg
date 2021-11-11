package org.jeecg.modules.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Map;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-08-04
 * @Description:
 */
public class JWTUtils {

    private static final String SING="!Q#$2R@@#";

    /**
     * 生成token
     */
    public String getToken(Map<String, String> map) throws UnsupportedEncodingException {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60);  //过期时间

        //创建JWT Builder
        JWTCreator.Builder builder = JWT.create();
        //payload
        map.forEach(builder::withClaim);

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SING));
        return token;
    }

    /**
     * 验证token,成功则返回信息
     */
    public static DecodedJWT verify(String token) throws UnsupportedEncodingException {
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }


}
