package services.service;

import models.TransactionProductInfo;
import models.bean.TransactionProductInfoBean;
import play.exceptions.BaseException;

public interface TransactionProductInfoServiceI {

	/**
	 * Insert transactionProductInfoBean object
	 * @param transactionProductInfoBean
	 * @return
	 * @throws BaseException
	 */
	TransactionProductInfoBean insertIntoTransactionProductinfo(TransactionProductInfoBean transactionProductInfoBean) throws BaseException;
	
	/**
	 * Insert transactionProductInfo object
	 * @param transactionProductInfo
	 * @return
	 * @throws BaseException
	 */
	TransactionProductInfo insertIntoTransactionProductinfo(TransactionProductInfo transactionProductInfo) throws BaseException;
	
}
