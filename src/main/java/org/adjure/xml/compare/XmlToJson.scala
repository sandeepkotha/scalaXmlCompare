 /**
 *
 */
package org.adjure.xml.compare

import scala.io.Source
import org.json.XML
import org.adjure.xml.compare.AdjureConstants._
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

	def convertXmlToJson(xmlString : String) : org.json.JSONObject = {
    	             	
	  XML.toJSONObject(xmlString);
          
    }
	
	
  
}

object XmlToJson {

  def main(args: Array[String]): Unit = { println("hello")
	
	val xmltoJson = new XmlToJson();
	val input : org.json.JSONObject = xmltoJson.convertXmlToJson(AdjureUtil.quitelyGetFileContentsAsString(inputFile, "utf-8"));
	val refereance : org.json.JSONObject = xmltoJson.convertXmlToJson(AdjureUtil.quitelyGetFileContentsAsString(referanceFile, "utf-8"));
  
  }
  
  

}