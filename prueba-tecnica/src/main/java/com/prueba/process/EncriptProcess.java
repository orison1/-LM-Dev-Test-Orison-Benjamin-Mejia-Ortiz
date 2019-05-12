package com.prueba.process;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.prueba.pojo.auntetication.request.AuntRequest;
import com.prueba.utility.JWT;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EncriptProcess {
	
	public String EncryptJWT(AuntRequest loginRequest, String iNetAddress) {
		String sch = null;
		Map<String, Object> mapJWT = new HashMap<String, Object>();
		 
		LocalDateTime now = LocalDateTime.now();
		now = now.plusMinutes(30);
		
		mapJWT.put("idUser", loginRequest.getUser());
		mapJWT.put("ipAddress", iNetAddress);
		mapJWT.put("expiration-datetime", now);
		
		try {
			
			JWT jwt = new JWT(mapJWT,
					"P8IJ9OgAwnB/SR/QYxQWDF5Vod3elP3MEHEbq2fcukc=",
					"token-lifebank",
					"LifeMiles",
					Long.parseLong("1800000") 
					);
			sch = jwt.generate();
			
		} catch (Exception e) {
			log.info("Error en jwt" + e.getMessage());
		}
		
		return sch;
	}
}
