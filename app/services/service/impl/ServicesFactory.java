package services.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import services.service.DeliveryIntegrationServiceI;
import services.service.ProductCommunicationServiceI;
import services.service.TransactionCommunicationServiceI;
import services.service.TransactionInfoServiceI;
import services.service.TransactionProductInfoServiceI;

@Named
@Singleton
public class ServicesFactory {

	@Inject
	public ProductCommunicationServiceI productCommunicationServiceI;
	
	@Inject
	public TransactionCommunicationServiceI transactionCommunicationServiceI;
	
	@Inject
	public TransactionInfoServiceI transactionInfoServiceI;
	
	@Inject
	public TransactionProductInfoServiceI transactionProductInfoServiceI;
	
	@Inject
	public DeliveryIntegrationServiceI deliveryIntegrationServiceI;
	
}