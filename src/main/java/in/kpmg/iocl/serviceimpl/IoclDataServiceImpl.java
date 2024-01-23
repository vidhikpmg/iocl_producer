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

		List<AllExchange> fetchedList = new ArrayList<>();

		if (from_currency!= null && from_currency.length() > 0 &&
				to_currency != null && to_currency.length() > 0 &&
				exchange_type !=null && exchange_type.length() > 0 &&
				effective_date != null && effective_date.length() > 0) {
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
					exchangeRateResponse.setMessage("Data is fetched successfully");
					exchangeRateResponse.getExchange().addAll(fetchedList);
				}
				else{
					exchangeRateResponse.setIsSuccess(true);
					exchangeRateResponse.setMessage("No data present for the provided request");
				}
			} catch (Exception e) {
				exchangeRateResponse.setIsSuccess(false);
				exchangeRateResponse.setMessage("Exception occured :: " + e.getMessage());
				e.printStackTrace();
			}
		}
		else {
			exchangeRateResponse.setIsSuccess(false);
			exchangeRateResponse.setMessage("Mandatory request is empty");
		}
		return exchangeRateResponse;
	}

/*	public String convertTimeToString(LocalDateTime time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
		String formattedDateTime = time.format(formatter);
		return formattedDateTime;
	}*/


};