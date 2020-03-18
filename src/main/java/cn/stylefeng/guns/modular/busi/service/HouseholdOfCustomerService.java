package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.HouseholdOfCustomer;
import cn.stylefeng.guns.modular.busi.model.params.HouseholdOfCustomerParam;
import cn.stylefeng.guns.modular.busi.model.result.HouseholdOfCustomerResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 客户居民用户表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface HouseholdOfCustomerService extends IService<HouseholdOfCustomer> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(HouseholdOfCustomerParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(HouseholdOfCustomerParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(HouseholdOfCustomerParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    HouseholdOfCustomerResult findBySpec(HouseholdOfCustomerParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<HouseholdOfCustomerResult> findListBySpec(HouseholdOfCustomerParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(HouseholdOfCustomerParam param);

}
