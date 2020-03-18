package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.UserOfCustomer;
import cn.stylefeng.guns.modular.busi.model.params.UserOfCustomerParam;
import cn.stylefeng.guns.modular.busi.model.result.UserOfCustomerResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户客户对应表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface UserOfCustomerService extends IService<UserOfCustomer> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(UserOfCustomerParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(UserOfCustomerParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(UserOfCustomerParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    UserOfCustomerResult findBySpec(UserOfCustomerParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<UserOfCustomerResult> findListBySpec(UserOfCustomerParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(UserOfCustomerParam param);

    /**
     * 查询所有客户分配用户
     * @param condition
     * @return
     */
    public Page<Map<String, Object>> selectUserOfCusms(String condition) ;

}
