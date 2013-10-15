package com.ppe.service;

import java.math.BigDecimal;

public class NonExemptTaxableServiceImpl extends AbstractTaxableService {

	private static NonExemptTaxableServiceImpl nonExemptTaxableServiceImpl = new NonExemptTaxableServiceImpl();
	
	public static NonExemptTaxableServiceImpl getInstance(){
		return nonExemptTaxableServiceImpl;
	}
	
	@Override
	protected BigDecimal calculateSalesTax(BigDecimal basePrice) {
		BigDecimal salesTax = new BigDecimal("0");
		salesTax = basePrice.multiply(SALES_TAX_RATE);
//		System.out.println("sales tax  calc in NETServiceImpl: "+salesTax);
		return salesTax;
	}

}
