package cn.stylefeng.guns.modular.wtmm.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.wtmm.entity.Manufacturer;
import cn.stylefeng.guns.modular.wtmm.model.params.ManufacturerParam;
import cn.stylefeng.guns.modular.wtmm.model.result.ManufacturerResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 生产厂商表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface ManufacturerService extends IService<Manufacturer> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(ManufacturerParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(ManufacturerParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(ManufacturerParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    ManufacturerResult findBySpec(ManufacturerParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<ManufacturerResult> findListBySpec(ManufacturerParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(ManufacturerParam param);

}
