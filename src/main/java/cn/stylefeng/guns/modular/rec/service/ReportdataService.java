package cn.stylefeng.guns.modular.rec.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.rec.entity.Reportdata;
import cn.stylefeng.guns.modular.rec.model.params.ReportdataParam;
import cn.stylefeng.guns.modular.rec.model.result.ReportdataResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 水表上报数据表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface ReportdataService extends IService<Reportdata> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(ReportdataParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(ReportdataParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(ReportdataParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    ReportdataResult findBySpec(ReportdataParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<ReportdataResult> findListBySpec(ReportdataParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(ReportdataParam param);

}
