package cn.stylefeng.guns.modular.wtmm.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 水表硬件信息登记表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("wtmm_watermeterinfo")
public class Watermeterinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 设备ID，电信云平台的标志号
     */
    @TableField("DEVICEID")
    private String deviceid;

    /**
     * 水表类型主键，外键
     */
    @TableField("WATERMETERTYPE_ID")
    private Long watermetertypeId;

    /**
     * 网关ID
     */
    @TableField("GATEWAYID")
    private String gatewayid;

    /**
     * 事件时间，来自电信云
     */
    @TableField("EVENTTIME")
    private String eventtime;

    /**
     * 厂商ID
     */
    @TableField("MANUID")
    private String manuid;

    /**
     * 水表号
     */
    @TableField("SERIALNUM")
    private String serialnum;

    /**
     * 用水总量，小数点后8位
     */
    @TableField("ACCUMUFLOWDAILY")
    private BigDecimal accumuflowdaily;

    /**
     * 更新时间
     */
    @TableField("UPDATETIME")
    private Date updatetime;

    /**
     * 固件版本号
     */
    @TableField("FIREWARE_VERSION")
    private String firewareVersion;

    /**
     * 状态 0新添加，未激活 1激活，未绑定 2激活，绑定了 3删除了；4损坏；5欠费
     */
    @TableField("STATUS")
    private Long status;

    /**
     * 剩余电量
     */
    @TableField("ELECTRICQUANTITY_LEFT")
    private Double electricquantityLeft;

    /**
     * 生产日期
     */
    @TableField("DATE_MANUFACTURE")
    private Date dateManufacture;

    /**
     * NB-IOT芯片ID
     */
    @TableField("NBIOT_ID")
    private Long nbiotId;

    /**
     * 安装日期
     */
    @TableField("DATE_INSTALL")
    private Date dateInstall;

    /**
     * 停用日期
     */
    @TableField("DATE_DISCONTINUATION")
    private Date dateDiscontinuation;

    /**
     * 备注（水表用户ID）
     */
    @TableField("TEMP")
    private String temp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public Long getWatermetertypeId() {
        return watermetertypeId;
    }

    public void setWatermetertypeId(Long watermetertypeId) {
        this.watermetertypeId = watermetertypeId;
    }

    public String getGatewayid() {
        return gatewayid;
    }

    public void setGatewayid(String gatewayid) {
        this.gatewayid = gatewayid;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getManuid() {
        return manuid;
    }

    public void setManuid(String manuid) {
        this.manuid = manuid;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    public BigDecimal getAccumuflowdaily() {
        return accumuflowdaily;
    }

    public void setAccumuflowdaily(BigDecimal accumuflowdaily) {
        this.accumuflowdaily = accumuflowdaily;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getFirewareVersion() {
        return firewareVersion;
    }

    public void setFirewareVersion(String firewareVersion) {
        this.firewareVersion = firewareVersion;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Double getElectricquantityLeft() {
        return electricquantityLeft;
    }

    public void setElectricquantityLeft(Double electricquantityLeft) {
        this.electricquantityLeft = electricquantityLeft;
    }

    public Date getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(Date dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    public Long getNbiotId() {
        return nbiotId;
    }

    public void setNbiotId(Long nbiotId) {
        this.nbiotId = nbiotId;
    }

    public Date getDateInstall() {
        return dateInstall;
    }

    public void setDateInstall(Date dateInstall) {
        this.dateInstall = dateInstall;
    }

    public Date getDateDiscontinuation() {
        return dateDiscontinuation;
    }

    public void setDateDiscontinuation(Date dateDiscontinuation) {
        this.dateDiscontinuation = dateDiscontinuation;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Watermeterinfo{" +
        "id=" + id +
        ", deviceid=" + deviceid +
        ", watermetertypeId=" + watermetertypeId +
        ", gatewayid=" + gatewayid +
        ", eventtime=" + eventtime +
        ", manuid=" + manuid +
        ", serialnum=" + serialnum +
        ", accumuflowdaily=" + accumuflowdaily +
        ", updatetime=" + updatetime +
        ", firewareVersion=" + firewareVersion +
        ", status=" + status +
        ", electricquantityLeft=" + electricquantityLeft +
        ", dateManufacture=" + dateManufacture +
        ", nbiotId=" + nbiotId +
        ", dateInstall=" + dateInstall +
        ", dateDiscontinuation=" + dateDiscontinuation +
        ", temp=" + temp +
        "}";
    }
}
