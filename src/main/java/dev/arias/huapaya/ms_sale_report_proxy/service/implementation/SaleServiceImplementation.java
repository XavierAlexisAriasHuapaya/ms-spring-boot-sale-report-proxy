package dev.arias.huapaya.ms_sale_report_proxy.service.implementation;

import java.util.Map;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;

import dev.arias.huapaya.ms_sale_report_proxy.persistence.repository.FallbackRepository;
import dev.arias.huapaya.ms_sale_report_proxy.persistence.repository.SaleRepository;
import dev.arias.huapaya.ms_sale_report_proxy.service.interfaces.SaleService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SaleServiceImplementation implements SaleService{
    
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    private final SaleRepository saleRepository;

    private final FallbackRepository fallbackRepository;

    @Override
    public Map<String, Object> findAll() {
        var circuitBreaker = this.circuitBreakerFactory.create("sale-circuitbreaker");
        return circuitBreaker.run(() -> this.saleRepository.findAll(),
                throwable -> this.fallbackRepository.getFallback());
    }
    
}
