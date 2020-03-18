package cn.stylefeng.guns.modular.rec.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.rec.entity.Reportdata;
import cn.stylefeng.guns.modular.rec.model.params.ReportdataParam;
import cn.stylefeng.guns.modular.rec.service.ReportdataService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 水表上报数据表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:33:34
 */
@Controller
@RequestMapping("/reportdata")
public class ReportdataController extends BaseController {

    private String PREFIX = "/modular/rec/reportdata";

    @Autowired
    private ReportdataService reportdataService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/reportdata.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/reportdata_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/reportdata_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ReportdataParam reportdataParam) {
        this.reportdataService.add(reportdataParam);
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
    public ResponseData editItem(ReportdataParam reportdataParam) {
        this.reportdataService.update(reportdataParam);
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
    public ResponseData delete(ReportdataParam reportdataParam) {
        this.reportdataService.delete(reportdataParam);
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
    public ResponseData detail(ReportdataParam reportdataParam) {
        Reportdata detail = this.reportdataService.getById(reportdataParam.getId());
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
    public LayuiPageInfo list(ReportdataParam reportdataParam) {
        return this.reportdataService.findPageBySpec(reportdataParam);
    }

}


