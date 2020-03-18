package cn.stylefeng.guns.modular.wtmm.mapper;

import cn.stylefeng.guns.modular.wtmm.entity.Watermeterinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 水表硬件信息登记表 Mapper 接口
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface WatermeterinfoMapper extends BaseMapper<Watermeterinfo> {
    Page<Map<String, Object>> selectWatermeters(@Param("page") Page page, @Param("condition") String condition);
}
