package cn.stylefeng.guns.modular.busi.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 月结记录表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class MonthlyStatementRecordParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 年份
     */
    private String year;

    /**
     * 月份
     */
    private String month;

    /**
     * 月结时间
     */
    private Date recordtime;

    /**
     * 操作人，用户表主键，外键
     */
    private Long operid;

    /**
     * 开始时间
     */
    private Date begintime;

    /**
     * 结束时间
     */
    private Date endtime;

    /**
     * 月结用户数
     */
    private Integer allcount;

    /**
     * 月结成功用户数
     */
    private Integer succount;

    /**
     * 月结记录，记录异常情况
     */
    private String detail;

    @Override
    public String checkParam() {
        return null;
    }

}
