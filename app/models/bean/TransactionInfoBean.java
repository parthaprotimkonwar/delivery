package models.bean;

import models.TransactionInfo;

public class TransactionInfoBean {

	public TransactionInfoBean(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	public TransactionInfoBean(Long transactionId, Long userId, Long paymentId, Long addressId) {
		this.transactionId = transactionId;
		this.userId = userId;
		this.paymentId = paymentId;
		this.addressId = addressId;
	}
	
	public TransactionInfoBean(Long userId, Long paymentId, Long addressId) {
		this.userId = userId;
		this.paymentId = paymentId;
		this.addressId = addressId;
	}

	private Long transactionId;
	private Long userId;
	private Long paymentId;
	private Long addressId;

	public TransactionInfo toTransactionInfo() {
		return new TransactionInfo(this.transactionId, this.userId, this.paymentId, this.addressId);
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
}
