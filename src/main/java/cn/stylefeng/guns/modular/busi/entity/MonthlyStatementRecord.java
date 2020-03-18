package cn.stylefeng.guns.modular.busi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 月结记录表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("busi_monthly_statement_record")
public class MonthlyStatementRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 年份
     */
    @TableField("YEAR")
    private String year;

    /**
     * 月份
     */
    @TableField("MONTH")
    private String month;

    /**
     * 月结时间
     */
    @TableField("RECORDTIME")
    private Date recordtime;

    /**
     * 操作人，用户表主键，外键
     */
    @TableField("OPERID")
    private Long operid;

    /**
     * 开始时间
     */
    @TableField("BEGINTIME")
    private Date begintime;

    /**
     * 结束时间
     */
    @TableField("ENDTIME")
    private Date endtime;

    /**
     * 月结用户数
     */
    @TableField("ALLCOUNT")
    private Integer allcount;

    /**
     * 月结成功用户数
     */
    @TableField("SUCCOUNT")
    private Integer succount;

    /**
     * 月结记录，记录异常情况
     */
    @TableField("DETAIL")
    private String detail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public Long getOperid() {
        return operid;
    }

    public void setOperid(Long operid) {
        this.operid = operid;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getAllcount() {
        return allcount;
    }

    public void setAllcount(Integer allcount) {
        this.allcount = allcount;
    }

    public Integer getSuccount() {
        return succount;
    }

    public void setSuccount(Integer succount) {
        this.succount = succount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MonthlyStatementRecord{" +
        "id=" + id +
        ", year=" + year +
        ", month=" + month +
        ", recordtime=" + recordtime +
        ", operid=" + operid +
        ", begintime=" + begintime +
        ", endtime=" + endtime +
        ", allcount=" + allcount +
        ", succount=" + succount +
        ", detail=" + detail +
        "}";
    }
}
