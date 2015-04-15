package edu.ncsu.csc326.coffeemaker.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.CoffeeMaker;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest {
	
	private CoffeeMaker cm;
	private Recipe r1;

	@Before
	public void setUp() throws Exception{
		cm = new CoffeeMaker();
		
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
	}
	
	@Test	
	public void moneyShoudBeEnaughtToBuyBeverage() {
		cm.addRecipe(r1);
		int change = cm.makeCoffee(0, 75);
		Assert.assertEquals(25, change);
	}
	
	@Test	
	public void moneyShoudBeNotEnaughtToBuyBeverage() {
		cm.addRecipe(r1);
		int change = cm.makeCoffee(0, 20);
		Assert.assertEquals(20, change);
	}

}
