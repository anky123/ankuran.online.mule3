package project05;

import java.net.MalformedURLException;
import java.net.URL;

import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;

@ContainsTransformerMethods // since Mule 3.0.1
public class MyTransformers {
	@Transformer
	public URL stringToURL(String string) throws MalformedURLException {
		return new java.net.URL(string);
	}
}