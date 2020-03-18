package cn.stylefeng.guns.modular.rec.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.rec.entity.Instructionsissued;
import cn.stylefeng.guns.modular.rec.model.params.InstructionsissuedParam;
import cn.stylefeng.guns.modular.rec.model.result.InstructionsissuedResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 下发指令表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface InstructionsissuedService extends IService<Instructionsissued> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(InstructionsissuedParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(InstructionsissuedParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(InstructionsissuedParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    InstructionsissuedResult findBySpec(InstructionsissuedParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<InstructionsissuedResult> findListBySpec(InstructionsissuedParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(InstructionsissuedParam param);

}
