layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 生产厂商表管理
     */
    var Manufacturer = {
        tableId: "manufacturerTable"
    };

    /**
     * 初始化表格的列
     */
    Manufacturer.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'manufacturercode', sort: true, title: '生产厂商编码'},
            {field: 'manufacturer', sort: true, title: '生产厂商名称'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Manufacturer.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Manufacturer.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    Manufacturer.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加生产厂商',
            content: Feng.ctxPath + '/manufacturer/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(Manufacturer.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    Manufacturer.exportExcel = function () {
        var checkRows = table.checkStatus(Manufacturer.tableId);
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
    Manufacturer.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改生产厂商',
            content: Feng.ctxPath + '/manufacturer/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(Manufacturer.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Manufacturer.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/manufacturer/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Manufacturer.tableId);
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
        elem: '#' + Manufacturer.tableId,
        url: Feng.ctxPath + '/manufacturer/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Manufacturer.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Manufacturer.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Manufacturer.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Manufacturer.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Manufacturer.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Manufacturer.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Manufacturer.onDeleteItem(data);
        }
    });
});
