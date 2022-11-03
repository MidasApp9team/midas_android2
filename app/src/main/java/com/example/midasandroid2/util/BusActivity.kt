package com.example.midasandroid2.util

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.midasandroid2.R
import com.example.midasandroid2.util.NetworkTh.Companion.sb
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory


class BusActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus)

        var btn : Button = findViewById(R.id.btn1)
        var et1 : EditText = findViewById(R.id.editText)
        var et2 : EditText = findViewById(R.id.editText2)

        btn.setOnClickListener{
            var th : NetworkTh = NetworkTh(et2.text.toString())
            th.start()
            th.join()

            val dbf: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            dbf.setNamespaceAware(true)
            val db: DocumentBuilder = dbf.newDocumentBuilder()
            Log.e("Test", sb.toString())
            val sr = StringReader(sb.toString())
            val Is = InputSource(sr)
            val doc: Document = db.parse(Is)

            doc.getDocumentElement().normalize();
            val stNm = doc.getElementsByTagName("stNm")
            doc.getDocumentElement().normalize();
            val arrmsg1 = doc.getElementsByTagName("arrmsg1")
            doc.getDocumentElement().normalize();
            val arrmsg2 = doc.getElementsByTagName("arrmsg2")
            doc.getDocumentElement().normalize();
            val rtNm  = doc.getElementsByTagName("rtNm")

            val root: Element = doc.getDocumentElement()
            val firstNode: Node = root.getFirstChild()
            val customer: Node = firstNode.getNextSibling().getNextSibling()
            val childList: NodeList = customer.getChildNodes()

            for (i in 0 until childList.length) {
                val item = childList.item(i)
                val stNm_Node = stNm.item(i)
                val arrmsg1_Node = arrmsg1.item(i)
                val arrmsg2_Node = arrmsg2.item(i)
                val rtNm_Node = rtNm.item(i)


                if (item.nodeType == Node.ELEMENT_NODE && stNm_Node.nodeType == Node.ELEMENT_NODE && stNm_Node.textContent.equals("정릉북한산국립공원입구")) {
                    println(arrmsg1_Node.textContent)
                    println(arrmsg2_Node.textContent)
                    println(rtNm_Node.textContent)
                }
            }
        }

    }


}