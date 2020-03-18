package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户客户对应表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_user_of_customer")
public class UserOfCustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户表主键，外键
     */
    @TableField("CUSTOMERINFO_ID")
    private Long customerinfoId;

    /**
     * 用户主键，该编号唯一，外键
     */
    @TableId(value = "USER_ID", type = IdType.ID_WORKER)
    private Long userId;



    public Long getCustomerinfoId() {
        return customerinfoId;
    }

    public void setCustomerinfoId(Long customerinfoId) {
        this.customerinfoId = customerinfoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserOfCustomer{" +
        "customerinfoId=" + customerinfoId +
        ", userId=" + userId +
        "}";
    }
}
