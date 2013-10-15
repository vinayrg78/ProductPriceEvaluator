package com.ppe;

import java.math.BigDecimal;

import com.ppe.service.ExemptTaxableServiceImpl;

public class Book extends Product {
    public static final String PROD_DESC = "book ";
	
	public Book(boolean isImported, BigDecimal basePrice){
		super(isImported, basePrice);
	}
	
	public String getDescription(){
		return PROD_DESC;
	}

	@Override
	protected void setTaxable() {
		this.taxable = ExemptTaxableServiceImpl.getInstance();
	}
}
