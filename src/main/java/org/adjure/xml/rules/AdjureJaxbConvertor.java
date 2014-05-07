/**
 * 
 */
package org.adjure.xml.rules;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.adjure.ruleset.schema.decisionmaker._0._1.Rules;
import org.apache.commons.io.IOUtils;

/**
 * @author kothas
 *
 */
public class AdjureJaxbConvertor {

	public Rules quietlyGetRules(String xml)
	{
		Rules rules = null;
		InputStream is = null;
		
		try
		{
			JAXBContext jc = JAXBContext.newInstance(Rules.class);
			Unmarshaller u = jc.createUnmarshaller();	        
	        is =  IOUtils.toInputStream(xml);
	        rules = (Rules) u.unmarshal(is);
	        
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(is);
		}
        
        
        return rules;
	}
	
	
}
