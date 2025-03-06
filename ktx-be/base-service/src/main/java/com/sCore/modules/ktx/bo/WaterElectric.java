
package com.sCore.modules.ktx.bo;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "water_electric")
public class WaterElectric {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    @Column(name = "room_code")
    private String roomCode;

    @Column(name = "type")
    private String type;

    @Column(name = "old_numeral")
    private Integer oldNumeral;

    @Column(name = "new_numeral")
    private Integer newNumeral;

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

}
