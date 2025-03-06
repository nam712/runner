
package com.sCore.modules.permission.bo;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
public class UserDomainID implements Serializable {

    private Long userId;
    private Long domain;
}
