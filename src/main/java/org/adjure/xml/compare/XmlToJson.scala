/**
 *
 */
package org.adjure.xml.compare

import scala.io.Source
import org.json.XML
import org.adjure.xml.compare.XmlCompareConstants._
import scala.io.BytePickle
import java.io.File
import org.apache.commons.io.FileUtils
import scala.util.parsing.json.JSON
/**
 * @author kothas
 *
 */
class XmlToJson
{

	def convertXmlToJson(xmlString : String) {
    	             	
	  val xmlJSONObj = XML.toJSONObject(xmlString);
	  val jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
	  val map = xmlJSONObj.getJSONObjectAsMap();
	  
	  println(jsonPrettyPrintString)
	  
	  //val json = JSON.parseFull(jsonPrettyPrintString);
	 // json.
	  
	  
	  quitelyWriteToFile(jsonOutPutFile, jsonPrettyPrintString);
	  //quitelyWriteToFile(xmlOutPutFile, String.valueOf(xmlJSONObj.getJSONObjectAsMap()));
	  
	  //convertJsonToxml(jsonPrettyPrintString);
          
              
          
    }
	
	def quitelyWriteToFile(fileName : String,  content : String)
	{		
        val file = new File(fileName);
        FileUtils.forceDelete(file);
		FileUtils.writeByteArrayToFile(file, content.getBytes());        
	}
  
}

object XmlToJson {

  def main(args: Array[String]): Unit = { println("hello")
	val source = Source.fromFile(inputApXml, "utf-8")
	val xml = source.getLines.mkString("")
	source.close()
	
	val xmltoJson = new XmlToJson();
	xmltoJson.convertXmlToJson(xml);
  
  }

}