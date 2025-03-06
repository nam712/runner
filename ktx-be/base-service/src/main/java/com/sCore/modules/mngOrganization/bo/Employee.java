
package com.sCore.modules.mngOrganization.bo;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

/**
 * @author sCore
 * @since 04/03/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "address")
    private String address;

    @Column(name = "ethnic")
    private Long ethnic;

    @Column(name = "organization_work")
    private Long organizationWork;

    @Column(name = "created_date")
    private Date createdDate;


    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "is_party_member")
    private Integer isPartyMember;

    @Column(name = "party_date")
    private Date partyDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "type")
    private String type;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Transient
    private String organizationName;
}
