package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 客户水表对应表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_customer_watermeter")
public class CustomerWatermeter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户表主键，外键
     */
    @TableField("CUSTOMERINFO_ID")
    private Long customerinfoId;

    /**
     * 水表编号，该编号唯一，外键
     */
    @TableId(value = "WATERMETERINFO_ID", type = IdType.ID_WORKER)
    private Long watermeterinfoId;


    public Long getCustomerinfoId() {
        return customerinfoId;
    }

    public void setCustomerinfoId(Long customerinfoId) {
        this.customerinfoId = customerinfoId;
    }

    public Long getWatermeterinfoId() {
        return watermeterinfoId;
    }

    public void setWatermeterinfoId(Long watermeterinfoId) {
        this.watermeterinfoId = watermeterinfoId;
    }

    @Override
    public String toString() {
        return "CustomerWatermeter{" +
        "customerinfoId=" + customerinfoId +
        ", watermeterinfoId=" + watermeterinfoId +
        "}";
    }
}
