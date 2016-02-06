package services.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.TransactionProductInfo;
import models.bean.TransactionProductInfoBean;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.TransactionProductInfoRepository;
import services.service.TransactionProductInfoServiceI;

@Named
@Singleton
public class TransactionProductInfoServiceImpl implements TransactionProductInfoServiceI{

	@Inject
	TransactionProductInfoRepository transactionProductInfoRepository;

	@Override
	public TransactionProductInfoBean insertIntoTransactionProductinfo(
			TransactionProductInfoBean transactionProductInfoBean) throws BaseException {
		try {
			TransactionProductInfo transactionProductInfo = transactionProductInfoRepository.save(transactionProductInfoBean.toTransactionProductInfo());
			return transactionProductInfo.toTransactionProductInfoBean();
		} catch(Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public TransactionProductInfo insertIntoTransactionProductinfo(TransactionProductInfo transactionProductInfo)
			throws BaseException {
		try {
			return transactionProductInfoRepository.save(transactionProductInfo);
		} catch(Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
	
}