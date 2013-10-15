package com.ppe;

import java.math.BigDecimal;

import com.ppe.service.ExemptTaxableServiceImpl;

public class HeadachePill extends Product {
	
	private static final String PROD_DESC = "packet of headache pills ";
	
	public HeadachePill(boolean isImported, BigDecimal basePrice){
		super(isImported, basePrice);
	}

	@Override
	public String getDescription(){
		return PROD_DESC;
	}

	@Override
	protected void setTaxable() {
		this.taxable = ExemptTaxableServiceImpl.getInstance();
	}

}
