package controllers.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import controllers.base.BaseController;
import controllers.requestdto.TransactionDetailsRequestBean;
import controllers.responsedto.ErrorResponse;
import controllers.responsedto.TransactionDetailsResponseBean;
import play.exceptions.BaseException;
import play.mvc.BodyParser;
import play.mvc.Result;
import services.service.impl.ServicesFactory;

@Named
@Singleton
public class DeliveryController extends BaseController {

	@Inject
	private ServicesFactory serviceFactory;
	
	
	@BodyParser.Of(BodyParser.Json.class)
    public Result createDelivery() {
		
		TransactionDetailsRequestBean request = null;
		TransactionDetailsResponseBean response = null;
		try {
			System.out.println("Inside module");
			request = convertRequestBodyToObject(request().body(), TransactionDetailsRequestBean.class);
			response = serviceFactory.deliveryIntegrationServiceI.createTransactionEntry(request);
		} catch (BaseException ex) {
			ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
			return errorObjectToJsonResponse(errorResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = unknownErrorResponse();
			return errorObjectToJsonResponse(errorResponse);
		}
		
		/*List<ProductDetailsBean> products = new ArrayList<>();
		products.add(new ProductDetailsBean(1111L, 2));
		products.add(new ProductDetailsBean(1112L, 1));
		products.add(new ProductDetailsBean(1113L, 3));
		
		request = new TransactionDetailsRequestBean(1234L, 2345L, 3456L, 5678L, products);*/
		return convertObjectToJsonResponse(response);
	}
}
