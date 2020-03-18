package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressOfCustomerWatermeter;
import cn.stylefeng.guns.modular.busi.model.params.AddressOfCustomerWatermeterParam;
import cn.stylefeng.guns.modular.busi.model.result.AddressOfCustomerWatermeterResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 客户地址水表对应表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface AddressOfCustomerWatermeterService extends IService<AddressOfCustomerWatermeter> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(AddressOfCustomerWatermeterParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(AddressOfCustomerWatermeterParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(AddressOfCustomerWatermeterParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    AddressOfCustomerWatermeterResult findBySpec(AddressOfCustomerWatermeterParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<AddressOfCustomerWatermeterResult> findListBySpec(AddressOfCustomerWatermeterParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(AddressOfCustomerWatermeterParam param);

}
