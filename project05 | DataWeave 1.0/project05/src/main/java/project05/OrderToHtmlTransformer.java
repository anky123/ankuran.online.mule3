package project05;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
  
public class OrderToHtmlTransformer extends AbstractTransformer
{
    public Object doTransform(Object src, String encoding) throws TransformerException{
		return encoding;
	}
}