package services.service;

import controllers.requestdto.TransactionDetailsRequestBean;
import controllers.responsedto.TransactionDetailsResponseBean;
import play.exceptions.BaseException;

public interface DeliveryIntegrationServiceI {

	/**
	 * Create a transaction integration entry :
	 * 	1. Inserts into TransactionInfo.
	 * 	2. Inserts into TransactionProductInfo.
	 * 	3. Inserts into TransactionCommunication.
	 * 
	 * @param transactionDetailsRequestBean
	 * @return
	 * @throws BaseException
	 */
	TransactionDetailsResponseBean createTransactionEntry(TransactionDetailsRequestBean transactionDetailsRequestBean) throws BaseException;

}