package com.example.midasandroid2.util

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class NetworkTh(B_no1: String?) : Thread() {

    val B_no = B_no1

    companion object{
        var Id: String? = null
        var sb: StringBuilder? = null
    }

    override fun run() {
        try {
            Id = B_no
            Log.d("TAG", "id: $Id")
            Log.d("TAG", "bno: $B_no")
            val urlBuilder =
                StringBuilder("http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll")
            Log.e("MY_TEST", "urlBuilder")

            urlBuilder.append(
                "?" + URLEncoder.encode(
                    "ServiceKey",
                    "UTF-8"
                ) + "=nc%2FKLipDxqWPKnjM%2B2xSKf3IQmLkDsGx%2Ba3YYJaGEtXfpDk28K04pmsOKExLi4Ird3Uud%2BKM3mbNPR2vIHRWew%3D%3D"
            )
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "busRouteId",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(Id, "UTF-8")
            )
            val url = URL(urlBuilder.toString())
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.setRequestProperty("Content-type", "application/json")
            val rd: BufferedReader
            rd = if (conn.responseCode >= 200 && conn.responseCode <= 300) {
                BufferedReader(InputStreamReader(conn.inputStream))
            } else {
                BufferedReader(InputStreamReader(conn.errorStream))
            }

            sb = StringBuilder()
            var line: String?
            while (rd.readLine().also { line = it } != null) {
                sb!!.append(line)
            }

            Log.e("BUS_API_TEST", Id.toString())
            Log.e("BUS_API_TEST", sb.toString())

            rd.close()
            conn.disconnect()
        } catch (e: Exception) {
            Log.e("Error", e.toString())
        }
    }
}