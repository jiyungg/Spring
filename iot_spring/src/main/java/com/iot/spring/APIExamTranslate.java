package com.iot.spring;
//네이버 기계번역 API 예제
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.codehaus.jackson.map.ObjectMapper;

import com.iot.spring.vo.TranslateMessage;
public class APIExamTranslate {

 public static void main(String[] args) {
     String clientId = "PPzE6AulijIdSvRmJ1Mg";//애플리케이션 클라이언트 아이디값";
     String clientSecret = "gPB08e6FBr";//애플리케이션 클라이언트 시크릿값";
     try {
         String text = URLEncoder.encode("만나서 반갑습니다.", "UTF-8");
         String apiURL = "https://openapi.naver.com/v1/language/translate";
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("POST");
         con.setRequestProperty("X-Naver-Client-Id", clientId);
         con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
         // post request
         String postParams = "source=ko&target=en&text=" + text;
         con.setDoOutput(true);
         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
         wr.writeBytes(postParams);
         wr.flush();
         wr.close();
         int responseCode = con.getResponseCode();
         BufferedReader br;
         if(responseCode==200) { // 정상 호출
             br = new BufferedReader(new InputStreamReader(con.getInputStream()));
         } else {  // 에러 발생
             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
         }
         String inputLine;
         StringBuffer response = new StringBuffer();
         while ((inputLine = br.readLine()) != null) {
             response.append(inputLine);
         }
         br.close();
         System.out.println(response.toString());
     } catch (Exception e) {
         System.out.println(e);
     }
 }
}