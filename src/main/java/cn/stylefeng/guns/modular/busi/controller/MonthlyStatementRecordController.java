package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.MonthlyStatementRecord;
import cn.stylefeng.guns.modular.busi.model.params.MonthlyStatementRecordParam;
import cn.stylefeng.guns.modular.busi.service.MonthlyStatementRecordService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 月结记录表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/monthlyStatementRecord")
public class MonthlyStatementRecordController extends BaseController {

    private String PREFIX = "/modular/busi/monthlyStatementRecord";

    @Autowired
    private MonthlyStatementRecordService monthlyStatementRecordService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/monthlyStatementRecord.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/monthlyStatementRecord_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/monthlyStatementRecord_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MonthlyStatementRecordParam monthlyStatementRecordParam) {
        this.monthlyStatementRecordService.add(monthlyStatementRecordParam);
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
    public ResponseData editItem(MonthlyStatementRecordParam monthlyStatementRecordParam) {
        this.monthlyStatementRecordService.update(monthlyStatementRecordParam);
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
    public ResponseData delete(MonthlyStatementRecordParam monthlyStatementRecordParam) {
        this.monthlyStatementRecordService.delete(monthlyStatementRecordParam);
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
    public ResponseData detail(MonthlyStatementRecordParam monthlyStatementRecordParam) {
        MonthlyStatementRecord detail = this.monthlyStatementRecordService.getById(monthlyStatementRecordParam.getId());
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
    public LayuiPageInfo list(MonthlyStatementRecordParam monthlyStatementRecordParam) {
        return this.monthlyStatementRecordService.findPageBySpec(monthlyStatementRecordParam);
    }

}


