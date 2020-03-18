layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 管理
     */
    var Msg = {
        tableId: "msgTable"
    };

    /**
     * 初始化表格的列
     */
    Msg.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'name', sort: true, title: '名字'},
            {field: 'value', sort: true, title: '值'},
            {field: 'length', sort: true, title: '长度'},
            {field: 'radius', sort: true, title: '半径'},
            {field: 'flag', sort: true, title: '标志'},
            {field: 'temp', sort: true, title: '备注'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Msg.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Msg.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    Msg.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加',
            content: Feng.ctxPath + '/msg/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(Msg.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    Msg.exportExcel = function () {
        var checkRows = table.checkStatus(Msg.tableId);
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
    Msg.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改',
            content: Feng.ctxPath + '/msg/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(Msg.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Msg.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/msg/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Msg.tableId);
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
        elem: '#' + Msg.tableId,
        url: Feng.ctxPath + '/msg/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Msg.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Msg.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Msg.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Msg.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Msg.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Msg.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Msg.onDeleteItem(data);
        }
    });
});
