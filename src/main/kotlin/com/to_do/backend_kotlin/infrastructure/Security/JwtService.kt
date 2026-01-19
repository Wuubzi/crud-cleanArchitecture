package com.to_do.backend_kotlin.infrastructure.Security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*
import java.util.function.Function


@Service
class JwtService {

    @Value("\${jwt.secret.key}")
    lateinit var secret: String

    @Value("\${jwt.expiration}")
    val expiration: Long = 0

    fun extractUsername(token: String): String = extractClaim(token) { it.subject }

    fun <T> extractClaim(
        token: String,
        claimsResolver: Function<Claims, T>
    ): T {
        val claims = extractAllClaims(token)
        return claimsResolver.apply(claims)
    }

    fun generateToken(userDetails: UserDetails): String {
        val roles = userDetails.authorities
            .map(GrantedAuthority::getAuthority)

        val extraClaims = mapOf(
            "roles" to roles
        )

        return generateToken(extraClaims, userDetails)
    }

    fun generateToken(
        extraClaims: Map<String, Any>,
        userDetails: UserDetails
    ): String =
        buildToken(extraClaims, userDetails, expiration)

    private fun buildToken(
        extraClaims: Map<String, Any>,
        userDetails: UserDetails,
        expiration: Long
    ): String =
        Jwts.builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(signInKey, SignatureAlgorithm.HS256)
            .compact()

    fun isTokenValid(token: String, userDetails: UserDetails?): Boolean {
        val username = extractUsername(token)
        return username == userDetails!!.username && !isTokenExpired(token)
    }

    private fun isTokenExpired(token: String): Boolean =
        extractExpiration(token).before(Date())

    private fun extractExpiration(token: String): Date =
        extractClaim(token) { it.expiration }

    private fun extractAllClaims(token: String): Claims =
        Jwts.parser()
            .setSigningKey(signInKey)
            .build()
            .parseClaimsJws(token)
            .body

    private val signInKey: Key
        get() {
            val keyBytes = Decoders.BASE64.decode(secret)
            return Keys.hmacShaKeyFor(keyBytes)
        }




}