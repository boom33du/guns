package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.MonthlyStatementRecord;
import cn.stylefeng.guns.modular.busi.mapper.MonthlyStatementRecordMapper;
import cn.stylefeng.guns.modular.busi.model.params.MonthlyStatementRecordParam;
import cn.stylefeng.guns.modular.busi.model.result.MonthlyStatementRecordResult;
import  cn.stylefeng.guns.modular.busi.service.MonthlyStatementRecordService;
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
 * 月结记录表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class MonthlyStatementRecordServiceImpl extends ServiceImpl<MonthlyStatementRecordMapper, MonthlyStatementRecord> implements MonthlyStatementRecordService {

    @Override
    public void add(MonthlyStatementRecordParam param){
        MonthlyStatementRecord entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MonthlyStatementRecordParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MonthlyStatementRecordParam param){
        MonthlyStatementRecord oldEntity = getOldEntity(param);
        MonthlyStatementRecord newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MonthlyStatementRecordResult findBySpec(MonthlyStatementRecordParam param){
        return null;
    }

    @Override
    public List<MonthlyStatementRecordResult> findListBySpec(MonthlyStatementRecordParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MonthlyStatementRecordParam param){
        Page pageContext = getPageContext();
        QueryWrapper<MonthlyStatementRecord> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MonthlyStatementRecordParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MonthlyStatementRecord getOldEntity(MonthlyStatementRecordParam param) {
        return this.getById(getKey(param));
    }

    private MonthlyStatementRecord getEntity(MonthlyStatementRecordParam param) {
        MonthlyStatementRecord entity = new MonthlyStatementRecord();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
