package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.MonthlyStatementDetail;
import cn.stylefeng.guns.modular.busi.model.params.MonthlyStatementDetailParam;
import cn.stylefeng.guns.modular.busi.model.result.MonthlyStatementDetailResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 月结明细表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface MonthlyStatementDetailService extends IService<MonthlyStatementDetail> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(MonthlyStatementDetailParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(MonthlyStatementDetailParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(MonthlyStatementDetailParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    MonthlyStatementDetailResult findBySpec(MonthlyStatementDetailParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<MonthlyStatementDetailResult> findListBySpec(MonthlyStatementDetailParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(MonthlyStatementDetailParam param);

}
