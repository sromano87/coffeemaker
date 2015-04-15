package edu.ncsu.csc326.coffeemaker.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CoffeeMakerTest.class, InventoryTest.class, RecipeBookTest.class})
public class AllTests {

}