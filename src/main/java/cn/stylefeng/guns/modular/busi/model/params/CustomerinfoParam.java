package cn.stylefeng.guns.modular.busi.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户信息表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class CustomerinfoParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 客户名称
     */
    private String customername;

    /**
     * 客户编号，根据一定规则设置
     */
    private String customercode;

    /**
     * 创建人，将系统当前用户录入
     */
    private String creator;

    /**
     * 创建时间，将系统当前时间录入
     */
    private Date creattime;

    /**
     * 购买水表数量，分配水表时更新该字段
     */
    private Integer watermetercount;

    /**
     * 备注
     */
    private String temp;

    private String condition;

    @Override
    public String checkParam() {
        return null;
    }

}
