package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.bean.TransactionCommunicationBean;
import utilities.Constants;

@Entity
@Table(name="TRANSACTION_COMMUNICATION", schema=Constants.SCHEMA_NAME_DELIVERY)
public class TransactionCommunication {

	public TransactionCommunication() {}
	
	public TransactionCommunication(Long transactionCommunicationId, Long communicationId, TransactionInfo transactionInfo) {
		this.transactionCommunicationId = transactionCommunicationId;
		this.communicationId = communicationId;
		this.transactionInfo = transactionInfo;
	}
	
	public TransactionCommunication(Long communicationId, TransactionInfo transactionInfo) {
		this.communicationId = communicationId;
		this.transactionInfo = transactionInfo;
	}
	
	@Id
	@Column(name="TRANSACTION_COMMUNICATION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionCommunicationId;
	
	@Column(name="COMMUNICATION_ID", nullable=false)
	private Long communicationId;
	
	@ManyToOne
	@JoinColumn
	private TransactionInfo transactionInfo;
	
	
	public TransactionCommunicationBean toTransactionCommunicationBean() {
		return new TransactionCommunicationBean(this.transactionCommunicationId, this.communicationId, this.transactionInfo.toTransactionInfoBean());
	}
	
}
