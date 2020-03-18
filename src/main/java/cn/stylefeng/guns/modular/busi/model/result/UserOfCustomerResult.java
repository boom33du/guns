package cn.stylefeng.guns.modular.busi.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 用户客户对应表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class UserOfCustomerResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 客户表主键，外键
     */
    private Long customerinfoId;

    /**
     * 用户主键，该编号唯一，外键
     */
    private Long userId;

    //for page 查询显示用
    private String customerName;
    //for page 查询显示用
    private String userAccount;

}
