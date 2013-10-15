package com.ppe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<Product> productList;
	private BigDecimal totalPriceOfProductsInBasketWithSalesTax;
	
	public Basket(){
		this.productList = new ArrayList<Product>();
		totalPriceOfProductsInBasketWithSalesTax = new BigDecimal("0");
	}
	
	private BigDecimal getTotalSalesTaxForBasket(List<Product> productList) {
		BigDecimal totalTax = new BigDecimal("0");
		for(Product prod : productList){
			totalTax = totalTax.add(prod.getSalesTax());
		}
		return totalTax;
	}
	
	public List<Product> getProductList(){
		//returning defensive copy
		return new ArrayList<Product>(productList);
	}
	
	public void addProduct(Product prod){
		if(prod != null){
			this.productList.add(prod);
			totalPriceOfProductsInBasketWithSalesTax = 
					totalPriceOfProductsInBasketWithSalesTax.add(prod.getBasePriceWithSalesTax());
		}
	}
	
	public boolean removeProduct(Product prod){
		int index = productList.indexOf(prod);
		if(index > 0){
			productList.remove(index);
			totalPriceOfProductsInBasketWithSalesTax = 
					totalPriceOfProductsInBasketWithSalesTax.subtract(prod.getBasePriceWithSalesTax());
			return true;
		}
		return false;
	}
	
	public String getReceiptForBasketContents(){
		StringBuilder receiptToReturn = new StringBuilder();
		for(Product product : productList){
			receiptToReturn.append(product + ": " + product.getBasePriceWithSalesTax());
			receiptToReturn.append("\n");
		}
		
		BigDecimal taxes = getTotalSalesTaxForBasket(productList);
		receiptToReturn.append("Sales Taxes: " + taxes + "\n");
		receiptToReturn.append("Total:" + totalPriceOfProductsInBasketWithSalesTax);
		
		return receiptToReturn.toString();
	}
	
}
