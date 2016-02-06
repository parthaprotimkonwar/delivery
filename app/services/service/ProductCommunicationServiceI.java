package services.service;

import models.ProductCommunication;
import models.bean.ProductCommunicationBean;
import play.exceptions.BaseException;

public interface ProductCommunicationServiceI {
	
	/**
	 * 
	 * @param productCommunicationBean
	 * @return
	 * @throws BaseException
	 */
	ProductCommunicationBean insertIntoProductCommunication(ProductCommunicationBean productCommunicationBean) throws BaseException; 
	
	/**
	 * 
	 * @param productCommunicationBean
	 * @return
	 * @throws BaseException
	 */
	ProductCommunication insertIntoProductCommunication(ProductCommunication productCommunication) throws BaseException; 

}
