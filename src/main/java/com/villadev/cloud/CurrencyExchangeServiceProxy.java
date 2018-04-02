package com.villadev.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="netflix-zuul-api-gateway-server") //nao chama direto outro servico, passa pelo gateway
//@FeignClient(name="currency-exchange-service")
//@RibbonClient(name="currency-exchange-service") // distribui a carga
//@FeignClient(name="currency-exchange-service", url="localhost:8000") //nao distribui a carga
public interface CurrencyExchangeServiceProxy {
	//@GetMapping("/currency-exchange/from/{from}/to/{to}") //chama direto
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") //chama pelo gateway
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, 
			@PathVariable("to") String to);
}
