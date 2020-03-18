package cn.stylefeng.guns.modular.wtmm.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.wtmm.entity.TypeOfWatermeter;
import cn.stylefeng.guns.modular.wtmm.model.params.TypeOfWatermeterParam;
import cn.stylefeng.guns.modular.wtmm.service.ManufacturerService;
import cn.stylefeng.guns.modular.wtmm.service.TypeOfWatermeterService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 水表型号表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:34:08
 */
@Controller
@RequestMapping("/typeOfWatermeter")
public class TypeOfWatermeterController extends BaseController {

    private String PREFIX = "/modular/wtmm/typeOfWatermeter";

    @Autowired
    private TypeOfWatermeterService typeOfWatermeterService;

    @Autowired
    private ManufacturerService manufacturerService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/typeOfWatermeter.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("manus",manufacturerService.list());
        return PREFIX + "/typeOfWatermeter_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/typeOfWatermeter_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(TypeOfWatermeterParam typeOfWatermeterParam) {
        String manumsg = typeOfWatermeterParam.getManufacturerMsg();
        String[] msgs = manumsg.split("-");
        typeOfWatermeterParam.setManufacturercode(msgs[0]);
        typeOfWatermeterParam.setManufacturer(msgs[1]);
        this.typeOfWatermeterService.add(typeOfWatermeterParam);
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
    public ResponseData editItem(TypeOfWatermeterParam typeOfWatermeterParam) {
        this.typeOfWatermeterService.update(typeOfWatermeterParam);
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
    public ResponseData delete(TypeOfWatermeterParam typeOfWatermeterParam) {
        this.typeOfWatermeterService.delete(typeOfWatermeterParam);
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
    public ResponseData detail(TypeOfWatermeterParam typeOfWatermeterParam) {
        TypeOfWatermeter detail = this.typeOfWatermeterService.getById(typeOfWatermeterParam.getId());
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
    public LayuiPageInfo list(TypeOfWatermeterParam typeOfWatermeterParam) {

        return this.typeOfWatermeterService.findPageBySpec(typeOfWatermeterParam);
    }

}


