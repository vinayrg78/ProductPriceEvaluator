package com.ppe;

import java.math.BigDecimal;

import com.ppe.service.NonExemptTaxableServiceImpl;

public class MusicCD extends Product {

	private static final String PROD_DESC = "Music CD ";

	public MusicCD(boolean isImported, BigDecimal basePrice){
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
