package cn.stylefeng.guns.modular.wtmm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 生产厂商表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("wtmm_manufacturer")
public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 生产厂商编码
     */
    @TableField("MANUFACTURERCODE")
    private String manufacturercode;

    /**
     * 生产厂商名称
     */
    @TableField("MANUFACTURER")
    private String manufacturer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturercode() {
        return manufacturercode;
    }

    public void setManufacturercode(String manufacturercode) {
        this.manufacturercode = manufacturercode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
        "id=" + id +
        ", manufacturercode=" + manufacturercode +
        ", manufacturer=" + manufacturer +
        "}";
    }
}
