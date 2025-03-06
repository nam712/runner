
package com.sCore.modules.mngOrganization.bo;

import java.util.Date;
import java.util.List;

import lombok.Data;


/**
 * @author sCore
 * @since 04/03/2024
 * @version 1.0
 */
@Data
public class EmployeeForm {

    private Long id;
    private String code;
    private String fullname;
    private Date dateOfBirth;
    private Integer gender;
    private String address;
    private Long ethnic;
    private Long organizationWork;
    private Date createdDate;
    private String createdBy;
    private Integer isPartyMember;
    private Date partyDate;
    private String phoneNumber;
    private Date modifiedDate;
    private String type;
    private String modifiedBy;
    private List<Long> orgIds;
}
