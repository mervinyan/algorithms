package algorithms.aco;

import org.junit.Assert;
import org.junit.Test;

import algorithm.aco.AntColonyOptimization;

public class AntColonyOptimizationLongRunningUnitTest {

	@Test
	public void testGenerateRandomMatrix() {
		AntColonyOptimization antTSP = new AntColonyOptimization(5);
		Assert.assertNotNull(antTSP.generateRandomMatrix(5));
	}
	
	@Test
	public void testStartAndOptimization() {
		AntColonyOptimization antTSP = new AntColonyOptimization(5);
		Assert.assertNotNull(antTSP.solve());
	}
}
