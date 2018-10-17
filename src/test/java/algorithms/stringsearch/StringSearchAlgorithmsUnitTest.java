package algorithms.stringsearch;

import org.junit.Assert;
import org.junit.Test;

public class StringSearchAlgorithmsUnitTest {
	
	@Test
	public void testStringSearchAlgorithms(){
		String text = "This is some nice text.";
		String pattern = "some";
		
		int realPosition = text.indexOf(pattern);
        Assert.assertTrue(realPosition == StringSearchAlgorithms.simpleTextSearch(pattern.toCharArray(), text.toCharArray()));
        Assert.assertTrue(realPosition == StringSearchAlgorithms.rabinKarpSearch(pattern.toCharArray(), text.toCharArray()));
        Assert.assertTrue(realPosition == StringSearchAlgorithms.knuthMorrisPrattSearch(pattern.toCharArray(), text.toCharArray()));
        Assert.assertTrue(realPosition == StringSearchAlgorithms.boyerMooreHorspoolSimpleSearch(pattern.toCharArray(), text.toCharArray()));
        Assert.assertTrue(realPosition == StringSearchAlgorithms.boyerMooreHorspoolSearch(pattern.toCharArray(), text.toCharArray()));
	}

}
