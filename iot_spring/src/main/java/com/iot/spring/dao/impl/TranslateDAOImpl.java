package com.iot.spring.dao.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.iot.spring.dao.TranslateDAO;

public class TranslateDAOImpl implements TranslateDAO {
	private String contentType;
	private String clientId;
	private String url;
	private String clientSecret;
	private String source;
	private String target;


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public void setTarget(String target) {
		this.target = target;
	}

	
	@Override
	public String getText(String text) throws IOException {
		HttpURLConnection con = null;
		DataOutputStream dos = null;
		BufferedReader br = null;
		try {

			URL url = new URL(this.url);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("X-Naver-Client-Id", this.clientId);
			con.setRequestProperty("X-Naver-Client-Secret", this.clientSecret);
			con.setRequestProperty("Content-Type", this.contentType);

			String postParams = "source=" + this.source + "&target=" + this.target +"&text=" + text;
			con.setDoOutput(true);
			dos = new DataOutputStream(con.getOutputStream());
			dos.writeBytes(postParams);
			dos.flush();
			dos.close();
			int responseCode = con.getResponseCode();
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			return response.toString();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if(br!=null){
				br.close();
			}
			if(dos!=null){
				dos.close();
			}
			if (con != null) {
				con.disconnect();
			}
		}
		return "";
	}

}
