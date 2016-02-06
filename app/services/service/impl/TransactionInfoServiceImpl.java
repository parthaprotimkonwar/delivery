package services.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.transaction.annotation.Transactional;

import models.TransactionInfo;
import models.bean.TransactionInfoBean;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.TransactionInfoRepository;
import services.service.TransactionInfoServiceI;

@Named
@Singleton
@Transactional
public class TransactionInfoServiceImpl implements TransactionInfoServiceI{

	@Inject
	TransactionInfoRepository transactionInfoRepository;
	
	@Override
	public TransactionInfoBean insertIntoTransaction(TransactionInfoBean transactionInfoBean) throws BaseException {
		try {
			TransactionInfo transactionInfo = transactionInfoRepository.save(transactionInfoBean.toTransactionInfo());
			return transactionInfo.toTransactionInfoBean();
		} catch(Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public TransactionInfo insertIntoTransaction(TransactionInfo transactionInfo) throws BaseException {
		try {
			return transactionInfoRepository.save(transactionInfo);
		} catch(Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
}
