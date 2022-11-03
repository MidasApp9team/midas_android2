package com.example.midasandroid2.bus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.viewbinding.ViewBindings
import androidx.viewbinding.ViewBindings.findChildViewById
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseFragment
import com.example.midasandroid2.databinding.FragmentBusBinding
import com.example.midasandroid2.util.NetworkTh
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class BusFragment : BaseFragment<FragmentBusBinding>(R.layout.fragment_bus) {

    override fun initView() {
        binding.run{
            btnPut.setOnClickListener{
                var th : NetworkTh = NetworkTh(etBusNum.text.toString())
                th.start()
                th.join()

                val dbf: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
                dbf.setNamespaceAware(true)
                val db: DocumentBuilder = dbf.newDocumentBuilder()
                Log.e("Test", NetworkTh.sb.toString())
                val sr = StringReader(NetworkTh.sb.toString())
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


                    if (item.nodeType == Node.ELEMENT_NODE && stNm_Node.nodeType == Node.ELEMENT_NODE && stNm_Node.textContent.equals(etStationNum.text.toString())) {

                        FirstBusTxt.setText("첫번째 빠른 버스 : " + arrmsg1_Node.textContent)
                        SecondBusTxt.setText("두번째 빠른 버스 : " + arrmsg2_Node.textContent)

                    }
                }

            }
        }
    }

    override fun observeEvent() {}

}