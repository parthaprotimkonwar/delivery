package services.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.ProductCommunication;
import models.bean.ProductCommunicationBean;
import play.exceptions.BaseException;
import play.exceptions.ErrorConstants;
import repository.ProductCommunicationRepository;
import services.service.ProductCommunicationServiceI;

@Named
@Singleton
public class ProductCommunicationServiceImpl implements ProductCommunicationServiceI{

	@Inject
	ProductCommunicationRepository productCommunicationRepository;

	@Override
	public ProductCommunicationBean insertIntoProductCommunication(ProductCommunicationBean productCommunicationBean)
			throws BaseException {
		try {
			ProductCommunication productCommunication = productCommunicationRepository.save(productCommunicationBean.toProductCommunication());
			return productCommunication.toProductCommunicationBean();
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}

	@Override
	public ProductCommunication insertIntoProductCommunication(ProductCommunication productCommunication)
			throws BaseException {
		try {
			return productCommunicationRepository.save(productCommunication);
		} catch (Exception ex) {
			ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
			throw new BaseException(error.errorCode, error.errorMessage, ex.getCause());
		}
	}
	
}
