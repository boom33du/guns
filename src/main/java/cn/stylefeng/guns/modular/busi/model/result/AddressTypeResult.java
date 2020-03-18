package cn.stylefeng.guns.modular.busi.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 地址类型表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class AddressTypeResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 地址类型,如：公司、子公司、小区、楼（幢）、单元、户等
     */
    private String addresstypecontent;

    /**
     * 级别，1开始，数字越低，等级越高，等级低的地址可以包含在等级高的地址中，反之不可以
     */
    private Integer scale;

    /**
     * 备注
     */
    private String temp;

}
