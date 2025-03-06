
package com.sCore.modules.ktx.bo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "water_electric_bill_detail")
public class WaterElectricBillDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bill_code")
    private String billCode;

    @Column(name = "type")
    private String type;

    @Column(name = "consumption")
    private Integer consumption;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "money")
    private Double money;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

}
