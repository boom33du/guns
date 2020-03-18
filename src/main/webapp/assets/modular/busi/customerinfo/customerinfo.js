layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 客户信息表管理
     */
    var Customerinfo = {
        tableId: "customerinfoTable"
    };

    /**
     * 初始化表格的列
     */
    Customerinfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'customercode', sort: true, title: '客户编号'},
            {field: 'customername', sort: true, title: '客户名称'},
            {field: 'watermetercount', sort: true, title: '购买水表数量'},
            {field: 'temp', sort: true, title: '备注'},
            {field: 'creator', sort: true, title: '创建人'},
            {field: 'creattime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Customerinfo.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Customerinfo.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    Customerinfo.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加客户信息',
            content: Feng.ctxPath + '/customerinfo/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(Customerinfo.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    Customerinfo.exportExcel = function () {
        var checkRows = table.checkStatus(Customerinfo.tableId);
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
    Customerinfo.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改客户信息',
            content: Feng.ctxPath + '/customerinfo/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(Customerinfo.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Customerinfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/customerinfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Customerinfo.tableId);
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
        elem: '#' + Customerinfo.tableId,
        url: Feng.ctxPath + '/customerinfo/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Customerinfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Customerinfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Customerinfo.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Customerinfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Customerinfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Customerinfo.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Customerinfo.onDeleteItem(data);
        }
    });
});
