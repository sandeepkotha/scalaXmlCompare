/**
 *
 */
package org.adjure.xml.rules

import org.adjure.xml.compare.AdjureUtil
import org.adjure.ruleset.schema.decisionmaker._0._1.Rules

/**
 * @author kothas
 *
 */
object RuleProcessor {

  private def readRuleFile() : String = AdjureUtil.quitelyGetFileContentsAsString(getClass().getResource("/rules.xml").getFile(), "UTF-8")
 
  def getRules() = new AdjureJaxbConvertor().quietlyGetRules(readRuleFile())
  
  
}