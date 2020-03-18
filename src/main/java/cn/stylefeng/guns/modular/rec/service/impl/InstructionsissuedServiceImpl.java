package cn.stylefeng.guns.modular.rec.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.rec.entity.Instructionsissued;
import cn.stylefeng.guns.modular.rec.mapper.InstructionsissuedMapper;
import cn.stylefeng.guns.modular.rec.model.params.InstructionsissuedParam;
import cn.stylefeng.guns.modular.rec.model.result.InstructionsissuedResult;
import  cn.stylefeng.guns.modular.rec.service.InstructionsissuedService;
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
 * 下发指令表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class InstructionsissuedServiceImpl extends ServiceImpl<InstructionsissuedMapper, Instructionsissued> implements InstructionsissuedService {

    @Override
    public void add(InstructionsissuedParam param){
        Instructionsissued entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(InstructionsissuedParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(InstructionsissuedParam param){
        Instructionsissued oldEntity = getOldEntity(param);
        Instructionsissued newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public InstructionsissuedResult findBySpec(InstructionsissuedParam param){
        return null;
    }

    @Override
    public List<InstructionsissuedResult> findListBySpec(InstructionsissuedParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(InstructionsissuedParam param){
        Page pageContext = getPageContext();
        QueryWrapper<Instructionsissued> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(InstructionsissuedParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Instructionsissued getOldEntity(InstructionsissuedParam param) {
        return this.getById(getKey(param));
    }

    private Instructionsissued getEntity(InstructionsissuedParam param) {
        Instructionsissued entity = new Instructionsissued();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
