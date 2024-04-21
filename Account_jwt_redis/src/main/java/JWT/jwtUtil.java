package JWT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import JWT.jwtUtil;

public class jwtUtil {
	 private static Logger logger = LoggerFactory.getLogger(jwtUtil.class);
	    private static final String USER = "tien";
	    private static final String SECRET = "hey Mr Tien the secrect length must be at least 256 bits" +
	                                             " please no reveal!";

	    private static final String SECRET_KEY = "your-secret-key"; // Replace with your actual secret key

	    public static String createJWT(String userId, String issuer, String subject, long ttlMillis) throws ParseException, JOSEException {
	        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
	            .subject(subject)
	            .issuer(issuer)
	            .claim("userId", userId) // Custom claim
	            .expirationTime(new Date(System.currentTimeMillis() + ttlMillis))
	            .build();
	        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet); // Replace null with your signing algorithm
	        
	        JWSSigner signer = new MACSigner("61 66 35 39 35 62 66 30 36 31 66 63 37 30 64 62");

	     // Now you can call supportedJWSAlgorithms()
	     System.out.println("Supported algorithms: " + signer.supportedJWSAlgorithms());
	        
	        signedJWT.sign(signer); // Replace null with your signing key

	        return signedJWT.serialize();
	    }
	    

	

}
