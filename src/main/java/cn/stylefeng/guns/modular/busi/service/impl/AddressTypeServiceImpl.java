package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressType;
import cn.stylefeng.guns.modular.busi.mapper.AddressTypeMapper;
import cn.stylefeng.guns.modular.busi.model.params.AddressTypeParam;
import cn.stylefeng.guns.modular.busi.model.result.AddressTypeResult;
import  cn.stylefeng.guns.modular.busi.service.AddressTypeService;
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
 * 地址类型表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class AddressTypeServiceImpl extends ServiceImpl<AddressTypeMapper, AddressType> implements AddressTypeService {

    @Override
    public void add(AddressTypeParam param){
        AddressType entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(AddressTypeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(AddressTypeParam param){
        AddressType oldEntity = getOldEntity(param);
        AddressType newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public AddressTypeResult findBySpec(AddressTypeParam param){
        return null;
    }

    @Override
    public List<AddressTypeResult> findListBySpec(AddressTypeParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(AddressTypeParam param){
        Page pageContext = getPageContext();
        QueryWrapper<AddressType> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(AddressTypeParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private AddressType getOldEntity(AddressTypeParam param) {
        return this.getById(getKey(param));
    }

    private AddressType getEntity(AddressTypeParam param) {
        AddressType entity = new AddressType();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
