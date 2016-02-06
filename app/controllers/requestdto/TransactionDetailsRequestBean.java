package controllers.requestdto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransactionDetailsRequestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TransactionDetailsRequestBean() {
		
	}
	
	public TransactionDetailsRequestBean(Long userId, Long paymentId, Long addressId, Long communicationId, List<ProductDetailsBean> productDetails) {
		this.userId = userId;
		this.addressId = addressId;
		this.communicationId = communicationId;
		this.productDetails = productDetails;
	}
	
	public Long userId;
	public Long paymentId;
	public Long addressId;
	public Long communicationId;
	public List<ProductDetailsBean> productDetails = new ArrayList<>();

}