package cn.stylefeng.guns.modular.wtmm.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.wtmm.entity.Watermeterinfo;
import cn.stylefeng.guns.modular.wtmm.model.params.WatermeterinfoParam;
import cn.stylefeng.guns.modular.wtmm.model.result.WatermeterinfoResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 水表硬件信息登记表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface WatermeterinfoService extends IService<Watermeterinfo> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(WatermeterinfoParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(WatermeterinfoParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(WatermeterinfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    WatermeterinfoResult findBySpec(WatermeterinfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<WatermeterinfoResult> findListBySpec(WatermeterinfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(WatermeterinfoParam param);

    /**
     * 查询所有客户分配用户
     * @param condition
     * @return
     */
    public Page<Map<String, Object>> selectWatermeters(String condition) ;

}
