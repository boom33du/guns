package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 客户地址水表对应表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_address_of_customer_watermeter")
public class AddressOfCustomerWatermeter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属客户主键，外键
     */
    @TableField("CUSTOMERINFO_ID")
    private Long customerinfoId;

    /**
     * 客户地址主键，外键
     */
    @TableField("address_of_customer_id")
    private Long addressOfCustomerId;

    /**
     * 水表编号，该编号在该表中唯一，外键
     */
    @TableId(value = "WATERMETERINFO_ID", type = IdType.ID_WORKER)
    private Long watermeterinfoId;

    /**
     * 状态：1有效 0失效
     */
    @TableField("STATUS")
    private String status;

    /**
     * 绑定时间
     */
    @TableField("BEGINTIME")
    private Date begintime;

    /**
     * 失效时间
     */
    @TableField("ENDTIME")
    private Date endtime;

    /**
     * 操作历史记录
     */
    @TableField("TEMP")
    private String temp;


    public Long getCustomerinfoId() {
        return customerinfoId;
    }

    public void setCustomerinfoId(Long customerinfoId) {
        this.customerinfoId = customerinfoId;
    }

    public Long getAddressOfCustomerId() {
        return addressOfCustomerId;
    }

    public void setAddressOfCustomerId(Long addressOfCustomerId) {
        this.addressOfCustomerId = addressOfCustomerId;
    }

    public Long getWatermeterinfoId() {
        return watermeterinfoId;
    }

    public void setWatermeterinfoId(Long watermeterinfoId) {
        this.watermeterinfoId = watermeterinfoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "AddressOfCustomerWatermeter{" +
        "customerinfoId=" + customerinfoId +
        ", addressOfCustomerId=" + addressOfCustomerId +
        ", watermeterinfoId=" + watermeterinfoId +
        ", status=" + status +
        ", begintime=" + begintime +
        ", endtime=" + endtime +
        ", temp=" + temp +
        "}";
    }
}
