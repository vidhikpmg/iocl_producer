package in.kpmg.iocl.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import in.kpmg.iocl.serviceimpl.IoclDataServiceImpl;
import in.kpmg.iocl.api.ExchangeRateRequest;
import in.kpmg.iocl.api.ExchangeRateResponse;

@Endpoint
public class IoclEndpoint {

	private static final String NAMESPACE = "http://www.kpmg.in/iocl/api";

	@Autowired
	IoclDataServiceImpl dataService;


	@PayloadRoot(namespace = NAMESPACE, localPart = "ExchangeRateRequest")
	@ResponsePayload
	public ExchangeRateResponse viewExchangeRate(@RequestPayload ExchangeRateRequest exchangeRateRequest) {
		ExchangeRateResponse fetchExchangeRate = dataService.fetchExchangeRate(exchangeRateRequest);
		return fetchExchangeRate;
	}

}
