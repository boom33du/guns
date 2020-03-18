package cn.stylefeng.guns.modular.busi.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户居民账单_缴费记录表(后付)
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class PostPaymentRecoredParam implements Serializable, BaseValidatingParam {

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
     * 月结明细表id，外键
     */
    private Long monthlyStatementDetailId;

    /**
     * 给水号（不可修改）
     */
    private String wmWaterSupplyNumber;

    /**
     * 当前价格
     */
    private Double price;

    /**
     * 本周期用水量
     */
    private Double waterconsume;

    /**
     * 发生金额，根据月结生成
     */
    private Double TOTALconsume;

    /**
     * 费用开始时间
     */
    private Date begintime;

    /**
     * 费用结束时间
     */
    private Date endtime;

    /**
     * 费用开始水表读数
     */
    private Double watermeterbeginrecord;

    /**
     * 费用结束水表读数
     */
    private Double watermeterendrecord;

    /**
     * 缴费时间
     */
    private Date payTime;

    /**
     * 缴费渠道（0微信、1支付宝、2银行卡、3前台）
     */
    private String PaymentChannel;

    /**
     * 交易明细id，交费明细表主键，外键
     */
    private Long paymentDetailId;

    /**
     * 是否完成 0未完成 1完成，默认0
     */
    private String isfinish;

    /**
     * 操作人，用户表主键，外键
     */
    private Long operid;

    /**
     * 操作时间
     */
    private Date opertime;

    @Override
    public String checkParam() {
        return null;
    }

}
