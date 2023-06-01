package com.paytm.pgplus.upipsphandler.model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.JsonNode;
import com.paytm.pgplus.common.signature.wrapper.SignatureUtilWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class JWTWithHmacSHA256 implements Serializable {
    private static final long serialVersionUID = -6879261423661077965L;
    private static final Logger LOGGER = LoggerFactory.getLogger(com.paytm.pgplus.common.signature.JWTWithHmacSHA256.class);
    private static final String jwtTokenPrefix = "Bearer ";

    public JWTWithHmacSHA256() {
    }

    public static boolean verifyJsonWebToken(Map<String, String> jwtClaims, String jwtToken) {
        return verifyJsonWebToken(jwtClaims, jwtToken, SignatureUtilWrapper.getJwtKey());
    }

    public static boolean verifyJsonWebToken(String jwtToken) {
        return verifyJsonWebToken(Collections.emptyMap(), jwtToken, SignatureUtilWrapper.getJwtKey(), "ts", true);
    }

    public static boolean verifyJsonWebToken(Map<String, String> jwtClaims, String jwtToken, String key) {
        return verifyJsonWebToken(jwtClaims, jwtToken, key, "ts");
    }

    public static boolean verifyJsonWebToken(Map<String, String> jwtClaims, String jwtToken, String key, String issuer) {
        return verifyJsonWebToken(jwtClaims, jwtToken, key, issuer, false);
    }

    public static boolean verifyJsonWebToken(Map<String, String> jwtClaims, String jwtToken, String key, String issuer, boolean isEmptyJwtClaimsAllowed) {
        JWTVerifier verifier = null;

        try {
            verifier = JWT.require(Algorithm.HMAC256(key)).withIssuer(issuer).build();
            DecodedJWT jwt = verifier.verify(jwtToken);
            if (!isEmptyJwtClaimsAllowed && isClaimSizeNotValid(jwtClaims, jwt)) {
                LOGGER.info("ClaimSet size not matching");
                return false;
            } else {
                Iterator var7 = jwtClaims.entrySet().iterator();

                Map.Entry entry;
                Claim claimValue;
                do {
                    if (!var7.hasNext()) {
                        return true;
                    }

                    entry = (Map.Entry)var7.next();
                    claimValue = jwt.getClaim((String)entry.getKey());
                } while(null != claimValue && ((String)entry.getValue()).equals(claimValue.asString()));

                LOGGER.info("validation failed for claim : key {} , orig_value {}, decoded_value {}", new Object[]{entry.getKey(), entry.getValue(), claimValue.asString()});
                return false;
            }
        } catch (UnsupportedEncodingException | SignatureVerificationException | JWTDecodeException | IllegalArgumentException var10) {
            LOGGER.error("Exception occured while verifying JWT : {} ", var10);
            return false;
        }
    }

    private static boolean isClaimSizeNotValid(Map<String, String> jwtClaims, DecodedJWT jwt) {
        return jwtClaims.isEmpty() || jwt.getClaims().isEmpty() && jwtClaims.size() != jwt.getClaims().size();
    }

    public static String createJsonWebToken(Map<String, String> jwtClaims) {
        LOGGER.info("Creating JWT with claims : {}", jwtClaims);
        JWTCreator.Builder builder = JWT.create().withIssuer("ts");
        String jwtToken = null;
        Iterator var3 = jwtClaims.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var3.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            jwtToken = builder.sign(Algorithm.HMAC256(SignatureUtilWrapper.getJwtKey()));
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var5) {
            LOGGER.error("Exception occured while generating JWT Token {} :", var5);
        }

        return jwtToken;
    }

    public static String createUpiVpaJsonWebToken(Map<String, String> jwtClaims, String key, String issuer) {
        JWTCreator.Builder builder = JWT.create().withIssuer(issuer).withIssuedAt(new Date());
        String jwtToken = null;
        Iterator var5 = jwtClaims.entrySet().iterator();

        while(var5.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var5.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            jwtToken = builder.sign(Algorithm.HMAC256(key));
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var7) {
            LOGGER.error("Exception occured while generating JWT Token {} :", var7);
        }

        return jwtToken;
    }

    public static String createJsonWebToken(Map<String, String> jwtClaims, String iss, String clientSecret) {
        LOGGER.info("Creating JWT with claims : {}", jwtClaims);
        JWTCreator.Builder builder = JWT.create().withIssuer(iss).withIssuedAt(new Date());
        Iterator var4 = jwtClaims.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var4.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            return builder.sign(Algorithm.HMAC256(clientSecret));
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var6) {
            LOGGER.error("Exception occured while generating JWT Token {} :", var6);
            return null;
        }
    }

    public static String createJsonWebToken(Map<String, String> jwtClaims, String iss) {
        LOGGER.info("Creating JWT with claims : {}", jwtClaims);
        JWTCreator.Builder builder = JWT.create().withIssuer(iss).withIssuedAt(new Date());
        String jwtToken = null;
        Iterator var4 = jwtClaims.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var4.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            jwtToken = builder.sign(Algorithm.HMAC256(SignatureUtilWrapper.getUpiJwtKey()));
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var6) {
            LOGGER.error("Exception occured while generating JWT Token {} :", var6);
            return null;
        }

        return "Bearer " + jwtToken;
    }

    public static String createPostPaidJsonWebToken(Map<String, String> jwtClaims, String issuer, String clientSecret) {
        LOGGER.debug("Creating JWT for postpaid");
        JWTCreator.Builder builder = JWT.create().withIssuer(issuer);
        String jwtToken = null;
        Iterator var5 = jwtClaims.entrySet().iterator();

        while(var5.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var5.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            jwtToken = builder.sign(Algorithm.HMAC256(clientSecret));
            return jwtToken;
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var7) {
            throw new JWTCreationException("Exception occurred while generating postpaid JWT Token", var7);
        }
    }

    public static String createJsonWebToken(Map<String, String> jwtClaims, String clientSecret, long expirySeconds) {
        LOGGER.debug("Creating JWT jwtClaims {}, expirySeconds{}", jwtClaims, expirySeconds);
        JWTCreator.Builder builder = JWT.create().withExpiresAt(new Date(System.currentTimeMillis() + expirySeconds * 1000L));
        String jwtToken = null;
        Iterator var6 = jwtClaims.entrySet().iterator();

        while(var6.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var6.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            jwtToken = builder.sign(Algorithm.HMAC256(clientSecret));
            return jwtToken;
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var8) {
            throw new JWTCreationException("Exception occurred while generating postpaid JWT Token", var8);
        }
    }

    public static String createJsonWebTokenUpi(Map<String, String> jwtClaims, String clientSecret, long expirySeconds, Date issuedAt) {
        LOGGER.debug("Creating JWT jwtClaims {}, expirySeconds{}", jwtClaims, expirySeconds);
        JWTCreator.Builder builder;
        if (issuedAt != null) {
            builder = JWT.create().withIssuedAt(issuedAt);
        } else {
            builder = JWT.create().withExpiresAt(new Date(System.currentTimeMillis() + expirySeconds * 1000L));
        }

        String jwtToken = null;
        Iterator var7 = jwtClaims.entrySet().iterator();

        while(var7.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var7.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            jwtToken = builder.sign(Algorithm.HMAC256(clientSecret));
            return jwtToken;
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var9) {
            throw new JWTCreationException("Exception occurred while generatingUPI JWT Token", var9);
        }
    }

    public static boolean verifyJsonWebTokenMGV(String jwtToken) {
        return verifyJsonWebToken(Collections.emptyMap(), jwtToken, SignatureUtilWrapper.getMGVJwtKey(), "ts", true);
    }

    public static String createJwtTokenForEmiSubvention(String jwtKey) {
        byte[] key = Base64.getDecoder().decode(jwtKey);
        JWTCreator.Builder builder = JWT.create().withExpiresAt(new Date());

        try {
            String jwtToken = builder.sign(Algorithm.HMAC256(key));
            return jwtToken;
        } catch (JWTCreationException | IllegalArgumentException var5) {
            throw new JWTCreationException("Exception occurred while generating emi subvention JWT Token", var5);
        }
    }

    public static String createJsonWebToken(String key, Map<String, String> jwtClaims) {
        LOGGER.info("Creating JWT with claims : {}", jwtClaims);
        JWTCreator.Builder builder = JWT.create();
        String jwtToken = null;
        Iterator var4 = jwtClaims.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var4.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            jwtToken = builder.sign(Algorithm.HMAC256(key));
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var6) {
            LOGGER.error("Exception occured while generating JWT Token {} :", var6);
        }

        return jwtToken;
    }

    public static String createJsonWebTokenForIssuer(Map<String, String> jwtClaims, String issuer, String key) {
        LOGGER.debug("Creating JWT for : {}", issuer);
        JWTCreator.Builder builder = JWT.create().withIssuer(issuer);
        String jwtToken = null;
        Iterator var5 = jwtClaims.entrySet().iterator();

        while(var5.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var5.next();
            builder.withClaim((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            jwtToken = builder.sign(Algorithm.HMAC256(key));
            return jwtToken;
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException var7) {
            throw new JWTCreationException("Exception occurred while generating postpaid JWT Token", var7);
        }
    }

    public static String createJwtWithIssuerAndIat(Map<String, String> jwtClaims, String issuer, String secretkey, String iAtKey) {
        LOGGER.debug("Creating jwt token ");

        try {
            if (StringUtils.isEmpty(secretkey)) {
                LOGGER.error("Secret key not present");
                return null;
            } else if (StringUtils.isNotEmpty(issuer)) {
                JWTCreator.Builder builder = JWT.create().withIssuer(issuer);
                jwtClaims.entrySet().forEach((claim) -> {
                    builder.withClaim((String)claim.getKey(), (String)claim.getValue());
                });
                builder.withClaim(iAtKey, System.currentTimeMillis());
                return builder.sign(Algorithm.HMAC256(secretkey));
            } else {
                LOGGER.error("Issuer not present");
                return null;
            }
        } catch (Exception var5) {
            throw new JWTCreationException("Exception occurred while generating JWT Token", var5);
        }
    }

    public static String createJwtWithIssuer(Map<String, String> jwtClaims, String issuer, String secretkey) {
        LOGGER.debug("Creating JWT for : {}", issuer);

        try {
            if (StringUtils.isEmpty(secretkey)) {
                LOGGER.error("Secret key not present");
                return null;
            } else if (StringUtils.isNotEmpty(issuer)) {
                JWTCreator.Builder builder = JWT.create().withIssuer(issuer);
                jwtClaims.entrySet().forEach((claim) -> {
                    builder.withClaim((String)claim.getKey(), (String)claim.getValue());
                });
                return builder.sign(Algorithm.HMAC256(secretkey));
            } else {
                LOGGER.error("Issuer not present");
                return null;
            }
        } catch (Exception var4) {
            throw new JWTCreationException("Exception occurred while generating JWT Token", var4);
        }
    }

    private static boolean isClaimSizeValid(Map<String, JsonNode> jwtClaims, DecodedJWT jwt) {
        return jwtClaims.isEmpty() || jwt.getClaims().isEmpty() && jwtClaims.size() != jwt.getClaims().size();
    }

    public static boolean verifyJwt(Map<String, JsonNode> jwtClaims, String jwtToken, String key, String issuer, boolean isEmptyJwtClaimsAllowed) {
        JWTVerifier verifier = null;

        try {
            verifier = JWT.require(Algorithm.HMAC256(key)).withIssuer(issuer).build();
            DecodedJWT jwt = verifier.verify(jwtToken);
            if (!isEmptyJwtClaimsAllowed && isClaimSizeValid(jwtClaims, jwt)) {
                LOGGER.info("ClaimSet size not matching");
                return false;
            } else {
                Iterator var7 = jwtClaims.entrySet().iterator();

                Map.Entry entry;
                Claim claimValue;
                do {
                    if (!var7.hasNext()) {
                        return true;
                    }

                    entry = (Map.Entry)var7.next();
                    claimValue = jwt.getClaim((String)entry.getKey());
                } while(null != claimValue && ((JsonNode)entry.getValue()).equals(claimValue.as(JsonNode.class)));

                LOGGER.info("validation failed for claim : key {} , orig_value {}, decoded_value {}", new Object[]{entry.getKey(), entry.getValue(), claimValue.asString()});
                return false;
            }
        } catch (UnsupportedEncodingException | SignatureVerificationException | JWTDecodeException | IllegalArgumentException var10) {
            LOGGER.error("Exception occured while verifying JWT : {} ", var10);
            return false;
        }
    }
}

