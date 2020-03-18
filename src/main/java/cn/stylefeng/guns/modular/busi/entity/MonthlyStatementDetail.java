package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 月结明细表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_monthly_statement_detail")
public class MonthlyStatementDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 月结记录表主键，外键
     */
    @TableField("record_id")
    private Long recordId;

    /**
     * 客户地址id，外键
     */
    @TableField("address_of_customer_id")
    private Long addressOfCustomerId;

    /**
     * 水表ID（包含生产商等信息）
     */
    @TableField("WM_ID")
    private String wmId;

    /**
     * 地址类型主键，外键
     */
    @TableField("address_TYPE_id")
    private Long addressTypeId;

    /**
     * 年份
     */
    @TableField("YEAR")
    private String year;

    /**
     * 月份
     */
    @TableField("MONTH")
    private String month;

    /**
     * 上次月结ID，本表主键
     */
    @TableField("LASTRECORDid")
    private Long LASTRECORDid;

    /**
     * 月结时间
     */
    @TableField("RECORDTIME")
    private Date recordtime;

    /**
     * 当前水表读数
     */
    @TableField("CURRESULT")
    private Double curresult;

    /**
     * 当前用水总量默认0
     */
    @TableField("TOTAL_WATER_L")
    private Double totalWaterL;

    /**
     * 本周期用水量
     */
    @TableField("WATERCONSUME")
    private Double waterconsume;

    /**
     * 月结记录，记录异常情况
     */
    @TableField("DETAIL")
    private String detail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getAddressOfCustomerId() {
        return addressOfCustomerId;
    }

    public void setAddressOfCustomerId(Long addressOfCustomerId) {
        this.addressOfCustomerId = addressOfCustomerId;
    }

    public String getWmId() {
        return wmId;
    }

    public void setWmId(String wmId) {
        this.wmId = wmId;
    }

    public Long getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Long addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getLASTRECORDid() {
        return LASTRECORDid;
    }

    public void setLASTRECORDid(Long LASTRECORDid) {
        this.LASTRECORDid = LASTRECORDid;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public Double getCurresult() {
        return curresult;
    }

    public void setCurresult(Double curresult) {
        this.curresult = curresult;
    }

    public Double getTotalWaterL() {
        return totalWaterL;
    }

    public void setTotalWaterL(Double totalWaterL) {
        this.totalWaterL = totalWaterL;
    }

    public Double getWaterconsume() {
        return waterconsume;
    }

    public void setWaterconsume(Double waterconsume) {
        this.waterconsume = waterconsume;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MonthlyStatementDetail{" +
        "id=" + id +
        ", recordId=" + recordId +
        ", addressOfCustomerId=" + addressOfCustomerId +
        ", wmId=" + wmId +
        ", addressTypeId=" + addressTypeId +
        ", year=" + year +
        ", month=" + month +
        ", LASTRECORDid=" + LASTRECORDid +
        ", recordtime=" + recordtime +
        ", curresult=" + curresult +
        ", totalWaterL=" + totalWaterL +
        ", waterconsume=" + waterconsume +
        ", detail=" + detail +
        "}";
    }
}
