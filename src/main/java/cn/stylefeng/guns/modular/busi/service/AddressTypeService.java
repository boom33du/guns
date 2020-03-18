package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressType;
import cn.stylefeng.guns.modular.busi.model.params.AddressTypeParam;
import cn.stylefeng.guns.modular.busi.model.result.AddressTypeResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 地址类型表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface AddressTypeService extends IService<AddressType> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(AddressTypeParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(AddressTypeParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(AddressTypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    AddressTypeResult findBySpec(AddressTypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<AddressTypeResult> findListBySpec(AddressTypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(AddressTypeParam param);

}
