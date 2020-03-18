package cn.stylefeng.guns.modular.wtmm.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.wtmm.entity.Watermeterinfo;
import cn.stylefeng.guns.modular.wtmm.mapper.WatermeterinfoMapper;
import cn.stylefeng.guns.modular.wtmm.model.params.WatermeterinfoParam;
import cn.stylefeng.guns.modular.wtmm.model.result.WatermeterinfoResult;
import  cn.stylefeng.guns.modular.wtmm.service.WatermeterinfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 水表硬件信息登记表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class WatermeterinfoServiceImpl extends ServiceImpl<WatermeterinfoMapper, Watermeterinfo> implements WatermeterinfoService {

    @Override
    public void add(WatermeterinfoParam param){
        Watermeterinfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(WatermeterinfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(WatermeterinfoParam param){
        Watermeterinfo oldEntity = getOldEntity(param);
        Watermeterinfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public WatermeterinfoResult findBySpec(WatermeterinfoParam param){
        return null;
    }

    @Override
    public List<WatermeterinfoResult> findListBySpec(WatermeterinfoParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(WatermeterinfoParam param){
        Page pageContext = getPageContext();
        QueryWrapper<Watermeterinfo> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    @Override
    public Page<Map<String, Object>> selectWatermeters(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectWatermeters(page, condition);
    }

    private Serializable getKey(WatermeterinfoParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Watermeterinfo getOldEntity(WatermeterinfoParam param) {
        return this.getById(getKey(param));
    }

    private Watermeterinfo getEntity(WatermeterinfoParam param) {
        Watermeterinfo entity = new Watermeterinfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
