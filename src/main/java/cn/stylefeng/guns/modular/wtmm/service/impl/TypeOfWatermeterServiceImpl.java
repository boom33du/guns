package cn.stylefeng.guns.modular.wtmm.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.wtmm.entity.TypeOfWatermeter;
import cn.stylefeng.guns.modular.wtmm.mapper.TypeOfWatermeterMapper;
import cn.stylefeng.guns.modular.wtmm.model.params.TypeOfWatermeterParam;
import cn.stylefeng.guns.modular.wtmm.model.result.TypeOfWatermeterResult;
import  cn.stylefeng.guns.modular.wtmm.service.TypeOfWatermeterService;
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
 * 水表型号表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class TypeOfWatermeterServiceImpl extends ServiceImpl<TypeOfWatermeterMapper, TypeOfWatermeter> implements TypeOfWatermeterService {

    @Override
    public void add(TypeOfWatermeterParam param){
        TypeOfWatermeter entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(TypeOfWatermeterParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(TypeOfWatermeterParam param){
        TypeOfWatermeter oldEntity = getOldEntity(param);
        TypeOfWatermeter newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public TypeOfWatermeterResult findBySpec(TypeOfWatermeterParam param){
        return null;
    }

    @Override
    public List<TypeOfWatermeterResult> findListBySpec(TypeOfWatermeterParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(TypeOfWatermeterParam param){
        Page pageContext = getPageContext();
        QueryWrapper<TypeOfWatermeter> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper
                .like("WATERMETER_TYPE",param.getWatermeterType());
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(TypeOfWatermeterParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private TypeOfWatermeter getOldEntity(TypeOfWatermeterParam param) {
        return this.getById(getKey(param));
    }

    private TypeOfWatermeter getEntity(TypeOfWatermeterParam param) {
        TypeOfWatermeter entity = new TypeOfWatermeter();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
