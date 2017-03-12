/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-24 21:32 创建
 *
 */
package jpa.entities.bank;

import com.yjf.common.util.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
@Entity
@Table(name = "t_id_card")
public class IdCard  extends BaseEntity {

    @Column(name="ral_name",nullable = false,length = 128)
    private String realName;

    @Column(name="cert_no",nullable = false,length = 18)
    private String certNo;

    @Column(name="cert_start_Date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date certStartDate;

    //null 表示长期
    @Column(name="cert_end_Date")
    @Temporal(TemporalType.DATE)
    private Date certEndDate;

    @Column(name="cert_address",nullable = false,length = 128)
    private String certAddress;

    @Column(name="cert_url",length = 128)
    private String certURL;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name="cert_img", columnDefinition="BLOB NOT NULL")
    private byte[] certImg;

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
