/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-24 21:13 创建
 *
 */
package jpa.entities.bank;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
@MappedSuperclass
public abstract  class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="raw_add_time",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rawAddTime;

    @Column(name="raw_update_time",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rawUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRawAddTime() {
        return rawAddTime;
    }

    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }
}
