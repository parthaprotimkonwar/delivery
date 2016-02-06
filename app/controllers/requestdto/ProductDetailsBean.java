package controllers.requestdto;

import java.io.Serializable;

public class ProductDetailsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductDetailsBean() {
	}
	
	public ProductDetailsBean(Long productId, Integer quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public Long productId;
	public Integer quantity;
	public Long communicationId;

}