package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.bean.ProductCommunicationBean;
import utilities.Constants;

@Entity
@Table(name="PRODUCT_COMMUNICATION", schema=Constants.SCHEMA_NAME_DELIVERY)
public class ProductCommunication {

	public ProductCommunication() {}
	
	public ProductCommunication(Long productCommunicationId, Long communicationId, TransactionProductInfo productInfo) {
		this.productCommunicationId = productCommunicationId;
		this.communicationId = communicationId;
		this.productInfo = productInfo;
	}
	
	public ProductCommunication(Long communicationId, TransactionProductInfo productInfo) {
		this.communicationId = communicationId;
		this.productInfo = productInfo;
	}
	
	@Id
	@Column(name="PRODUCT_COMMUNICATION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productCommunicationId;
	
	@Column(name="COMMUNICATION_ID", nullable=false)
	private Long communicationId;

	@ManyToOne
	@JoinColumn
	private TransactionProductInfo productInfo;
	
	public ProductCommunicationBean toProductCommunicationBean() {
		return new ProductCommunicationBean(this.productCommunicationId, this.communicationId, this.productInfo.toTransactionProductInfoBean());
	}
}