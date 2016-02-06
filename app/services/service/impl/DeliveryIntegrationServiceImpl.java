package services.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.transaction.annotation.Transactional;

import controllers.requestdto.ProductDetailsBean;
import controllers.requestdto.TransactionDetailsRequestBean;
import controllers.responsedto.TransactionDetailsResponseBean;
import models.ProductCommunication;
import models.TransactionCommunication;
import models.TransactionInfo;
import models.TransactionProductInfo;
import play.exceptions.BaseException;
import services.service.DeliveryIntegrationServiceI;
import services.service.ProductCommunicationServiceI;
import services.service.TransactionCommunicationServiceI;
import services.service.TransactionInfoServiceI;
import services.service.TransactionProductInfoServiceI;

@Singleton
@Named
@Transactional
public class DeliveryIntegrationServiceImpl implements DeliveryIntegrationServiceI{

	@Inject
	private TransactionInfoServiceI transactionInfoService;
	
	@Inject
	private TransactionProductInfoServiceI transactionProductInfoService;

	@Inject
	private TransactionCommunicationServiceI transactionCommunicationService;
	
	@Inject
	private ProductCommunicationServiceI productCommunicationService;
	
	@Override
	public TransactionDetailsResponseBean createTransactionEntry(
			TransactionDetailsRequestBean request) throws BaseException {
		
		//inserting into trnasactionInfo
		TransactionInfo transactionInfo = new TransactionInfo(request.userId, request.paymentId, request.addressId);
		transactionInfo = transactionInfoService.insertIntoTransaction(transactionInfo);
		
		//linking all products with transactionInfo in transactionProductInfo
		if(request.productDetails != null) {
			for(ProductDetailsBean productDetails : request.productDetails) {
				TransactionProductInfo tpInfo = new TransactionProductInfo(productDetails.productId, productDetails.quantity, transactionInfo);
				tpInfo = transactionProductInfoService.insertIntoTransactionProductinfo(tpInfo);
				
				//create an entry for products
				if(productDetails.communicationId != null) {
					ProductCommunication productCommunication = new ProductCommunication(productDetails.communicationId, tpInfo);
					productCommunicationService.insertIntoProductCommunication(productCommunication);
				}
			}
		}
		
		//linking the communication with the transaction 
		TransactionCommunication transactionCommunication = new TransactionCommunication(request.communicationId, transactionInfo);
		transactionCommunicationService.insertIntoTransactionCommunication(transactionCommunication);
		
		//setting the response
		TransactionDetailsResponseBean response  = new TransactionDetailsResponseBean(transactionInfo.getTransactionId());
		return response;
	}
	
	

}
