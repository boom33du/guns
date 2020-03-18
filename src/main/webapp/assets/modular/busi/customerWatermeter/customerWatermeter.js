layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 客户水表对应表管理
     */
    var CustomerWatermeter = {
        tableId: "customerWatermeterTable"
    };

    /**
     * 初始化表格的列
     */
    CustomerWatermeter.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'customerinfoName', sort: true, title: '客户姓名'},
            {field: 'waterMeterDeviceId', sort: true, title: '水表设备ID'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    CustomerWatermeter.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(CustomerWatermeter.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    CustomerWatermeter.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加客户水表对应表',
            content: Feng.ctxPath + '/customerWatermeter/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(CustomerWatermeter.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    CustomerWatermeter.exportExcel = function () {
        var checkRows = table.checkStatus(CustomerWatermeter.tableId);
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
    CustomerWatermeter.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改客户水表对应表',
            content: Feng.ctxPath + '/customerWatermeter/edit?watermeterinfoId=' + data.watermeterinfoId,
            end: function () {
                admin.getTempData('formOk') && table.reload(CustomerWatermeter.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    CustomerWatermeter.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/customerWatermeter/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(CustomerWatermeter.tableId);
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
        elem: '#' + CustomerWatermeter.tableId,
        url: Feng.ctxPath + '/customerWatermeter/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: CustomerWatermeter.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        CustomerWatermeter.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        CustomerWatermeter.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        CustomerWatermeter.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + CustomerWatermeter.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            CustomerWatermeter.openEditDlg(data);
        } else if (layEvent === 'delete') {
            CustomerWatermeter.onDeleteItem(data);
        }
    });
});
