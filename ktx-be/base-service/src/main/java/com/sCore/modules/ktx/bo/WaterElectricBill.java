
package com.sCore.modules.ktx.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "water_electric_bill")
public class WaterElectricBill {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "room_code")
    private String roomCode;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Transient
    private String roomName;

    @Transient
    private List<WaterElectricBillDetail> detailList;

}
