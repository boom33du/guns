package cn.stylefeng.guns.modular.wtmm.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 水表硬件信息登记表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class WatermeterinfoParam implements Serializable, BaseValidatingParam {

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
     * 水表类型主键，外键
     */
    private Long watermetertypeId;

    /**
     * 网关ID
     */
    private String gatewayid;

    /**
     * 事件时间，来自电信云
     */
    private String eventtime;

    /**
     * 厂商ID
     */
    private String manuid;

    /**
     * 水表号
     */
    private String serialnum;

    /**
     * 用水总量，小数点后8位
     */
    private BigDecimal accumuflowdaily;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 固件版本号
     */
    private String firewareVersion;

    /**
     * 状态 0新添加，未激活 1激活，未绑定 2激活，绑定了 3删除了；4损坏；5欠费
     */
    private Long status;

    /**
     * 剩余电量
     */
    private Double electricquantityLeft;

    /**
     * 生产日期
     */
    private Date dateManufacture;

    /**
     * NB-IOT芯片ID
     */
    private Long nbiotId;

    /**
     * 安装日期
     */
    private Date dateInstall;

    /**
     * 停用日期
     */
    private Date dateDiscontinuation;

    /**
     * 备注（水表用户ID）
     */
    private String temp;

    @Override
    public String checkParam() {
        return null;
    }

}
