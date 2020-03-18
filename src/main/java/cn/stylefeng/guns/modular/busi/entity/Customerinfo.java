package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 客户信息表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_customerinfo")
public class Customerinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 客户名称
     */
    @TableField("CUSTOMERNAME")
    private String customername;

    /**
     * 客户编号，根据一定规则设置
     */
    @TableField("CUSTOMERCODE")
    private String customercode;

    /**
     * 创建人，将系统当前用户录入
     */
    @TableField("CREATOR")
    private String creator;

    /**
     * 创建时间，将系统当前时间录入
     */
    @TableField("CREATTIME")
    private Date creattime;

    /**
     * 购买水表数量，分配水表时更新该字段
     */
    @TableField("WATERMETERCOUNT")
    private Integer watermetercount;

    /**
     * 备注
     */
    @TableField("TEMP")
    private String temp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomercode() {
        return customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Integer getWatermetercount() {
        return watermetercount;
    }

    public void setWatermetercount(Integer watermetercount) {
        this.watermetercount = watermetercount;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Customerinfo{" +
        "id=" + id +
        ", customername=" + customername +
        ", customercode=" + customercode +
        ", creator=" + creator +
        ", creattime=" + creattime +
        ", watermetercount=" + watermetercount +
        ", temp=" + temp +
        "}";
    }
}
