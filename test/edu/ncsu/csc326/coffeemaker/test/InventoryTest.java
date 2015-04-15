package edu.ncsu.csc326.coffeemaker.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class InventoryTest {
	
	private Inventory inventory;
	private Recipe recipe1;
	
	
	@Before
	public void setUp(){
		inventory = new Inventory();
		inventory.setChocolate(3);
		inventory.setCoffee(3);
		inventory.setMilk(3);
		inventory.setSugar(3);
		recipe1 = new Recipe();
		recipe1.setName("recipe1");
		try {
			recipe1.setPrice("1");
			recipe1.setAmtChocolate("3");
		    recipe1.setAmtCoffee("3");
		    recipe1.setAmtMilk("3");
		    recipe1.setAmtSugar("3");
		} catch (RecipeException e) {
			System.out.println(e.getMessage());
		}  
	}
	
	@Test
	public void ingredientsShouldBeRemoved(){
		Assert.assertTrue(inventory.useIngredients(recipe1));
		Assert.assertEquals(0, inventory.getChocolate());
		Assert.assertEquals(0, inventory.getCoffee());
		Assert.assertEquals(0, inventory.getMilk());
		Assert.assertEquals(0, inventory.getSugar());
	}
	
	@Test
	public void chocolateShouldBeNotRemoved() throws RecipeException{
		recipe1.setAmtChocolate("4");
	    Assert.assertFalse(inventory.useIngredients(recipe1));
		Assert.assertEquals(3, inventory.getChocolate());
	}
	
	@Test
	public void coffeeShouldBeNotRemoved() throws RecipeException{
		recipe1.setAmtCoffee("4");
	    Assert.assertFalse(inventory.useIngredients(recipe1));
		Assert.assertEquals(3, inventory.getChocolate());
	}
	
	@Test
	public void milkShouldBeNotRemoved() throws RecipeException{
		recipe1.setAmtMilk("4");
	    Assert.assertFalse(inventory.useIngredients(recipe1));
		Assert.assertEquals(3, inventory.getChocolate());
	}
	
	@Test
	public void sugarShouldBeNotRemoved() throws RecipeException{
		recipe1.setAmtSugar("4");
	    Assert.assertFalse(inventory.useIngredients(recipe1));
		Assert.assertEquals(3, inventory.getChocolate());
	}

}
