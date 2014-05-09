package org.adjure.xml.compare

import org.adjure.xml.compare.AdjureConstants._
import org.adjure.xml.rules.RuleProcessor
import org.adjure.ruleset.schema.commons._0._1.Action
import org.adjure.ruleset.schema.decisionmaker._0._1.Rule
import scala.AnyVal
import org.json.JSONObject
import scala.collection.immutable.List
import scala.collection.JavaConversions

object Adjure {

  private val input : org.json.JSONObject = XmlToJson.convertXmlToJson(AdjureUtil.quitelyGetFileContentsAsString(inputFile, "utf-8"));
  private val refereance : org.json.JSONObject = XmlToJson.convertXmlToJson(AdjureUtil.quitelyGetFileContentsAsString(referanceFile, "utf-8"));
  
  def main(args: Array[String]): Unit = {
   
    checkWithRules();
	
	/*
	AdjureUtil.quitelyWriteToFile(AdjureConstants.jsonOutPutFile, AdjureUtil.convertAsScalaImmutiableMap(input.getJSONObjectAsMap()).toString)
	*/
	/*val rules = RuleProcessor.getRules;
	
	println(rules.getRuleSet().getInputType())
	
	println(rules.getRuleSet().getRule().get(0).getRuleName()) */
 
  }
  
  private def checkWithRules() : Unit =
  {
		  val rules = RuleProcessor.getRules;
		  if(rules.getRuleSet().getAction().equals(Action.COMPARE_WITH_EACH_OTHER))
		  {
			  AdjureUtil.convertAsScalaImmutiableList(rules.getRuleSet().getRule()).foreach((rule : Rule) => analyseRule(input,refereance, rule))
		  }
  }
 
  
  private def analyseRule(toCompare : org.json.JSONObject, compareWithThis : org.json.JSONObject, rule : Rule) : Unit =
  {
    val tmpInput : List[org.json.JSONObject] = processObjects(getJsonObject(toCompare, rule.getAffirm().getNode().getXjpath()), rule)
    val tmpReferance : List[org.json.JSONObject] =  processObjects(getJsonObject(compareWithThis, rule.getAffirm().getNode().getXjpath()), rule)
    
    compare(tmpInput, tmpReferance)
   
    
   
	
    
    Map()
  }
  
  /**
   * get JSON Object for root node for the xjPath. It will return either org.json.JSONObject or org.json.JSONArray
   * @author kothas 
   */
  private def getJsonObject(jsonObject : Any, xjPath :String) : Any = xjPath.split("\\.").foldLeft(jsonObject){(tmp :Any  , key : String ) =>  jsonObjectMatch(tmp, key)};
    
  /**
   * Generate a list of org.json.JSONObject
   */
  private def processObjects(data : Any, rule : Rule): List[org.json.JSONObject] =
  {
	data match {
	    case i if i.isInstanceOf[org.json.JSONObject]  => (List[org.json.JSONObject]()):+ data.asInstanceOf[org.json.JSONObject]
	    case i if i.isInstanceOf[org.json.JSONArray] => convertJSONArrayToJSONObjects((data.asInstanceOf[org.json.JSONArray]))
	}	
	
  }
  
  private def processJSONObjects(jsonObjects : List[org.json.JSONObject], rule : Rule) : Map[String, String] =
  {
	
    //rule.getAffirm().getNode().getKey();
    rule.getAffirm().getNode().getSubnode()
    
    /*val seprator = AdjureUtil.nullToEmptyString(rule.getAffirm().getNode().getKey().getSeprator());
	val size: Int = rule.getAffirm().getNode().getKey().getElementInxjpath().size();
	
	 
	val elementsForKey : List[String] = JavaConversions.asScalaIterator(rule.getAffirm().getNode().getKey().getElementInxjpath().iterator()).foldLeft(List[String]()){(list : List[String], value : String) => list :+  value}
	*/ 
	 
    for( jsonObject <- jsonObjects)
	{
	
	  
      val rootKey : String = keyMaker(JavaConversions.asScalaIterator(rule.getAffirm().getNode().getKey().getElementInxjpath().iterator()).
	      foldLeft(List[String]()){(list : List[String], value : String) => list :+  value}, 
	      AdjureUtil.nullToEmptyString(rule.getAffirm().getNode().getKey().getSeprator()), jsonObject);
      
      val toCompareMap : Map[String, Map[Set[String], org.json.JSONObject]] = Map()
      
	  
	  jsonObjectToMap(rootKey, jsonObject)
	}
    
    Map("" -> "")
  }
  
  private def constructTocompareMap() : Map[String, Map[Set[String], org.json.JSONObject]] = 
  {
    
    
    Map()
  }
  
  private def jsonObjectToMap(key : String, jsonObject : org.json.JSONObject) : Map[String, String] =
  {
		    
    
    Map("" -> "")
  }
  
  /**
   * To make a Key for a JSONObject
   */
  private def keyMaker(elementsForKey : List[String], seprator: String, jsonObject : org.json.JSONObject) : String = elementsForKey.foldLeft(""){(key : String, element : String) => jsonObject.getString(key)+seprator}
  
  private def compare(inputJSONObjects : List[org.json.JSONObject], referanceJSONObjects : List[org.json.JSONObject]) : Unit=
  {
		  
  }
  
  /**
   * To convert org.json.JSONArray to a list of org.json.JSONObject
   */
 private def convertJSONArrayToJSONObjects(jsonArray : org.json.JSONArray) : List[org.json.JSONObject] =
 {
   val list : List[org.json.JSONObject] = List[org.json.JSONObject]()
   for( i <- 0 to jsonArray.length())  
     
     list:+ jsonArray.get(i);
  list
   
 }
  
 /**
  * To pull org.json.JSONObject in org.json.JSONObject if any is an instance of org.json.JSONObject
  * @author kothas 
  */
  private def jsonObjectMatch(any : Any, key : String) : Any =
  {
	  any match
	  {
	    case i if i.isInstanceOf[org.json.JSONObject]  => any.asInstanceOf[org.json.JSONObject].get(key)
	    case _ => any
	  }
  }

} 