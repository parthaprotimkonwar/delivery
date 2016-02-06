package services.service;

import models.TransactionInfo;
import models.bean.TransactionInfoBean;
import play.exceptions.BaseException;

public interface TransactionInfoServiceI {

	/**
	 * Inserts from a TransactionInfoBean object.
	 * @param transactionInfoBean
	 * @return
	 * @throws BaseException
	 */
	TransactionInfoBean insertIntoTransaction(TransactionInfoBean transactionInfoBean) throws BaseException;
	
	/**
	 * Inserts from a TransactionInfo object.
	 * @param transactionInfoBean
	 * @return
	 * @throws BaseException
	 */
	TransactionInfo insertIntoTransaction(TransactionInfo transactionInfo) throws BaseException;
	
}
