package dev.arias.huapaya.ms_sale_report_proxy.presentation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.ms_sale_report_proxy.service.interfaces.SaleService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "sale")
@AllArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap<>();
        response = this.saleService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
