/**
 *
 */
package org.adjure.xml.rules

import org.adjure.xml.compare.AdjureUtil

/**
 * @author kothas
 *
 */
object RuleProcessor {

  def readRuleFile() : String =
  {
	  AdjureUtil.quitelyGetFileContentsAsString(getClass().getResource("/rules.xml").getFile(), "UTF-8")

  }
  
  
}