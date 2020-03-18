package cn.stylefeng.guns.modular.busi.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
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
public class UserOfCustomerParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 客户表主键，外键
     */
    private Long customerinfoId;

    /**
     * 用户主键，该编号唯一，外键
     */
    private Long userId;


    @Override
    public String checkParam() {
        return null;
    }

}
