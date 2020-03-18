package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.CustomerWatermeter;
import cn.stylefeng.guns.modular.busi.model.params.CustomerWatermeterParam;
import cn.stylefeng.guns.modular.busi.model.result.CustomerWatermeterResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户水表对应表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface CustomerWatermeterService extends IService<CustomerWatermeter> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(CustomerWatermeterParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(CustomerWatermeterParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(CustomerWatermeterParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    CustomerWatermeterResult findBySpec(CustomerWatermeterParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<CustomerWatermeterResult> findListBySpec(CustomerWatermeterParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(CustomerWatermeterParam param);


    /**
     * 查询所有水表分配情况
     * @param condition
     * @return
     */
    public Page<Map<String, Object>> selectCustomerWaterMeter(String condition) ;
}
