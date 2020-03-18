package cn.stylefeng.guns.modular.busi.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户地址水表对应表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class AddressOfCustomerWatermeterResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 所属客户主键，外键
     */
    private Long customerinfoId;

    /**
     * 客户地址主键，外键
     */
    private Long addressOfCustomerId;

    /**
     * 水表编号，该编号在该表中唯一，外键
     */
    private Long watermeterinfoId;

    /**
     * 状态：1有效 0失效
     */
    private String status;

    /**
     * 绑定时间
     */
    private Date begintime;

    /**
     * 失效时间
     */
    private Date endtime;

    /**
     * 操作历史记录
     */
    private String temp;

}
