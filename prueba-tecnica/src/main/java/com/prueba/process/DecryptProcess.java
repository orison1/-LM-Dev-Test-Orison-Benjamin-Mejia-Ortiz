package com.prueba.process;

import java.util.ArrayList;

import com.prueba.utility.JWT;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecryptProcess {

	public ArrayList<String> Decrypt(String sch){
		
		log.info("Descifrando sch DecryptProcess");
		ArrayList<String> jwtDecript = new ArrayList<String>(); 
		
			JWT jwt = new JWT("P8IJ9OgAwnB/SR/QYxQWDF5Vod3elP3MEHEbq2fcukc=");
			Claims claims = jwt.extract(sch);
			
			jwtDecript.add(claims.get("idUser").toString());
			jwtDecript.add(claims.get("expiration-datetime").toString());
			jwtDecript.add(claims.get("ipAddress").toString());
				
		return jwtDecript;
	}
}
