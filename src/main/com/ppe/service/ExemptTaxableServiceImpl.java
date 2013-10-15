package com.ppe.service;

import java.math.BigDecimal;

public class ExemptTaxableServiceImpl extends AbstractTaxableService {

	private static ExemptTaxableServiceImpl exemptTaxableServiceImpl = new ExemptTaxableServiceImpl();
	
	public static ExemptTaxableServiceImpl getInstance(){
		return exemptTaxableServiceImpl;
	}
	
	@Override
	protected BigDecimal calculateSalesTax(BigDecimal basePrice) {
		return new BigDecimal("0");
	}

}
