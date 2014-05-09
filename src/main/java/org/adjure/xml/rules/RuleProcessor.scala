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
	if(rule.getAffirm().getNode().getSubnode() != null && rule.getAffirm().getNode().getSubnode().size() >0)
	{
		val subnodes : List[org.adjure.ruleset.schema.system._0._1.SubNode] = List[org.adjure.ruleset.schema.system._0._1.SubNode]() ++
				JavaConverters.asScalaIterableConverter(rule.getAffirm().getNode().getSubnode()).asScala.map((tmp: org.adjure.ruleset.schema.system._0._1.SubNode) =>tmp)
		for(subnode <- subnodes)
		{
		  
		}
	
	  
	}
	  Map(rule.getAffirm().getNode().getXjpath() ->Map())
  }
  
  def processSubNodexfPaths(subnodeList : java.util.List[org.adjure.ruleset.schema.system._0._1.SubNode] )=
  {
    if(subnodeList != null && subnodeList.size() >0)
    {
	    val subnodes : List[org.adjure.ruleset.schema.system._0._1.SubNode] = List[org.adjure.ruleset.schema.system._0._1.SubNode]() ++
					JavaConverters.asScalaIterableConverter(subnodeList).asScala.map((tmp: org.adjure.ruleset.schema.system._0._1.SubNode) =>tmp)
					
		for(subnode <- subnodes)
		{
			//subnode.getThisnode().ge
		}
    }
	

  }
  
  
}