/**
 *
 */
package org.adjure.xml.compare

import org.json.XML
import scala.collection.script.Update
import scala.collection.JavaConverters
import scala.io.Source
import scala.reflect.io.File
import org.adjure.ruleset.schema.decisionmaker._0._1.Rule


/**
 * @author kothas
 *
 */
object AdjureUtil
{
	  def convertAsScalaImmutiableMap(map : java.util.Map[_, _]) : Map[_, _] =  Map() ++ JavaConverters.mapAsScalaMapConverter(map).asScala
	 
	  def convertAsScalaImmutiableList(list : java.util.List[Rule]) : List[Rule] = List() ++ JavaConverters.asScalaIterableConverter(list).asScala
	  
	  
	  def isMap(that : Any) = that.isInstanceOf[java.util.Map[_,_]];
	 
	  
	  def quitelyGetFileContentsAsString(fileName : String, encoding : String) : String  =
	  {
	    //val encoding1 = encoding == null || encoding == "" ?    "utf-8" : encoding;	
	    val source = Source.fromFile(fileName, encoding)
		val xml = source.getLines.mkString("")
		source.close()
		xml
	  }
	  
	  def quitelyWriteToFile(fileName : String,  content : String)
	  {		
	        new File(new java.io.File(fileName)).writeAll(content);
	        
	        
	       // FileUtils.forceDelete(file);
			//FileUtils.writeByteArrayToFile(file, content.getBytes());        
	  }
	  
	  def nullToEmptyString(value : String) : String = 
	  {
			  value match {
			    
			    case null => "";
			    case _ => value;
			    
			  }
	  }
}