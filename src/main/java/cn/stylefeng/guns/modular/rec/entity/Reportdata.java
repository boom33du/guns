package cn.stylefeng.guns.modular.rec.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 水表上报数据表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("rec_reportdata")
public class Reportdata implements Serializable {

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
     * 用水总量
     */
    @TableField("ACCUMUFLOWDAILY")
    private String accumuflowdaily;

    /**
     * 剩余电量
     */
    @TableField("BATTERYLEVEL")
    private String batterylevel;

    /**
     * 发送时间上半部分
     */
    @TableField("TIMEU")
    private String timeu;

    /**
     * 发送时间下半部分
     */
    @TableField("TIMED")
    private String timed;

    /**
     * 校验码
     */
    @TableField("CHECKSUM")
    private String checksum;

    /**
     * 应用系统接收时间
     */
    @TableField("RECEIVETIME")
    private Date receivetime;

    /**
     * 事件时间，来自电信云
     */
    @TableField("EVENTTIME")
    private String eventtime;

    /**
     * 备注
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

    public String getAccumuflowdaily() {
        return accumuflowdaily;
    }

    public void setAccumuflowdaily(String accumuflowdaily) {
        this.accumuflowdaily = accumuflowdaily;
    }

    public String getBatterylevel() {
        return batterylevel;
    }

    public void setBatterylevel(String batterylevel) {
        this.batterylevel = batterylevel;
    }

    public String getTimeu() {
        return timeu;
    }

    public void setTimeu(String timeu) {
        this.timeu = timeu;
    }

    public String getTimed() {
        return timed;
    }

    public void setTimed(String timed) {
        this.timed = timed;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Reportdata{" +
        "id=" + id +
        ", deviceid=" + deviceid +
        ", manuid=" + manuid +
        ", serialnum=" + serialnum +
        ", accumuflowdaily=" + accumuflowdaily +
        ", batterylevel=" + batterylevel +
        ", timeu=" + timeu +
        ", timed=" + timed +
        ", checksum=" + checksum +
        ", receivetime=" + receivetime +
        ", eventtime=" + eventtime +
        ", temp=" + temp +
        "}";
    }
}
