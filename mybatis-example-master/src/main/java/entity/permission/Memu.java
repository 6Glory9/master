/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-05 12:06 创建
 *
 */
package entity.permission;

import com.yjf.common.util.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 * @author jxilong@yiji.com
 */
public class Memu  implements Serializable{

    private static final long serialVersionUID = 713761868981796504L;

    private Long id;

    private Memu parent;

    private Set<Memu> childs;

    private String memuName;

    private String rawAddTime;

    private String rawUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Memu getParent() {
        return parent;
    }

    public void setParent(Memu parent) {
        this.parent = parent;
    }

    public Set<Memu> getChilds() {
        return childs;
    }

    public void setChilds(Set<Memu> childs) {
        this.childs = childs;
    }

    public String getMemuName() {
        return memuName;
    }

    public void setMemuName(String memuName) {
        this.memuName = memuName;
    }

    public String getRawAddTime() {
        return rawAddTime;
    }

    public void setRawAddTime(String rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    public String getRawUpdateTime() {
        return rawUpdateTime;
    }

    public void setRawUpdateTime(String rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
