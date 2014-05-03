package org.adjure.xml.compare

import org.adjure.xml.compare.AdjureConstants._

object Adjure {

  def main(args: Array[String]): Unit = {
    val xmltoJson = new XmlToJson();
	val input : org.json.JSONObject = xmltoJson.convertXmlToJson(AdjureUtil.quitelyGetFileContentsAsString(inputFile, "utf-8"));
	val refereance : org.json.JSONObject = xmltoJson.convertXmlToJson(AdjureUtil.quitelyGetFileContentsAsString(referanceFile, "utf-8"));
 
	
	AdjureUtil.quitelyWriteToFile(AdjureConstants.jsonOutPutFile, AdjureUtil.convertAsScalaImmutiableMap(input.getJSONObjectAsMap()).toString)
	
  }

}