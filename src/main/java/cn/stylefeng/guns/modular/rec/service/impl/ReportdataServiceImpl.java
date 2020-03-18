package cn.stylefeng.guns.modular.rec.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.rec.entity.Reportdata;
import cn.stylefeng.guns.modular.rec.mapper.ReportdataMapper;
import cn.stylefeng.guns.modular.rec.model.params.ReportdataParam;
import cn.stylefeng.guns.modular.rec.model.result.ReportdataResult;
import  cn.stylefeng.guns.modular.rec.service.ReportdataService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 水表上报数据表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class ReportdataServiceImpl extends ServiceImpl<ReportdataMapper, Reportdata> implements ReportdataService {

    @Override
    public void add(ReportdataParam param){
        Reportdata entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ReportdataParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ReportdataParam param){
        Reportdata oldEntity = getOldEntity(param);
        Reportdata newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ReportdataResult findBySpec(ReportdataParam param){
        return null;
    }

    @Override
    public List<ReportdataResult> findListBySpec(ReportdataParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ReportdataParam param){
        Page pageContext = getPageContext();
        QueryWrapper<Reportdata> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ReportdataParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Reportdata getOldEntity(ReportdataParam param) {
        return this.getById(getKey(param));
    }

    private Reportdata getEntity(ReportdataParam param) {
        Reportdata entity = new Reportdata();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
