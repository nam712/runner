
package com.sCore.modules.permission.bo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "p_action")
public class Action {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

}
