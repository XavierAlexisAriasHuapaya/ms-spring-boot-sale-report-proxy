package dev.arias.huapaya.ms_sale_report_proxy.persistence.repository;

import java.util.Map;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import dev.arias.huapaya.ms_sale_report_proxy.configuration.bean.LoadBalancerConfiguration;

@FeignClient(name = "ms-sale-report")
@LoadBalancerClient(name = "ms-sale-report", configuration = LoadBalancerConfiguration.class)
public interface SaleRepository {

    @GetMapping(path = "/api/report/sale/sale")
    public Map<String, Object> findAll();

}
