package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.MonthlyStatementDetail;
import cn.stylefeng.guns.modular.busi.model.params.MonthlyStatementDetailParam;
import cn.stylefeng.guns.modular.busi.service.MonthlyStatementDetailService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 月结明细表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/monthlyStatementDetail")
public class MonthlyStatementDetailController extends BaseController {

    private String PREFIX = "/modular/busi/monthlyStatementDetail";

    @Autowired
    private MonthlyStatementDetailService monthlyStatementDetailService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/monthlyStatementDetail.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/monthlyStatementDetail_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/monthlyStatementDetail_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MonthlyStatementDetailParam monthlyStatementDetailParam) {
        this.monthlyStatementDetailService.add(monthlyStatementDetailParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MonthlyStatementDetailParam monthlyStatementDetailParam) {
        this.monthlyStatementDetailService.update(monthlyStatementDetailParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MonthlyStatementDetailParam monthlyStatementDetailParam) {
        this.monthlyStatementDetailService.delete(monthlyStatementDetailParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MonthlyStatementDetailParam monthlyStatementDetailParam) {
        MonthlyStatementDetail detail = this.monthlyStatementDetailService.getById(monthlyStatementDetailParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MonthlyStatementDetailParam monthlyStatementDetailParam) {
        return this.monthlyStatementDetailService.findPageBySpec(monthlyStatementDetailParam);
    }

}


