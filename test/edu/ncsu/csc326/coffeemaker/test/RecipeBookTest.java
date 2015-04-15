package edu.ncsu.csc326.coffeemaker.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.RecipeBook;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeBookTest {
	
	private RecipeBook recipeBook;
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	
	@Before
	public void setUp(){
		recipeBook = new RecipeBook();
		recipe1 = new Recipe();
		recipe1.setName("recipe1");
		try {
			recipe1.setPrice("1");
			recipe1.setAmtChocolate("1");
		    recipe1.setAmtCoffee("2");
		    recipe1.setAmtMilk("3");
		    recipe1.setAmtSugar("2");
		    
		    recipe2 = new Recipe();
		    recipe2.setName("recipe2");
		    recipe2.setPrice("2");
			recipe2.setAmtChocolate("5");
		    recipe2.setAmtCoffee("1");
		    recipe2.setAmtMilk("2");
		    recipe2.setAmtSugar("2");
		    
		    recipe3 = new Recipe();
		    recipe3.setName("recipe3");
		    recipe3.setPrice("3");
			recipe3.setAmtChocolate("5");
		    recipe3.setAmtCoffee("1");
		    recipe3.setAmtMilk("2");
		    recipe3.setAmtSugar("0");
		    
		    recipe4 = new Recipe();
		    recipe4.setName("recipe4");
		    recipe4.setPrice("4");
			recipe4.setAmtChocolate("2");
		    recipe4.setAmtCoffee("1");
		    recipe4.setAmtMilk("1");
		    recipe4.setAmtSugar("0");
		    
		} catch (RecipeException e) {
			System.out.println(e.getMessage());
		}  
	}
	
	@Test
	public void recipeShouldBeAddedToRecipeBook(){
		recipeBook.addRecipe(recipe1);
		recipeBook.addRecipe(recipe2);
		Assert.assertNull(recipeBook.getRecipes()[2]);		
	}
	
	@Test
	public void recipeBookShouldContainMax3Recipes(){
		recipeBook.addRecipe(recipe1);
		recipeBook.addRecipe(recipe2);
		recipeBook.addRecipe(recipe3);
		recipeBook.addRecipe(recipe4);
		Assert.assertEquals(recipe3, recipeBook.getRecipes()[2]);	
	}
	
	@Test
	public void recipeBookShouldNotContainDuplicateRecipes(){
		recipeBook.addRecipe(recipe1);
		recipeBook.addRecipe(recipe2);
		recipeBook.addRecipe(recipe2);
		Assert.assertNull(recipeBook.getRecipes()[2]);		
	}
	
	@Test
	public void recipeShouldBeRemoved(){
		recipeBook.addRecipe(recipe1);
		recipeBook.deleteRecipe(0);
		Assert.assertNull(recipeBook.getRecipes()[0]);		
	}
	
	@Test
	public void recipeShouldNotBeRemoved(){
		String act = recipeBook.deleteRecipe(0);
		Assert.assertNull(act);		
	}
	
	@Test
	public void recipeShouldBeModified(){
		recipeBook.addRecipe(recipe1);
		recipeBook.editRecipe(0, recipe2);
		Assert.assertEquals(recipe2, recipeBook.getRecipes()[0]);		
	}
	
	@Test
	public void recipeShouldBeNotModified(){
		String act = recipeBook.editRecipe(0, recipe2);
		Assert.assertNull(act);		
	}

}
