package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.MonthlyStatementDetail;
import cn.stylefeng.guns.modular.busi.mapper.MonthlyStatementDetailMapper;
import cn.stylefeng.guns.modular.busi.model.params.MonthlyStatementDetailParam;
import cn.stylefeng.guns.modular.busi.model.result.MonthlyStatementDetailResult;
import  cn.stylefeng.guns.modular.busi.service.MonthlyStatementDetailService;
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
 * 月结明细表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class MonthlyStatementDetailServiceImpl extends ServiceImpl<MonthlyStatementDetailMapper, MonthlyStatementDetail> implements MonthlyStatementDetailService {

    @Override
    public void add(MonthlyStatementDetailParam param){
        MonthlyStatementDetail entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MonthlyStatementDetailParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MonthlyStatementDetailParam param){
        MonthlyStatementDetail oldEntity = getOldEntity(param);
        MonthlyStatementDetail newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MonthlyStatementDetailResult findBySpec(MonthlyStatementDetailParam param){
        return null;
    }

    @Override
    public List<MonthlyStatementDetailResult> findListBySpec(MonthlyStatementDetailParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MonthlyStatementDetailParam param){
        Page pageContext = getPageContext();
        QueryWrapper<MonthlyStatementDetail> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MonthlyStatementDetailParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MonthlyStatementDetail getOldEntity(MonthlyStatementDetailParam param) {
        return this.getById(getKey(param));
    }

    private MonthlyStatementDetail getEntity(MonthlyStatementDetailParam param) {
        MonthlyStatementDetail entity = new MonthlyStatementDetail();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
