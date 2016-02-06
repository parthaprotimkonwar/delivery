package services.service;

import models.TransactionCommunication;
import models.bean.TransactionCommunicationBean;
import play.exceptions.BaseException;

public interface TransactionCommunicationServiceI {
	
	/**
	 * Inserts TransactionCommunicationBean object
	 * @param transactionCommunicationBean
	 * @return
	 * @throws BaseException
	 */
	TransactionCommunicationBean insertIntoTransactionCommunication(TransactionCommunicationBean transactionCommunicationBean) throws BaseException;

	/**
	 * Inserts TransactionCommunication object
	 * @param transactionCommunicationBean
	 * @return
	 * @throws BaseException
	 */
	TransactionCommunication insertIntoTransactionCommunication(TransactionCommunication transactionCommunication) throws BaseException;

}