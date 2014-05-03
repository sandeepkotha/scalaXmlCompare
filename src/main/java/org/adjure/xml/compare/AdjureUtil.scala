/**
 *
 */
package org.adjure.xml.compare

import org.json.XML
import scala.collection.script.Update
import scala.collection.JavaConverters
import scala.io.Source
import scala.reflect.io.File


/**
 * @author kothas
 *
 */
object AdjureUtil
{
	  def convertAsScalaImmutiableMap(map : java.util.Map[_, _]) : Map[_, _] =
	  { 
	    
	    //JavaConverters.mapAsScalaMapConverter(map).asScala;
	    Map() ++ JavaConverters.mapAsScalaMapConverter(map).asScala
	   
	     
	      /*val keyset =  JavaConverters.asScalaSetConverter(map.keySet()).asScala;
	      val test  = List(1,2,3)
	     // keyset.
	      for(key <- keyset)
	      {
	        
	      }
	      Map("one" -> 1, "two" -> 2, "three" -> 3) */
	  }
	  
	  
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
}