package cn.stylefeng.guns.modular.test_gen.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.test_gen.entity.Msg;
import cn.stylefeng.guns.modular.test_gen.model.params.MsgParam;
import cn.stylefeng.guns.modular.test_gen.model.result.MsgResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-10-06
 */
public interface MsgService extends IService<Msg> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    void add(MsgParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    void delete(MsgParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    void update(MsgParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    MsgResult findBySpec(MsgParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    List<MsgResult> findListBySpec(MsgParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
     LayuiPageInfo findPageBySpec(MsgParam param);

}
