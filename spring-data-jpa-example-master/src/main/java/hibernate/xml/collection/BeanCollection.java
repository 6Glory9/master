/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-20 13:45 创建
 *
 */
package hibernate.xml.collection;

import com.yjf.common.util.ToString;

import java.io.Serializable;
import java.util.*;

/**
 * @author jxilong@yiji.com
 */
public class BeanCollection implements Serializable {
    private static final long serialVersionUID = -8165636150731105452L;

    private Integer id;

    private String userName;

    private Set<String> addressSet = new HashSet<>();

    private List<String> addressList = new ArrayList<>();

    private Map<String, String> addressMap = new HashMap<>();

    private String[] adddressArray;

    private List<String> addressBag  =   new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<String> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<String> addressSet) {
        this.addressSet = addressSet;
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public Map<String, String> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<String, String> addressMap) {
        this.addressMap = addressMap;
    }

    public String[] getAdddressArray() {
        return adddressArray;
    }

    public void setAdddressArray(String[] adddressArray) {
        this.adddressArray = adddressArray;
    }

    public List<String> getAddressBag() {
        return addressBag;
    }

    public void setAddressBag(List<String> addressBag) {
        this.addressBag = addressBag;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
