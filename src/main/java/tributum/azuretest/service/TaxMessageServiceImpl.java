package tributum.azuretest.service;

import org.springframework.stereotype.Service;

import tributum.azuretest.model.*;

@Service
public class TaxMessageServiceImpl implements TaxMessageService {

	@Override
	public double taxAmount(double bPrice, double sPrice, int nos, double taxRate) {
		TaxMessage txmsg = new TaxMessage();
		txmsg.setBuyPrice(bPrice);
		txmsg.setSellPrice(sPrice);
		txmsg.setNumberShares(nos);
		txmsg.setTaxRate(taxRate);
		
		int number = txmsg.getNumberShares();
		
		final double earnings = (txmsg.getSellPrice() * number) - (txmsg.getBuyPrice() * number);
		
		if(earnings > 0) {
			return (earnings * txmsg.getTaxRate() / 100);
		}
		else {
			return 0;
		}
	}
	
}
