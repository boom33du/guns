package cn.stylefeng.guns.modular.busi.mapper;

import cn.stylefeng.guns.modular.busi.entity.UserOfCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 用户客户对应表 Mapper 接口
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface UserOfCustomerMapper extends BaseMapper<UserOfCustomer> {

    Page<Map<String, Object>> selectUserOfCusms(@Param("page") Page page, @Param("condition") String condition);
}
