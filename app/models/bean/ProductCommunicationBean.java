package models.bean;

import models.ProductCommunication;

public class ProductCommunicationBean {

	private Long productCommunicationId;
	private Long communicationId;
	private TransactionProductInfoBean productInfoBean;

	public ProductCommunicationBean() {
	}

	public ProductCommunicationBean(Long communicationId, TransactionProductInfoBean productInfoBean) {
		this.communicationId = communicationId;
		this.productInfoBean = productInfoBean;
	}
	
	public ProductCommunicationBean(Long productCommunicationId, Long communicationId,
			TransactionProductInfoBean productInfoBean) {
		this.productCommunicationId = productCommunicationId;
		this.communicationId = communicationId;
		this.productInfoBean = productInfoBean;
	}

	public ProductCommunication toProductCommunication() {
		return new ProductCommunication(this.productCommunicationId, this.communicationId,
				this.productInfoBean.toTransactionProductInfo());
	}

	public Long getProductCommunicationId() {
		return productCommunicationId;
	}

	public void setProductCommunicationId(Long productCommunicationId) {
		this.productCommunicationId = productCommunicationId;
	}

	public Long getCommunicationId() {
		return communicationId;
	}

	public void setCommunicationId(Long communicationId) {
		this.communicationId = communicationId;
	}

	public TransactionProductInfoBean getProductInfoBean() {
		return productInfoBean;
	}

	public void setProductInfoBean(TransactionProductInfoBean productInfoBean) {
		this.productInfoBean = productInfoBean;
	}

}