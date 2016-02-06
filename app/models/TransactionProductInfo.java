package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import models.bean.TransactionProductInfoBean;
import utilities.Constants;

@Entity
@Table(name="TRANSACTION_PRODUCT_INFO", schema=Constants.SCHEMA_NAME_DELIVERY)
public class TransactionProductInfo {

	public TransactionProductInfo() {}
	
	public TransactionProductInfo(Long transactionProductInfoId, Long productId, Integer quantity, TransactionInfo transaction) {
		this.transactionProductInfoId = transactionProductInfoId;
		this.productId = productId;
		this.quantity = quantity;
		this.transaction = transaction;
	}
	
	public TransactionProductInfo(Long productId, Integer quantity, TransactionInfo transaction) {
		this.productId = productId;
		this.quantity = quantity;
		this.transaction = transaction;
	}
	
	@Id
	@Column(name="TRANSACTION_PRODUCT_INFO_ID", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long transactionProductInfoId;
	
	@Column(name="PRODUCT_ID", nullable=false)
	private Long productId;
	
	@Column(name="QUANTITY", nullable=false)
	private Integer quantity;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="TRANSACTION_ID")
	private TransactionInfo transaction;
	
	@OneToMany(mappedBy="productInfo")
	private Set<ProductCommunication> productCommunication;
	
	public TransactionProductInfoBean toTransactionProductInfoBean() {
		return new TransactionProductInfoBean(this.transactionProductInfoId, this.productId, this.quantity, this.toTransactionProductInfoBean().getTransactionBean());
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

	public TransactionInfo getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionInfo transaction) {
		this.transaction = transaction;
	}

	public Set<ProductCommunication> getProductCommunication() {
		return productCommunication;
	}

	public void setProductCommunication(Set<ProductCommunication> productCommunication) {
		this.productCommunication = productCommunication;
	}
}