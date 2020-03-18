package cn.stylefeng.guns.modular.wtmm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 水表型号表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("wtmm_type_of_watermeter")
public class TypeOfWatermeter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 型号
     */
    @TableField("WATERMETER_TYPE")
    private String watermeterType;

    /**
     * 口径
     */
    @TableField("CALIBER")
    private String caliber;

    /**
     * 是否带阀0不带阀 1 带阀
     */
    @TableField("ISHAVEVALVE")
    private String ishavevalve;

    /**
     * 是否是NB-IOT表 0 不是 1是
     */
    @TableField("ISNBIOT")
    private String isnbiot;

    /**
     * 通信协议
     */
    @TableField("PROTOCOL")
    private String protocol;

    /**
     * 生产厂商代码
     */
    @TableField("MANUFACTURERCODE")
    private String manufacturercode;

    /**
     * 生产厂商
     */
    @TableField("MANUFACTURER")
    private String manufacturer;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWatermeterType() {
        return watermeterType;
    }

    public void setWatermeterType(String watermeterType) {
        this.watermeterType = watermeterType;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getIshavevalve() {
        return ishavevalve;
    }

    public void setIshavevalve(String ishavevalve) {
        this.ishavevalve = ishavevalve;
    }

    public String getIsnbiot() {
        return isnbiot;
    }

    public void setIsnbiot(String isnbiot) {
        this.isnbiot = isnbiot;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
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
        return "TypeOfWatermeter{" +
        "id=" + id +
        ", watermeterType=" + watermeterType +
        ", caliber=" + caliber +
        ", ishavevalve=" + ishavevalve +
        ", isnbiot=" + isnbiot +
        ", protocol=" + protocol +
        ", manufacturercode=" + manufacturercode +
        ", manufacturer=" + manufacturer +
        "}";
    }
}
