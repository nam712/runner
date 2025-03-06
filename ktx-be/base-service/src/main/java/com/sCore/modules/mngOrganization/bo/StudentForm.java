
package com.sCore.modules.mngOrganization.bo;

import java.util.Date;

import lombok.Data;

/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Data
public class StudentForm {

    private Long id;
    private String code;
    private String fullname;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private Integer gender;
    private String phoneNumber;
    private String classroomCode;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
