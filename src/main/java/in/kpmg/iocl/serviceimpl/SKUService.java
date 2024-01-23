package in.kpmg.iocl.serviceimpl;



import in.kpmg.iocl.entity.SKUModel;
import in.kpmg.iocl.repo.SKURepository;
import in.kpmg.iocl.skuapi.SkuAltConversion;
import in.kpmg.iocl.skuapi.SkuAltConversionRequest;
import in.kpmg.iocl.skuapi.SkuAltConversionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class SKUService {

    @Autowired
    SKURepository skuRepository;

    public SkuAltConversionResponse getSkuresponse(@RequestBody SkuAltConversionRequest req) {

        String materialNo = req.getMaterialNo();
        String baseUnitOfMeasure = req.getBaseUnitOfMeasure();
        String unitOfMeasureDisplay = req.getUnitOfMeasureDisplay();
        String denominatorConversion = req.getDenominatorConversion();
        String numeratorConversion = req.getNumeratorConversion();


        List<SkuAltConversion> sku_list_response=new ArrayList<>();
        SkuAltConversionResponse skuAltConversionResponse = new SkuAltConversionResponse();
        skuAltConversionResponse.setIsSuccess(false);

        if(materialNo!=null && baseUnitOfMeasure !=null && unitOfMeasureDisplay !=null && numeratorConversion !=null && denominatorConversion !=null)
        {
            try {
                List<SKUModel> skuDetails = skuRepository.getSKUData(materialNo,baseUnitOfMeasure,unitOfMeasureDisplay,numeratorConversion,denominatorConversion);

                    for(SKUModel skuData:skuDetails) {
                        SkuAltConversion sku_altConversion = new SkuAltConversion();
                        System.out.println("Material ID: "+skuData.getMatnr());
                        sku_altConversion.setMaterialNo(skuData.getMatnr());
                        sku_altConversion.setBaseUnitOfMeasure(skuData.getMeinh());
                        sku_altConversion.setUnitOfMeasureDisplay(skuData.getMeins());
                        sku_altConversion.setNumeratorConversion(skuData.getUmrez());
                        sku_altConversion.setDenominatorConversion(skuData.getUmren());

                        skuAltConversionResponse.getSkuAltConversion().add(sku_altConversion);
                    }
                if (skuAltConversionResponse.getSkuAltConversion().size() > 0) {
                  skuAltConversionResponse.setIsSuccess(true);
                  skuAltConversionResponse.setMessage("Data is get fetched ");



              }
            }catch(Exception ex){
                skuAltConversionResponse.setIsSuccess(false);
                skuAltConversionResponse.setMessage("Unable to fetch data from IOCL. Exception occured :: " + ex.getMessage());
                ex.printStackTrace();
            }
        }return skuAltConversionResponse;
    }
}
