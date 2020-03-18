package cn.stylefeng.guns.modular.wtmm.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 生产厂商表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class ManufacturerResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 生产厂商编码
     */
    private String manufacturercode;

    /**
     * 生产厂商名称
     */
    private String manufacturer;

}
