package models.bean;

import models.TransactionProductInfo;

public class TransactionProductInfoBean {

	private Long transactionProductInfoId;
	private Long productId;
	private Integer quantity;
	private TransactionInfoBean transactionBean;

	public TransactionProductInfoBean(Long productId, Integer quantity, TransactionInfoBean transactionBean) {
		this.productId = productId;
		this.quantity = quantity;
		this.transactionBean = transactionBean;
	}
	
	public TransactionProductInfoBean(Long transactionProductInfoId, Long productId, Integer quantity, TransactionInfoBean transactionBean) {
		this.transactionProductInfoId = transactionProductInfoId;
		this.productId = productId;
		this.quantity = quantity;
		this.transactionBean = transactionBean;
	}
	
	/**
	 * toTransactionProductInfo()
	 * @return
	 */
	public TransactionProductInfo toTransactionProductInfo() {
		return new TransactionProductInfo(this.transactionProductInfoId, this.productId, this.quantity,
				this.transactionBean.toTransactionInfo());
	}

	public Long getTransactionProductInfoId() {
		return transactionProductInfoId;
	}

	public void setTransactionProductInfoId(Long transactionProductInfoId) {
		this.transactionProductInfoId = transactionProductInfoId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public TransactionInfoBean getTransactionBean() {
		return transactionBean;
	}

	public void setTransactionBean(TransactionInfoBean transactionBean) {
		this.transactionBean = transactionBean;
	}

}