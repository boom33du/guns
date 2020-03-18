package cn.stylefeng.guns.modular.rec.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 下发指令表
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Data
public class InstructionsissuedParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 要下发到的水表id
     */
    private String waterMeterId;

    /**
     * 指令类型 1、纯指令 2、升级包
     */
    private String instructionType;

    /**
     * 下发指令内容
     */
    private String instructionContent;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 发送时间
     */
    private Date SendTime;

    /**
     * 硬件返回的执行结果
     */
    private String resultsOfExecution;

    /**
     * 执行完成时间
     */
    private Date endTime;

    /**
     * 是否执行结束 0、失败 1、成功结束
     */
    private String isFinished;

    @Override
    public String checkParam() {
        return null;
    }

}
