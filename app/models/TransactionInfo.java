package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import models.bean.TransactionInfoBean;
import utilities.Constants;

@Entity
@Table(schema=Constants.SCHEMA_NAME_DELIVERY, name="TRANSACTION_INFO")
public class TransactionInfo {

	public TransactionInfo() {}
	
	public TransactionInfo(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	public TransactionInfo(Long transactionId, Long userId, Long paymentId, Long addressId) {
		this.transactionId = transactionId;
		this.userId = userId;
		this.paymentId = paymentId;
		this.addressId = addressId;
	}
	
	public TransactionInfo(Long userId, Long paymentId, Long addressId) {
		this.userId = userId;
		this.paymentId = paymentId;
		this.addressId = addressId;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="TRANSACTION_ID")
	private Long transactionId;
	
	@Column(name="USER_ID", nullable=false)
	private Long userId;
	
	@Column(name="PAYMENT_ID", nullable=false)
	private Long paymentId;
	
	@Column(name="ADDRESS_ID", nullable=false)
	private Long addressId;
	
	@OneToMany(mappedBy="transaction" , cascade = CascadeType.ALL)
	private Set<TransactionProductInfo> transactionProductInfo;
	
	@OneToMany(mappedBy="transactionInfo")
	private Set<TransactionCommunication> transactionCommunication;
	
	@Override
	public boolean equals(Object that) {
		/*if(that == null || that != this || that.getClass() != getClass())
			return false;
		
		*/
		TransactionInfo transactionInfo = (TransactionInfo)that;
		//(transactionInfo.transactionId == null || this.transactionId == null) ? false :
		return  transactionInfo.transactionId.equals(this.transactionId);
	}
	
	@Override
	public int hashCode() {
		return transactionId != null ? transactionId.hashCode() : 17;
	}
	
	public TransactionInfoBean toTransactionInfoBean() {
		return new TransactionInfoBean(this.transactionId, this.userId, this.paymentId, this.addressId);
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

	public Set<TransactionProductInfo> getTransactionProductInfo() {
		return transactionProductInfo;
	}

	public void setTransactionProductInfo(Set<TransactionProductInfo> transactionProductInfo) {
		this.transactionProductInfo = transactionProductInfo;
	}

	public Set<TransactionCommunication> getTransactionCommunication() {
		return transactionCommunication;
	}

	public void setTransactionCommunication(Set<TransactionCommunication> transactionCommunication) {
		this.transactionCommunication = transactionCommunication;
	}
}
