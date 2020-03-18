package cn.stylefeng.guns.modular.busi.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户水表对应表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class CustomerWatermeterResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 客户表主键，外键
     */
    private Long customerinfoId;

    /**
     * 水表编号，该编号唯一，外键
     */
    private Long watermeterinfoId;

    //for page 查询显示用
    private String waterMeterDeviceId;
    //for page 查询显示用
    private String customerinfoName;

}
