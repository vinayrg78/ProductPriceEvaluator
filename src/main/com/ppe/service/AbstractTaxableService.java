package com.ppe.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractTaxableService {

	public static final BigDecimal IMPORT_TAX_RATE = new BigDecimal(.05);
	public static final BigDecimal SALES_TAX_RATE = new BigDecimal(0.10);
	
    private int DECIMALS = 2;
    private RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

	private BigDecimal applyRoundingLogic(BigDecimal total){
		BigDecimal result =  new BigDecimal(Math.ceil(total.doubleValue() * 20) / 20);
	    result = result.setScale(DECIMALS, ROUNDING_MODE);
	    return result;
	}
	
	
	public BigDecimal calculateTotalSalesTax(boolean isImported, BigDecimal basePrice){
		BigDecimal importTax = new BigDecimal("0");
		BigDecimal salesTax = new BigDecimal("0");

		if(isImported){
			importTax = calculateImportTax(basePrice);
		}
		salesTax = calculateSalesTax(basePrice);
		
		BigDecimal totalTax = importTax.add(salesTax);
		BigDecimal roundedTaxValue = applyRoundingLogic(totalTax);
		return roundedTaxValue;
	}
	
	protected abstract BigDecimal calculateSalesTax(BigDecimal basePrice);

	private BigDecimal calculateImportTax(BigDecimal basePrice) {
		return basePrice.multiply(IMPORT_TAX_RATE);
	}
	
}
