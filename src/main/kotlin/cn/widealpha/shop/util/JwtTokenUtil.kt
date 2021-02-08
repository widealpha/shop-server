package cn.widealpha.shop.util

import io.jsonwebtoken.*
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap


object JwtTokenUtil {
    private const val SECRET = "kmh_shop_secret"
    private const val NORMAL = "normal"
    const val TOKEN_HEADER = "Authorization"
    const val TOKEN_PREFIX = "Bearer"
    private const val EXPIRATION = 60 * 60 * 24 * 7L //过期时间3小时

    //创建token
    fun createToken(username: String?, role: String?): String {
        val map = HashMap<String, Any?>()
        map[NORMAL] = role
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .setClaims(map)
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION * 1000))
            .compact()
    }

    //从token中获取用户名(此处的token是指去掉前缀之后的)
    fun getUserName(token: String): String? {
        return try {
            getTokenBody(token)?.subject
        } catch (e: Exception) {
            null.toString()
        }
    }

    fun getUserRole(token: String): String {
        return getTokenBody(token)?.get(NORMAL) as String
    }

    private fun getTokenBody(token: String): Claims? {
        var claims: Claims? = null
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).body
        } catch (e: ExpiredJwtException) {
            e.printStackTrace()
        } catch (e: UnsupportedJwtException) {
            e.printStackTrace()
        } catch (e: MalformedJwtException) {
            e.printStackTrace()
        } catch (e: SignatureException) {
            e.printStackTrace()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
        return claims
    }

    //是否已过期
    fun isExpiration(token: String): Boolean? {
        try {
            return getTokenBody(token)?.expiration?.before(Date())
        } catch (e: Exception) {
            println(e.message)
        }
        return true
    }
}