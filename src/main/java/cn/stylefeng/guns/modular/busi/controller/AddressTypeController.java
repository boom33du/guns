package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressType;
import cn.stylefeng.guns.modular.busi.model.params.AddressTypeParam;
import cn.stylefeng.guns.modular.busi.service.AddressTypeService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 地址类型表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/addressType")
public class AddressTypeController extends BaseController {

    private String PREFIX = "/modular/busi/addressType";

    @Autowired
    private AddressTypeService addressTypeService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/addressType.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/addressType_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/addressType_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(AddressTypeParam addressTypeParam) {
        this.addressTypeService.add(addressTypeParam);
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
    public ResponseData editItem(AddressTypeParam addressTypeParam) {
        this.addressTypeService.update(addressTypeParam);
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
    public ResponseData delete(AddressTypeParam addressTypeParam) {
        this.addressTypeService.delete(addressTypeParam);
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
    public ResponseData detail(AddressTypeParam addressTypeParam) {
        AddressType detail = this.addressTypeService.getById(addressTypeParam.getId());
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
    public LayuiPageInfo list(AddressTypeParam addressTypeParam) {
        return this.addressTypeService.findPageBySpec(addressTypeParam);
    }

}


