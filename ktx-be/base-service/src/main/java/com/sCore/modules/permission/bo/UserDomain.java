
package com.sCore.modules.permission.bo;


import javax.persistence.*;

import lombok.Data;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "p_user_domain")
@IdClass(UserDomainID.class)
public class UserDomain {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "domain")
    private Long domain;

}
