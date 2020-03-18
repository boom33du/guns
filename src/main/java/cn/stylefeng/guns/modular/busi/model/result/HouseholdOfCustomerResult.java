package cn.stylefeng.guns.modular.busi.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户居民用户表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class HouseholdOfCustomerResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 客户地址id，外键
     */
    private Long addressOfCustomerId;

    /**
     * 给水号
     */
    private String wmWaterSupplyNumber;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String district;

    /**
     * 街道
     */
    private String street;

    /**
     * 小区
     */
    private String community;

    /**
     * 客户主键，外键
     */
    private Long customerinfoId;

    /**
     * 详细地址
     */
    private String detailAddress;

    /**
     * 户主姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobilePhoneNumber;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 年度剩余水量默认0
     */
    private Double curLeftWaterL;

    /**
     * 总量默认0
     */
    private Double totalWaterL;

    /**
     * 当前水表读数默认0
     */
    private Double curWmNumber;

    /**
     * 水费余额默认0，小数点后2位
     */
    private Double moneyLeft;

    /**
     * 最新读取水表数据时间
     */
    private Date lastReadTime;

    /**
     * 用水类别，默认0（0居民、1非居民等）
     */
    private String usageType;

    /**
     * 类型，0后付费，1预付费
     */
    private String paymenttype;

    /**
     * 阶梯水价规则（默认一户4人）
     */
    private Long staircaseWaterPriceId;

    /**
     * 状态：0 正常；1删除
     */
    private String status;

}
