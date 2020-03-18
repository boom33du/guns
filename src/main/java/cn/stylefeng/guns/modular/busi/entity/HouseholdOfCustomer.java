package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 客户居民用户表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_household_of_customer")
public class HouseholdOfCustomer implements Serializable {

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
     * 给水号
     */
    @TableField("WM_WATER_SUPPLY_NUMBER")
    private String wmWaterSupplyNumber;

    /**
     * 省
     */
    @TableField("PROVINCE")
    private String province;

    /**
     * 市
     */
    @TableField("CITY")
    private String city;

    /**
     * 县
     */
    @TableField("DISTRICT")
    private String district;

    /**
     * 街道
     */
    @TableField("STREET")
    private String street;

    /**
     * 小区
     */
    @TableField("COMMUNITY")
    private String community;

    /**
     * 客户主键，外键
     */
    @TableField("CUSTOMERINFO_ID")
    private Long customerinfoId;

    /**
     * 详细地址
     */
    @TableField("DETAIL_ADDRESS")
    private String detailAddress;

    /**
     * 户主姓名
     */
    @TableField("REAL_NAME")
    private String realName;

    /**
     * 手机号
     */
    @TableField("MOBILE_PHONE_NUMBER")
    private String mobilePhoneNumber;

    /**
     * 身份证号
     */
    @TableField("ID_NUMBER")
    private String idNumber;

    /**
     * 年度剩余水量默认0
     */
    @TableField("CUR_LEFT_WATER_L")
    private Double curLeftWaterL;

    /**
     * 总量默认0
     */
    @TableField("TOTAL_WATER_L")
    private Double totalWaterL;

    /**
     * 当前水表读数默认0
     */
    @TableField("CUR_WM_NUMBER")
    private Double curWmNumber;

    /**
     * 水费余额默认0，小数点后2位
     */
    @TableField("MONEY_LEFT")
    private Double moneyLeft;

    /**
     * 最新读取水表数据时间
     */
    @TableField("LAST_READ_TIME")
    private Date lastReadTime;

    /**
     * 用水类别，默认0（0居民、1非居民等）
     */
    @TableField("USAGE_TYPE")
    private String usageType;

    /**
     * 类型，0后付费，1预付费
     */
    @TableField("PAYMENTTYPE")
    private String paymenttype;

    /**
     * 阶梯水价规则（默认一户4人）
     */
    @TableField("STAIRCASE_WATER_PRICE_ID")
    private Long staircaseWaterPriceId;

    /**
     * 状态：0 正常；1删除
     */
    @TableField("STATUS")
    private String status;


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

    public String getWmWaterSupplyNumber() {
        return wmWaterSupplyNumber;
    }

    public void setWmWaterSupplyNumber(String wmWaterSupplyNumber) {
        this.wmWaterSupplyNumber = wmWaterSupplyNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Long getCustomerinfoId() {
        return customerinfoId;
    }

    public void setCustomerinfoId(Long customerinfoId) {
        this.customerinfoId = customerinfoId;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Double getCurLeftWaterL() {
        return curLeftWaterL;
    }

    public void setCurLeftWaterL(Double curLeftWaterL) {
        this.curLeftWaterL = curLeftWaterL;
    }

    public Double getTotalWaterL() {
        return totalWaterL;
    }

    public void setTotalWaterL(Double totalWaterL) {
        this.totalWaterL = totalWaterL;
    }

    public Double getCurWmNumber() {
        return curWmNumber;
    }

    public void setCurWmNumber(Double curWmNumber) {
        this.curWmNumber = curWmNumber;
    }

    public Double getMoneyLeft() {
        return moneyLeft;
    }

    public void setMoneyLeft(Double moneyLeft) {
        this.moneyLeft = moneyLeft;
    }

    public Date getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(Date lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Long getStaircaseWaterPriceId() {
        return staircaseWaterPriceId;
    }

    public void setStaircaseWaterPriceId(Long staircaseWaterPriceId) {
        this.staircaseWaterPriceId = staircaseWaterPriceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HouseholdOfCustomer{" +
        "id=" + id +
        ", addressOfCustomerId=" + addressOfCustomerId +
        ", wmWaterSupplyNumber=" + wmWaterSupplyNumber +
        ", province=" + province +
        ", city=" + city +
        ", district=" + district +
        ", street=" + street +
        ", community=" + community +
        ", customerinfoId=" + customerinfoId +
        ", detailAddress=" + detailAddress +
        ", realName=" + realName +
        ", mobilePhoneNumber=" + mobilePhoneNumber +
        ", idNumber=" + idNumber +
        ", curLeftWaterL=" + curLeftWaterL +
        ", totalWaterL=" + totalWaterL +
        ", curWmNumber=" + curWmNumber +
        ", moneyLeft=" + moneyLeft +
        ", lastReadTime=" + lastReadTime +
        ", usageType=" + usageType +
        ", paymenttype=" + paymenttype +
        ", staircaseWaterPriceId=" + staircaseWaterPriceId +
        ", status=" + status +
        "}";
    }
}
