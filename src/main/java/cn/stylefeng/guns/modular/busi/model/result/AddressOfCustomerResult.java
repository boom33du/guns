package cn.stylefeng.guns.modular.busi.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户地址表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class AddressOfCustomerResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 所属客户主键，外键
     */
    private Long customerinfoId;

    /**
     * 地址内容
     */
    private String addresscontent;

    /**
     * 地址类型主键，外键
     */
    private Long addresstypeId;

    /**
     * 备注
     */
    private String temp;

}
