package com.o2oweb.util;
/**
 * @author 作者姓名 zj
 * 类说明
 */
import java.io.File;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XmlUtil
{
  public static Document stringToDocument(String str)
  {
    Document doc = null;
    try {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      doc = builder.parse(new InputSource(new StringReader(str)));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return doc;
  }

  public static String documentToString(Document doc)
  {
    DOMBuilder builder = new DOMBuilder();
    XMLOutputter xml = new XMLOutputter();
    return xml.outputString(builder.build(doc));
  }

  public static Document fileNameToDocument(String fileName)
  {
    Document doc = null;
    try {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      doc = builder.parse(new File(fileName));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return doc;
  }
}