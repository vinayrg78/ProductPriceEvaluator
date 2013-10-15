package com.ppe;

import java.math.BigDecimal;

import com.ppe.service.AbstractTaxableService;

public abstract class Product {
	
	protected AbstractTaxableService taxable;
	private boolean isImported;
	private BigDecimal basePrice;
	
    private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
    private static int DECIMALS = 2;
    
	private static final String QTY_PREFIX = "1 ";
    private static final String IMPORTED = "imported ";
	
    //handle surplus decimal digits and convert to 2 decimal places.
    private static BigDecimal getScaledBasePrice(BigDecimal origBasePrice){
    	return origBasePrice.setScale(Product.DECIMALS, Product.ROUNDING_MODE);
    }
    
    public Product(String basePrice){
		this.basePrice = getScaledBasePrice(new BigDecimal(basePrice));
    }
    
	public Product(BigDecimal basePrice){
		this.isImported = false;
		this.basePrice = getScaledBasePrice(basePrice);
	}
	
	public Product(boolean isImported, BigDecimal basePrice){
		this.isImported = isImported;
		this.basePrice = getScaledBasePrice(basePrice);
	}
	
	public abstract String getDescription();
	
//	public void setTaxable(AbstractTaxableService taxable){
//		this.taxable = taxable;
//	}
	
	protected abstract void setTaxable();
	
	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public BigDecimal getSalesTax(){
		setTaxable();
		return taxable.calculateTotalSalesTax(isImported, basePrice);
	}
	
	public BigDecimal getBasePriceWithSalesTax(){
		BigDecimal basePriceWithTax = this.basePrice.add(getSalesTax());
		return basePriceWithTax;
	}
	
	public String toString(){
		StringBuilder description = new StringBuilder();
		description.append(QTY_PREFIX);
		if(isImported()){
			description.append(Product.IMPORTED);
		}
		description.append(getDescription());
		return description.toString();
	}
	
}




