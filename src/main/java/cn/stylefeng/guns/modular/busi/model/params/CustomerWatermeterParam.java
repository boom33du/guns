package cn.stylefeng.guns.modular.busi.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户水表对应表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class CustomerWatermeterParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 客户表主键，外键
     */
    private Long customerinfoId;

    /**
     * 水表编号，该编号唯一，外键
     */
    private Long watermeterinfoId;

    @Override
    public String checkParam() {
        return null;
    }

}
