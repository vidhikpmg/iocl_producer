package in.kpmg.iocl.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kpmg.iocl.entity.ExchangeEntity;
import in.kpmg.iocl.repo.ExchangeRepo;
import in.kpmg.iocl.api.ExchangeRateRequest;
import in.kpmg.iocl.api.ExchangeRateResponse;
import in.kpmg.iocl.api.AllExchange;

@Service
public class IoclDataServiceImpl {

	@Autowired
	private ExchangeRepo exchangeRepo;

/*	public Date convertedDate(String startDate, String format) {
		Date convDate = null;
		try {
			if (startDate != null && format != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				convDate = dateFormat.parse(startDate);
				System.out.println(convDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convDate;
	}*/


	public ExchangeRateResponse fetchExchangeRate(ExchangeRateRequest req) {
/*
		String excFromTime = req.getExchangeRateTypeCRorMDFromTime();
*/
		/*String excToTime= req.getExchangeRateTypeCRorMDToTime();

		String exc_FromDate = excFromTime.replaceAll("\\.\\d{3}$", "");
		String exc_ToTime = excToTime.replaceAll("\\.\\d{3}$", "");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime exchangeRateStartDate = LocalDateTime.parse(exc_FromDate, formatter);
		LocalDateTime exchangeRateEndDate = LocalDateTime.parse(exc_ToTime, formatter);
*/
		String from_currency = req.getFromCurrency();
		String to_currency = req.getToCurrency();
		String exchange_type = req.getExchangeType();
		String effective_date = req.getEffectiveDate();

		ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();
		exchangeRateResponse.setIsSuccess(false);

		List<AllExchange> fetchedList = new ArrayList<>();

		if (from_currency != null && to_currency != null && exchange_type !=null && effective_date != null) {
			try {
				List<ExchangeEntity> fetchData = exchangeRepo
						.fetchExchangeData(from_currency, to_currency, exchange_type, effective_date);

				for (ExchangeEntity data : fetchData) {
					AllExchange allExchange = new AllExchange();
				    allExchange.setEffectiveDate(effective_date);
					allExchange.setExchangeType(exchange_type);
					allExchange.setFromCurrencyRatio(data.getFfact());
					allExchange.setToCurrencyRatio(data.getTfact());
					allExchange.setFromCurrency(data.getFcurr());
					allExchange.setToCurrency(data.getTcurr());
					allExchange.setExchangeRate(data.getUkurs());
					fetchedList.add(allExchange);
				}

				if (fetchedList.size() > 0) {
					exchangeRateResponse.setIsSuccess(true);
					exchangeRateResponse.getExchange().addAll(fetchedList);

				}
			} catch (Exception e) {
				System.out.println("error in fetchCustomerSalesArea " + e.getMessage());
			}
		}
		return exchangeRateResponse;
	}

/*	public String convertTimeToString(LocalDateTime time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
		String formattedDateTime = time.format(formatter);
		return formattedDateTime;
	}*/


};