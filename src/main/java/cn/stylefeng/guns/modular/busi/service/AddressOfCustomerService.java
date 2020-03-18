package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressOfCustomer;
import cn.stylefeng.guns.modular.busi.model.params.AddressOfCustomerParam;
import cn.stylefeng.guns.modular.busi.model.result.AddressOfCustomerResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 客户地址表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface AddressOfCustomerService extends IService<AddressOfCustomer> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(AddressOfCustomerParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(AddressOfCustomerParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(AddressOfCustomerParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    AddressOfCustomerResult findBySpec(AddressOfCustomerParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<AddressOfCustomerResult> findListBySpec(AddressOfCustomerParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(AddressOfCustomerParam param);

}
