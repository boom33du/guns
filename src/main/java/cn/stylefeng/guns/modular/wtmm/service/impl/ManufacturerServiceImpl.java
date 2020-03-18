package cn.stylefeng.guns.modular.wtmm.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.wtmm.entity.Manufacturer;
import cn.stylefeng.guns.modular.wtmm.mapper.ManufacturerMapper;
import cn.stylefeng.guns.modular.wtmm.model.params.ManufacturerParam;
import cn.stylefeng.guns.modular.wtmm.model.result.ManufacturerResult;
import  cn.stylefeng.guns.modular.wtmm.service.ManufacturerService;
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
 * 生产厂商表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class ManufacturerServiceImpl extends ServiceImpl<ManufacturerMapper, Manufacturer> implements ManufacturerService {

    @Override
    public void add(ManufacturerParam param){
        Manufacturer entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ManufacturerParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ManufacturerParam param){
        Manufacturer oldEntity = getOldEntity(param);
        Manufacturer newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ManufacturerResult findBySpec(ManufacturerParam param){
        return null;
    }

    @Override
    public List<ManufacturerResult> findListBySpec(ManufacturerParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ManufacturerParam param){
        Page pageContext = getPageContext();
        QueryWrapper<Manufacturer> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper
                .like("manufacturercode",param.getCondition())
                .or()
                .like("manufacturer",param.getCondition());
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ManufacturerParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Manufacturer getOldEntity(ManufacturerParam param) {
        return this.getById(getKey(param));
    }

    private Manufacturer getEntity(ManufacturerParam param) {
        Manufacturer entity = new Manufacturer();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
