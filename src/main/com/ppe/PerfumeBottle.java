package com.ppe;

import java.math.BigDecimal;

import com.ppe.service.NonExemptTaxableServiceImpl;

public class PerfumeBottle extends Product {
	
    public static final String PROD_DESC = "bottle of perfume ";

	public PerfumeBottle(String basePrice){
		super(basePrice);
	}
	
	public PerfumeBottle(boolean isImported, BigDecimal basePrice) {
		super(isImported, basePrice);
	}

	@Override
	public String getDescription(){
		return PROD_DESC;
	}
	
	@Override
	protected void setTaxable() {
		this.taxable = NonExemptTaxableServiceImpl.getInstance();
	}
}
