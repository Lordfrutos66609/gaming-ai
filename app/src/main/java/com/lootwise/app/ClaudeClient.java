package com.lootwise.app;

import org.json.*;
import java.io.*;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.nio.charset.StandardCharsets;

final class ClaudeClient {
 private volatile HttpsURLConnection active;
 void cancel() { HttpsURLConnection c=active; if(c!=null)c.disconnect(); }
 JSONObject request(String path, String key, String workspace, JSONObject body) throws Exception {
  HttpsURLConnection c=(HttpsURLConnection)new URL("https://api.anthropic.com/v1/"+path).openConnection(); active=c;
  try {
   c.setInstanceFollowRedirects(false); c.setConnectTimeout(15000); c.setReadTimeout(90000);
   c.setRequestProperty("x-api-key",key); c.setRequestProperty("anthropic-version","2023-06-01");
   if(!workspace.isEmpty())c.setRequestProperty("anthropic-workspace-id",workspace);
   if(body!=null){ c.setRequestMethod("POST"); c.setDoOutput(true); c.setRequestProperty("Content-Type","application/json");
    try(OutputStream out=c.getOutputStream()){out.write(body.toString().getBytes(StandardCharsets.UTF_8));} }
   int status=c.getResponseCode();
   if(status<200||status>=300) {
    String message=switch(status){case 401,403 -> "API access denied. Check your key and workspace in Settings."; case 429 -> "Provider limit reached. Check credits or wait before retrying."; case 400 -> "The provider rejected this request. Check the model and image, then try again."; default -> "Provider returned HTTP "+status+". Please try later.";};
    throw new IOException(message);
   }
   try(InputStream in=c.getInputStream(); ByteArrayOutputStream bytes=new ByteArrayOutputStream()) {
    byte[] b=new byte[8192]; int n; while((n=in.read(b))!=-1){bytes.write(b,0,n); if(bytes.size()>4000000)throw new IOException("Provider response too large.");}
    return new JSONObject(bytes.toString("UTF-8"));
   }
  } finally { c.disconnect(); if(active==c)active=null; }
 }
}
