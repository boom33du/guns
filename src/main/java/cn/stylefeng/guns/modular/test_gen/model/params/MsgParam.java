package cn.stylefeng.guns.modular.test_gen.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuhailin
 * @since 2019-10-06
 */
@Data
public class MsgParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String name;

    private String value;

    private Integer length;

    private Double radius;

    private String flag;

    private String temp;

    @Override
    public String checkParam() {
        return null;
    }

}
