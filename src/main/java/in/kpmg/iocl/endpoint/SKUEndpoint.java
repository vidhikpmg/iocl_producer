package in.kpmg.iocl.endpoint;

import in.kpmg.iocl.serviceimpl.SKUService;
import in.kpmg.iocl.skuapi.SkuAltConversionRequest;
import in.kpmg.iocl.skuapi.SkuAltConversionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SKUEndpoint {

    private static final String NAMESPACE = "http://www.kpmg.in/iocl/SKUapi";

    @Autowired
    SKUService skuDataService;


    @PayloadRoot(namespace = NAMESPACE, localPart = "Sku_alt_conversionRequest")
    @ResponsePayload
    public SkuAltConversionResponse viewSkuResponse(@RequestPayload SkuAltConversionRequest skuAltConversionRequest) {
        SkuAltConversionResponse skuGetData = skuDataService.getSkuresponse(skuAltConversionRequest);
        return skuGetData;

    }

}