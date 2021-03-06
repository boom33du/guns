package cn.stylefeng.guns.modular.test_gen.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.test_gen.entity.Msg;
import cn.stylefeng.guns.modular.test_gen.model.params.MsgParam;
import cn.stylefeng.guns.modular.test_gen.service.MsgService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器
 *
 * @author zhuhailin
 * @Date 2019-10-06 18:52:09
 */
@Controller
@RequestMapping("/msg")
public class MsgController extends BaseController {

    private String PREFIX = "/modular/msg";

    @Autowired
    private MsgService msgService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/msg.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/msg_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/msg_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MsgParam msgParam) {
        this.msgService.add(msgParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MsgParam msgParam) {
        this.msgService.update(msgParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MsgParam msgParam) {
        this.msgService.delete(msgParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MsgParam msgParam) {
        Msg detail = this.msgService.getById(msgParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author zhuhailin
     * @Date 2019-10-06
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MsgParam msgParam) {
        return this.msgService.findPageBySpec(msgParam);
    }

}


