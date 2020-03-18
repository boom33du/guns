layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 客户居民用户表管理
     */
    var HouseholdOfCustomer = {
        tableId: "householdOfCustomerTable"
    };

    /**
     * 初始化表格的列
     */
    HouseholdOfCustomer.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'addressOfCustomerId', sort: true, title: '客户地址id，外键'},
            {field: 'wmWaterSupplyNumber', sort: true, title: '给水号'},
            {field: 'province', sort: true, title: '省'},
            {field: 'city', sort: true, title: '市'},
            {field: 'district', sort: true, title: '县'},
            {field: 'street', sort: true, title: '街道'},
            {field: 'community', sort: true, title: '小区'},
            {field: 'customerinfoId', sort: true, title: '客户主键，外键'},
            {field: 'detailAddress', sort: true, title: '详细地址'},
            {field: 'realName', sort: true, title: '户主姓名'},
            {field: 'mobilePhoneNumber', sort: true, title: '手机号'},
            {field: 'idNumber', sort: true, title: '身份证号'},
            {field: 'curLeftWaterL', sort: true, title: '年度剩余水量默认0'},
            {field: 'totalWaterL', sort: true, title: '总量默认0'},
            {field: 'curWmNumber', sort: true, title: '当前水表读数默认0'},
            {field: 'moneyLeft', sort: true, title: '水费余额默认0，小数点后2位'},
            {field: 'lastReadTime', sort: true, title: '最新读取水表数据时间'},
            {field: 'usageType', sort: true, title: '用水类别，默认0（0居民、1非居民等）'},
            {field: 'paymenttype', sort: true, title: '类型，0后付费，1预付费'},
            {field: 'staircaseWaterPriceId', sort: true, title: '阶梯水价规则（默认一户4人）'},
            {field: 'status', sort: true, title: '状态：0 正常；1删除'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    HouseholdOfCustomer.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(HouseholdOfCustomer.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    HouseholdOfCustomer.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加客户居民用户表',
            content: Feng.ctxPath + '/householdOfCustomer/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(HouseholdOfCustomer.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    HouseholdOfCustomer.exportExcel = function () {
        var checkRows = table.checkStatus(HouseholdOfCustomer.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    HouseholdOfCustomer.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改客户居民用户表',
            content: Feng.ctxPath + '/householdOfCustomer/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(HouseholdOfCustomer.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    HouseholdOfCustomer.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/householdOfCustomer/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(HouseholdOfCustomer.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + HouseholdOfCustomer.tableId,
        url: Feng.ctxPath + '/householdOfCustomer/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: HouseholdOfCustomer.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        HouseholdOfCustomer.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        HouseholdOfCustomer.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        HouseholdOfCustomer.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + HouseholdOfCustomer.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            HouseholdOfCustomer.openEditDlg(data);
        } else if (layEvent === 'delete') {
            HouseholdOfCustomer.onDeleteItem(data);
        }
    });
});
