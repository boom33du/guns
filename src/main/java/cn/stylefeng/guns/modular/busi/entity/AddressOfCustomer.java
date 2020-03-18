package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 客户地址表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_address_of_customer")
public class AddressOfCustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 所属客户主键，外键
     */
    @TableField("CUSTOMERINFO_ID")
    private Long customerinfoId;

    /**
     * 地址内容
     */
    @TableField("ADDRESSCONTENT")
    private String addresscontent;

    /**
     * 地址类型主键，外键
     */
    @TableField("ADDRESSTYPE_ID")
    private Long addresstypeId;

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

    public Long getCustomerinfoId() {
        return customerinfoId;
    }

    public void setCustomerinfoId(Long customerinfoId) {
        this.customerinfoId = customerinfoId;
    }

    public String getAddresscontent() {
        return addresscontent;
    }

    public void setAddresscontent(String addresscontent) {
        this.addresscontent = addresscontent;
    }

    public Long getAddresstypeId() {
        return addresstypeId;
    }

    public void setAddresstypeId(Long addresstypeId) {
        this.addresstypeId = addresstypeId;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "AddressOfCustomer{" +
        "id=" + id +
        ", customerinfoId=" + customerinfoId +
        ", addresscontent=" + addresscontent +
        ", addresstypeId=" + addresstypeId +
        ", temp=" + temp +
        "}";
    }
}
