/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-20 14:22 创建
 *
 */
package hibernate.xml.relation.many2one;

import com.yjf.common.util.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jxilong@yiji.com
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -395390483115965097L;

    private Long id;

    private String name;

    private Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
