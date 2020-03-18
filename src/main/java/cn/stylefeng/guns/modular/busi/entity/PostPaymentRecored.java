package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 客户居民账单_缴费记录表(后付)
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_post_payment_recored")
public class PostPaymentRecored implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 客户地址id，外键
     */
    @TableField("address_of_customer_id")
    private Long addressOfCustomerId;

    /**
     * 月结明细表id，外键
     */
    @TableField("monthly_statement_detail_id")
    private Long monthlyStatementDetailId;

    /**
     * 给水号（不可修改）
     */
    @TableField("WM_WATER_SUPPLY_NUMBER")
    private String wmWaterSupplyNumber;

    /**
     * 当前价格
     */
    @TableField("PRICE")
    private Double price;

    /**
     * 本周期用水量
     */
    @TableField("WATERCONSUME")
    private Double waterconsume;

    /**
     * 发生金额，根据月结生成
     */
    @TableField("TOTALconsume")
    private Double TOTALconsume;

    /**
     * 费用开始时间
     */
    @TableField("BEGINTIME")
    private Date begintime;

    /**
     * 费用结束时间
     */
    @TableField("ENDTIME")
    private Date endtime;

    /**
     * 费用开始水表读数
     */
    @TableField("watermeterbeginrecord")
    private Double watermeterbeginrecord;

    /**
     * 费用结束水表读数
     */
    @TableField("watermeterendrecord")
    private Double watermeterendrecord;

    /**
     * 缴费时间
     */
    @TableField("payTime")
    private Date payTime;

    /**
     * 缴费渠道（0微信、1支付宝、2银行卡、3前台）
     */
    @TableField("PaymentChannel")
    private String PaymentChannel;

    /**
     * 交易明细id，交费明细表主键，外键
     */
    @TableField("payment_Detail_Id")
    private Long paymentDetailId;

    /**
     * 是否完成 0未完成 1完成，默认0
     */
    @TableField("isfinish")
    private String isfinish;

    /**
     * 操作人，用户表主键，外键
     */
    @TableField("OPERID")
    private Long operid;

    /**
     * 操作时间
     */
    @TableField("opertime")
    private Date opertime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressOfCustomerId() {
        return addressOfCustomerId;
    }

    public void setAddressOfCustomerId(Long addressOfCustomerId) {
        this.addressOfCustomerId = addressOfCustomerId;
    }

    public Long getMonthlyStatementDetailId() {
        return monthlyStatementDetailId;
    }

    public void setMonthlyStatementDetailId(Long monthlyStatementDetailId) {
        this.monthlyStatementDetailId = monthlyStatementDetailId;
    }

    public String getWmWaterSupplyNumber() {
        return wmWaterSupplyNumber;
    }

    public void setWmWaterSupplyNumber(String wmWaterSupplyNumber) {
        this.wmWaterSupplyNumber = wmWaterSupplyNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWaterconsume() {
        return waterconsume;
    }

    public void setWaterconsume(Double waterconsume) {
        this.waterconsume = waterconsume;
    }

    public Double getTOTALconsume() {
        return TOTALconsume;
    }

    public void setTOTALconsume(Double TOTALconsume) {
        this.TOTALconsume = TOTALconsume;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Double getWatermeterbeginrecord() {
        return watermeterbeginrecord;
    }

    public void setWatermeterbeginrecord(Double watermeterbeginrecord) {
        this.watermeterbeginrecord = watermeterbeginrecord;
    }

    public Double getWatermeterendrecord() {
        return watermeterendrecord;
    }

    public void setWatermeterendrecord(Double watermeterendrecord) {
        this.watermeterendrecord = watermeterendrecord;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPaymentChannel() {
        return PaymentChannel;
    }

    public void setPaymentChannel(String PaymentChannel) {
        this.PaymentChannel = PaymentChannel;
    }

    public Long getPaymentDetailId() {
        return paymentDetailId;
    }

    public void setPaymentDetailId(Long paymentDetailId) {
        this.paymentDetailId = paymentDetailId;
    }

    public String getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(String isfinish) {
        this.isfinish = isfinish;
    }

    public Long getOperid() {
        return operid;
    }

    public void setOperid(Long operid) {
        this.operid = operid;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    @Override
    public String toString() {
        return "PostPaymentRecored{" +
        "id=" + id +
        ", addressOfCustomerId=" + addressOfCustomerId +
        ", monthlyStatementDetailId=" + monthlyStatementDetailId +
        ", wmWaterSupplyNumber=" + wmWaterSupplyNumber +
        ", price=" + price +
        ", waterconsume=" + waterconsume +
        ", TOTALconsume=" + TOTALconsume +
        ", begintime=" + begintime +
        ", endtime=" + endtime +
        ", watermeterbeginrecord=" + watermeterbeginrecord +
        ", watermeterendrecord=" + watermeterendrecord +
        ", payTime=" + payTime +
        ", PaymentChannel=" + PaymentChannel +
        ", paymentDetailId=" + paymentDetailId +
        ", isfinish=" + isfinish +
        ", operid=" + operid +
        ", opertime=" + opertime +
        "}";
    }
}
