package com.prueba.process;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class getShaProcess {
	
	public String getSha512(String pass, String user) {
			
			String passCifrado = null;  
			
			try {
				String base64Encodepass =Base64.getEncoder().encodeToString(pass.getBytes());
				String base64EncodeUser =Base64.getEncoder().encodeToString(user.getBytes());
				String passhast = base64Encodepass + base64Encodepass;
				
				MessageDigest md = MessageDigest.getInstance("SHA-512");
		        md.update(passhast.getBytes(StandardCharsets.UTF_8));
		        byte[] bytes = md.digest(passhast.getBytes(StandardCharsets.UTF_8));
		         StringBuilder sb = new StringBuilder();	
		         for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		         }
		         passCifrado = sb.toString();
		        
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return passCifrado;
		}

}
