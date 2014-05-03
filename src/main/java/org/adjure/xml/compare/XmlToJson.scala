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

