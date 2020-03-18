package cn.stylefeng.guns.modular.rec.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 下发指令表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@TableName("rec_instructionsissued")
public class Instructionsissued implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 要下发到的水表id
     */
    @TableField("waterMeterId")
    private String waterMeterId;

    /**
     * 指令类型 1、纯指令 2、升级包
     */
    @TableField("instructionType")
    private String instructionType;

    /**
     * 下发指令内容
     */
    @TableField("instructionContent")
    private String instructionContent;

    /**
     * 发送者
     */
    @TableField("sender")
    private String sender;

    /**
     * 发送时间
     */
    @TableField("SendTime")
    private Date SendTime;

    /**
     * 硬件返回的执行结果
     */
    @TableField("resultsOfExecution")
    private String resultsOfExecution;

    /**
     * 执行完成时间
     */
    @TableField("endTime")
    private Date endTime;

    /**
     * 是否执行结束 0、失败 1、成功结束
     */
    @TableField("isFinished")
    private String isFinished;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWaterMeterId() {
        return waterMeterId;
    }

    public void setWaterMeterId(String waterMeterId) {
        this.waterMeterId = waterMeterId;
    }

    public String getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(String instructionType) {
        this.instructionType = instructionType;
    }

    public String getInstructionContent() {
        return instructionContent;
    }

    public void setInstructionContent(String instructionContent) {
        this.instructionContent = instructionContent;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getSendTime() {
        return SendTime;
    }

    public void setSendTime(Date SendTime) {
        this.SendTime = SendTime;
    }

    public String getResultsOfExecution() {
        return resultsOfExecution;
    }

    public void setResultsOfExecution(String resultsOfExecution) {
        this.resultsOfExecution = resultsOfExecution;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    @Override
    public String toString() {
        return "Instructionsissued{" +
        "id=" + id +
        ", waterMeterId=" + waterMeterId +
        ", instructionType=" + instructionType +
        ", instructionContent=" + instructionContent +
        ", sender=" + sender +
        ", SendTime=" + SendTime +
        ", resultsOfExecution=" + resultsOfExecution +
        ", endTime=" + endTime +
        ", isFinished=" + isFinished +
        "}";
    }
}
