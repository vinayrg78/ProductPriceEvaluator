package com.ppe;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ppe.service.ExemptTaxableServiceImpl;
import com.ppe.service.NonExemptTaxableServiceImpl;

public class BasketTest {
	NonExemptTaxableServiceImpl nets;
	ExemptTaxableServiceImpl ets;
	
	@Before
	public void setUp() throws Exception {
		nets = new NonExemptTaxableServiceImpl();
		ets = new ExemptTaxableServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//@Test
	public void testMoney(){
		BigDecimal price1 = new BigDecimal("10.4051");
		price1 = price1.setScale(2, RoundingMode.HALF_UP);
		System.out.println("simple price1: " + price1);

//		BigDecimal price2 = new BigDecimal("10.41");
//		BigDecimal total = price1.add(price2);
//		System.out.println("simple total: " + total);
		
		 // To round to the nearest .05, multiply by 20, round to the nearest integer, then divide by 20
//		System.out.println("total.doubleValue(): " + total.doubleValue());
//		System.out.println("total.doubleValue() * 20: " + total.doubleValue() * 20);
//		System.out.println("Math.ceil(total.doubleValue() * 20): " + Math.ceil(total.doubleValue() * 20));
//		System.out.println("Math.ceil(total.doubleValue() * 20) / 20: " + Math.ceil(total.doubleValue() * 20) / 20);
		
//		BigDecimal result =  new BigDecimal(Math.ceil(total.doubleValue() * 20) / 20);
//	    result = result.setScale(2, RoundingMode.HALF_EVEN);
//		System.out.println("rounded result: " + result);
	}
	
	/*  Input 1:
		1 book at 12.49
        1 music CD at 16.49
		1 chocolate bar at 0.85
		
		1 book : 12.49
		1 music CD: 16.49
		1 chocolate bar: 0.85
		Sales Taxes: 1.50
		Total: 29.83
	*/ 
	@Test
	public void testBasketPrintReceipt1() {
		System.out.println("\nOutput 1:");
		Product book = new Book(false, new BigDecimal("12.49"));
		Product musicCd = new MusicCD(false, new BigDecimal("14.99"));
		Product chocolateBar = new ChocolateBar(false, new BigDecimal("0.85"));

		Basket basket = new Basket();
		basket.addProduct(book);
		basket.addProduct(musicCd);
		basket.addProduct(chocolateBar);
		
		System.out.println(basket.getReceiptForBasketContents());
	}
	
	/* Input 2:
		1 imported box of chocolates at 10.00
		1 imported bottle of perfume at 47.50
	 * Output 2:
		1 imported box of chocolates: 10.50
		1 imported bottle of perfume: 54.65
		Sales Taxes: 7.65
		Total: 65.15
	 */
	@Test
	public void testBasketPrintReceipt2(){
		System.out.println("\nOutput 2:");

		Product impChocolateBox = new ChocolateBox(true, new BigDecimal("10.00"));
		Product impPerfumeBottle = new PerfumeBottle(true, new BigDecimal("47.50"));

		Basket basket = new Basket();
		basket.addProduct(impChocolateBox);
		basket.addProduct(impPerfumeBottle);
		
		System.out.println(basket.getReceiptForBasketContents());
	}

	/* Input 2:
		1 imported bottle of perfume at 27.99
		1 bottle of perfume at 18.99
		1 packet of headache pills at 9.75
		1 box of imported chocolates at 11.25
	 * Output 2:
		1 imported bottle of perfume: 32.19
		1 bottle of perfume: 20.89
		1 packet of headache pills: 9.75
		1 imported box of chocolates: 11.85
		Sales Taxes: 6.70
		Total: 74.68
	 */
	@Test
	public void testBasketPrintReceipt3(){
		System.out.println("\nOutput 3:");

		Product impPerfumeBottle = new PerfumeBottle("27.99");
		impPerfumeBottle.setImported(true);
		
		Product perfumeBotle = new PerfumeBottle(false, new BigDecimal("18.99"));
		perfumeBotle.setImported(false);
		
		Product packetOfHeadachePills = new HeadachePill(false, new BigDecimal("9.75"));
		packetOfHeadachePills.setImported(false);
		
		Product impChocolateBox = new ChocolateBox(true, new BigDecimal("11.25"));
		impChocolateBox.setImported(true);
		
		Basket basket = new Basket();
		basket.addProduct(impPerfumeBottle);
		basket.addProduct(perfumeBotle);
		basket.addProduct(packetOfHeadachePills);
		basket.addProduct(impChocolateBox);

		System.out.println(basket.getReceiptForBasketContents());
	}
	}



