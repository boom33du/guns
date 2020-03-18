package cn.stylefeng.guns.modular.wtmm.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.wtmm.entity.TypeOfWatermeter;
import cn.stylefeng.guns.modular.wtmm.model.params.TypeOfWatermeterParam;
import cn.stylefeng.guns.modular.wtmm.model.result.TypeOfWatermeterResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 水表型号表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface TypeOfWatermeterService extends IService<TypeOfWatermeter> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(TypeOfWatermeterParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(TypeOfWatermeterParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(TypeOfWatermeterParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    TypeOfWatermeterResult findBySpec(TypeOfWatermeterParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<TypeOfWatermeterResult> findListBySpec(TypeOfWatermeterParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(TypeOfWatermeterParam param);

}
