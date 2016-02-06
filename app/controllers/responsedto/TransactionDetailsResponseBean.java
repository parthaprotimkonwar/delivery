package controllers.responsedto;

public class TransactionDetailsResponseBean {

	public TransactionDetailsResponseBean(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	public Long transactionId;
}
