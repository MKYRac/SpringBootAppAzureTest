package tributum.azuretest.service;

public interface TaxMessageService {

	double taxAmount(double bPrice, double sPrice, int nos, double taxRate);

}