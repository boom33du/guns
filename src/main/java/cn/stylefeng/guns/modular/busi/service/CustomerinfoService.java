package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.Customerinfo;
import cn.stylefeng.guns.modular.busi.model.params.CustomerinfoParam;
import cn.stylefeng.guns.modular.busi.model.result.CustomerinfoResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 客户信息表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface CustomerinfoService extends IService<Customerinfo> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(CustomerinfoParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(CustomerinfoParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(CustomerinfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    CustomerinfoResult findBySpec(CustomerinfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<CustomerinfoResult> findListBySpec(CustomerinfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(CustomerinfoParam param);

}
