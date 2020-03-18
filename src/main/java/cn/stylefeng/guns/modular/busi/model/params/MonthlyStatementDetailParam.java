package cn.stylefeng.guns.modular.busi.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 月结明细表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class MonthlyStatementDetailParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 月结记录表主键，外键
     */
    private Long recordId;

    /**
     * 客户地址id，外键
     */
    private Long addressOfCustomerId;

    /**
     * 水表ID（包含生产商等信息）
     */
    private String wmId;

    /**
     * 地址类型主键，外键
     */
    private Long addressTypeId;

    /**
     * 年份
     */
    private String year;

    /**
     * 月份
     */
    private String month;

    /**
     * 上次月结ID，本表主键
     */
    private Long LASTRECORDid;

    /**
     * 月结时间
     */
    private Date recordtime;

    /**
     * 当前水表读数
     */
    private Double curresult;

    /**
     * 当前用水总量默认0
     */
    private Double totalWaterL;

    /**
     * 本周期用水量
     */
    private Double waterconsume;

    /**
     * 月结记录，记录异常情况
     */
    private String detail;

    @Override
    public String checkParam() {
        return null;
    }

}
