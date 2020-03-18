package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 地址类型表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_address_type")
public class AddressType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 地址类型,如：公司、子公司、小区、楼（幢）、单元、户等
     */
    @TableField("ADDRESSTYPECONTENT")
    private String addresstypecontent;

    /**
     * 级别，1开始，数字越低，等级越高，等级低的地址可以包含在等级高的地址中，反之不可以
     */
    @TableField("SCALE")
    private Integer scale;

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

    public String getAddresstypecontent() {
        return addresstypecontent;
    }

    public void setAddresstypecontent(String addresstypecontent) {
        this.addresstypecontent = addresstypecontent;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "AddressType{" +
        "id=" + id +
        ", addresstypecontent=" + addresstypecontent +
        ", scale=" + scale +
        ", temp=" + temp +
        "}";
    }
}
