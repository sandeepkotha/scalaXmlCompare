/**
 *
 */
package org.adjure.xml.rules

import org.adjure.xml.compare.AdjureUtil
import org.adjure.ruleset.schema.decisionmaker._0._1.Rule
import scala.collection.JavaConverters

/**
 * @author kothas
 *
 */
object RuleProcessor {

  private def readRuleFile() : String = AdjureUtil.quitelyGetFileContentsAsString(getClass().getResource("/rules.xml").getFile(), "UTF-8")
 
  def getRules() = new AdjureJaxbConvertor().quietlyGetRules(readRuleFile())
  
  def getXjPaths(rule : Rule) : Map[String, Map[String,String]] = 
  {
	 val tmpMap : Map[String, String] = Map()
    if(rule.getAffirm().getNode().getSubnode() != null && rule.getAffirm().getNode().getSubnode().size() >0)
	{
		
		  tmpMap ++ processSubNodexfPaths(rule.getAffirm().getNode().getSubnode())
	  
	}
	  Map(rule.getAffirm().getNode().getXjpath() ->tmpMap)
  }
  
  def processSubNodexfPaths(subnodeList : java.util.List[org.adjure.ruleset.schema.system._0._1.SubNode] ) : Map[String, String]=
  {
    val tmpMap : Map[String, String] = Map()
    if(subnodeList != null && subnodeList.size() >0)
    {
	    val subnodes : List[org.adjure.ruleset.schema.system._0._1.SubNode] = List[org.adjure.ruleset.schema.system._0._1.SubNode]() ++
					JavaConverters.asScalaIterableConverter(subnodeList).asScala.map((tmp: org.adjure.ruleset.schema.system._0._1.SubNode) =>tmp)
					
		for(subnode <- subnodes)
		{
			tmpMap ++ Map(subnode.getThisnode() -> processSubNodexfPaths(subnode.getSubnode()))
		}
    }
    
   tmpMap
	

  }
  
  
}