package cn.stylefeng.guns.modular.rec.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 水表上报数据表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class ReportdataParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 设备ID，电信云平台的标志号
     */
    private String deviceid;

    /**
     * 厂商ID
     */
    private String manuid;

    /**
     * 水表号
     */
    private String serialnum;

    /**
     * 用水总量
     */
    private String accumuflowdaily;

    /**
     * 剩余电量
     */
    private String batterylevel;

    /**
     * 发送时间上半部分
     */
    private String timeu;

    /**
     * 发送时间下半部分
     */
    private String timed;

    /**
     * 校验码
     */
    private String checksum;

    /**
     * 应用系统接收时间
     */
    private Date receivetime;

    /**
     * 事件时间，来自电信云
     */
    private String eventtime;

    /**
     * 备注
     */
    private String temp;

    @Override
    public String checkParam() {
        return null;
    }

}
