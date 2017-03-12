/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-20 14:21 创建
 *
 */
package hibernate.xml.relation.many2one;

import com.yjf.common.util.ToString;

import java.io.Serializable;

/**
 * @author jxilong@yiji.com
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 4118649684208935092L;

    private Long id;

    private String name;

    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
