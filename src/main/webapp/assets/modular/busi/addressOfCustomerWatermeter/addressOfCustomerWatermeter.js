layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 客户地址水表对应表管理
     */
    var AddressOfCustomerWatermeter = {
        tableId: "addressOfCustomerWatermeterTable"
    };

    /**
     * 初始化表格的列
     */
    AddressOfCustomerWatermeter.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'customerinfoId', sort: true, title: '所属客户主键，外键'},
            {field: 'addressOfCustomerId', sort: true, title: '客户地址主键，外键'},
            {field: 'watermeterinfoId', hide: true, title: '水表编号，该编号在该表中唯一，外键'},
            {field: 'status', sort: true, title: '状态：1有效 0失效'},
            {field: 'begintime', sort: true, title: '绑定时间'},
            {field: 'endtime', sort: true, title: '失效时间'},
            {field: 'temp', sort: true, title: '操作历史记录'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    AddressOfCustomerWatermeter.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(AddressOfCustomerWatermeter.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    AddressOfCustomerWatermeter.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加客户地址水表对应表',
            content: Feng.ctxPath + '/addressOfCustomerWatermeter/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(AddressOfCustomerWatermeter.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    AddressOfCustomerWatermeter.exportExcel = function () {
        var checkRows = table.checkStatus(AddressOfCustomerWatermeter.tableId);
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
    AddressOfCustomerWatermeter.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改客户地址水表对应表',
            content: Feng.ctxPath + '/addressOfCustomerWatermeter/edit?watermeterinfoId=' + data.watermeterinfoId,
            end: function () {
                admin.getTempData('formOk') && table.reload(AddressOfCustomerWatermeter.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    AddressOfCustomerWatermeter.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/addressOfCustomerWatermeter/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(AddressOfCustomerWatermeter.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("watermeterinfoId", data.watermeterinfoId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + AddressOfCustomerWatermeter.tableId,
        url: Feng.ctxPath + '/addressOfCustomerWatermeter/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: AddressOfCustomerWatermeter.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        AddressOfCustomerWatermeter.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        AddressOfCustomerWatermeter.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        AddressOfCustomerWatermeter.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + AddressOfCustomerWatermeter.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            AddressOfCustomerWatermeter.openEditDlg(data);
        } else if (layEvent === 'delete') {
            AddressOfCustomerWatermeter.onDeleteItem(data);
        }
    });
});
