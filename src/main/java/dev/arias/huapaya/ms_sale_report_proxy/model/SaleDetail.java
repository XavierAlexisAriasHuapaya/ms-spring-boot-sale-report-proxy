package dev.arias.huapaya.ms_sale_report_proxy.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetail {
    
    private Long id;

    private Long product;

    private Long typeAffectation;

    private Long quantity;

    private BigDecimal salePrice;

    private BigDecimal discount;

    private BigDecimal totalAmount;

    private Boolean procentageDiscount;

}
