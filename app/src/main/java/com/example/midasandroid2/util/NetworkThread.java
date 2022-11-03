package com.example.midasandroid2.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NetworkThread extends Thread {
    String Id = null;
    public StringBuilder sb;

    public NetworkThread(String Id) {
        this.Id = Id;
    }

    @Override
    public void run() {
        try {

            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll");
            Log.e("MY_TEST", "urlBuilder");
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=nc%2FKLipDxqWPKnjM%2B2xSKf3IQmLkDsGx%2Ba3YYJaGEtXfpDk28K04pmsOKExLi4Ird3Uud%2BKM3mbNPR2vIHRWew%3D%3D");
            urlBuilder.append("&" + URLEncoder.encode("busRouteId", "UTF-8") + "=" + URLEncoder.encode("100100016", "UTF-8"));
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            BufferedReader rd;

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            sb = new StringBuilder();
            String line;

            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            Log.e("BUS_API_TEST", sb.toString());
            rd.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
