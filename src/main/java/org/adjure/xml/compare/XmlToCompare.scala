/**
 *
 */
package org.adjure.xml.compare

import org.json.XML
import scala.collection.immutable.Map
import scala.collection.script.Update
import scala.collection.JavaConverters;


/**
 * @author kothas
 *
 */
class XmlToCompare(fileName : String)
{
	  def getXmlAsMap() : Unit =
	  { 
	      val xmlJSONObj = XML.toJSONObject("");
		  val jsonPrettyPrintString = xmlJSONObj.toString(XmlCompareConstants.PRETTY_PRINT_INDENT_FACTOR);
		  //JavaConverters.mapAsScalaMapConverter(xmlJSONObj.getJSONObjectAsMap()).asScala.toMap();
	  }
}