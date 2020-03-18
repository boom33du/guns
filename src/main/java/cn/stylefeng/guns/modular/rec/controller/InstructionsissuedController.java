package cn.stylefeng.guns.modular.rec.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.rec.entity.Instructionsissued;
import cn.stylefeng.guns.modular.rec.model.params.InstructionsissuedParam;
import cn.stylefeng.guns.modular.rec.service.InstructionsissuedService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 下发指令表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:33:34
 */
@Controller
@RequestMapping("/instructionsissued")
public class InstructionsissuedController extends BaseController {

    private String PREFIX = "/modular/rec/instructionsissued";

    @Autowired
    private InstructionsissuedService instructionsissuedService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        System.out.println("aaaaa");
        return PREFIX + "/instructionsissued.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/instructionsissued_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/instructionsissued_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(InstructionsissuedParam instructionsissuedParam) {
        this.instructionsissuedService.add(instructionsissuedParam);
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
    public ResponseData editItem(InstructionsissuedParam instructionsissuedParam) {
        this.instructionsissuedService.update(instructionsissuedParam);
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
    public ResponseData delete(InstructionsissuedParam instructionsissuedParam) {
        this.instructionsissuedService.delete(instructionsissuedParam);
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
    public ResponseData detail(InstructionsissuedParam instructionsissuedParam) {
        Instructionsissued detail = this.instructionsissuedService.getById(instructionsissuedParam.getId());
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
    public LayuiPageInfo list(InstructionsissuedParam instructionsissuedParam) {
        return this.instructionsissuedService.findPageBySpec(instructionsissuedParam);
    }

}


