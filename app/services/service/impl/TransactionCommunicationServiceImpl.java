package services.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.TransactionCommunication;
import models.bean.TransactionCommunicationBean;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.TransactionCommunicationRepository;
import services.service.TransactionCommunicationServiceI;

@Named
@Singleton
public class TransactionCommunicationServiceImpl implements TransactionCommunicationServiceI{

	@Inject
	TransactionCommunicationRepository transactionCommunicationRepository;

	@Override
	public TransactionCommunicationBean insertIntoTransactionCommunication(
			TransactionCommunicationBean transactionCommunicationBean) throws BaseException {
		try {
			TransactionCommunication transactionCommunication = transactionCommunicationRepository.save(transactionCommunicationBean.toTransactionCommunication());
			return transactionCommunication.toTransactionCommunicationBean();
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public TransactionCommunication insertIntoTransactionCommunication(
			TransactionCommunication transactionCommunication) throws BaseException {
		try {
			return transactionCommunicationRepository.save(transactionCommunication);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
}
