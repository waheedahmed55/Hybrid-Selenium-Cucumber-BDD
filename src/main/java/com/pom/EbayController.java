package com.pom;

import org.openqa.selenium.By;

public class EbayController {
	
	public static By SignIn = By.linkText("Sign in");
	public static By ItemList =By.tagName("li").className("sresult");
	public static By Item =By.className("lvpic");
	public static By Sorting = By.linkText("Price + Shipping: lowest first");
	public static By SortingICon = By.className("sort-menu-container");
	public static By SelectColor = By.id("msku-sel-1");
	public static By AddToCart =By.id("isCartBtn_btn");
	public static By CheckOut = By.id("ptcBtnBottom");
	public static By PayPal = By.cssSelector("span.PAYPAL.pmt-logo");
	public static By Cart = By.id("gh-cart-1");
	public static By Remove = By.linkText("Remove");
	public static By SortButton = By.className("x-flyout__button");
			
}
