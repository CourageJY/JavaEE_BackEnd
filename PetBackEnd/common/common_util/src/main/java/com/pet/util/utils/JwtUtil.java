package com.pet.util.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pet.models.InstitutionWorker;
import com.pet.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

public class JwtUtil {

    /** token秘钥，请勿泄露，请勿随便修改 */
    public static final String SECRET = "poy7go/IVV7+rly0uJY9Vw==";
    /** token 过期时间: 60小时 */
    public static final int CALENDARFIELD = Calendar.HOUR;
    public static final int CALENDARINTERVAL = 60;

    //普通用户生成token
    static public String getToken(User user) {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(CALENDARFIELD, CALENDARINTERVAL);
        Date expiresDate = nowTime.getTime();

        String token="";
        token= JWT.create().withAudience(user.getId())
                .withClaim("role","NormalUser")
                .withIssuedAt(iatDate)
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    //机构用户生成token
    static public String getToken(InstitutionWorker institutionWorker){
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(CALENDARFIELD, CALENDARINTERVAL);
        Date expiresDate = nowTime.getTime();

        String token="";
        token= JWT.create().withAudience(institutionWorker.getId())
                .withClaim("role","Institution")
                .withIssuedAt(iatDate)
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }
    //利用得到用户ID
    static public String getIDByToken(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        return JWT.decode(token).getAudience().get(0);
    }
}