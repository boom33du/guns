package cn.stylefeng.guns.modular.wtmm.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 水表型号表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class TypeOfWatermeterResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 型号
     */
    private String watermeterType;

    /**
     * 口径
     */
    private String caliber;

    /**
     * 是否带阀0不带阀 1 带阀
     */
    private String ishavevalve;

    /**
     * 是否是NB-IOT表 0 不是 1是
     */
    private String isnbiot;

    /**
     * 通信协议
     */
    private String protocol;

    /**
     * 生产厂商代码
     */
    private String manufacturercode;

    /**
     * 生产厂商
     */
    private String manufacturer;

}
