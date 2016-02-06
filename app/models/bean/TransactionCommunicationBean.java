package models.bean;

import models.TransactionCommunication;

public class TransactionCommunicationBean {

	private Long transactionCommunicationId;
	private Long communicationId;
	private TransactionInfoBean transactionInfoBean;

	public TransactionCommunicationBean(Long transactionCommunicationId, Long communicationId, TransactionInfoBean transactionInfoBean) {
		this.transactionCommunicationId = transactionCommunicationId;
		this.communicationId = communicationId;
		this.transactionInfoBean = transactionInfoBean;
	}
	
	public TransactionCommunication toTransactionCommunication() {
		return new TransactionCommunication(this.transactionCommunicationId, this.communicationId,
				this.transactionInfoBean.toTransactionInfo());
	}
	
	public Long getTransactionCommunicationId() {
		return transactionCommunicationId;
	}

	public void setTransactionCommunicationId(Long transactionCommunicationId) {
		this.transactionCommunicationId = transactionCommunicationId;
	}

	public Long getCommunicationId() {
		return communicationId;
	}

	public void setCommunicationId(Long communicationId) {
		this.communicationId = communicationId;
	}

	public TransactionInfoBean getTransactionInfoBean() {
		return transactionInfoBean;
	}

	public void setTransactionInfoBean(TransactionInfoBean transactionInfoBean) {
		this.transactionInfoBean = transactionInfoBean;
	}
}
