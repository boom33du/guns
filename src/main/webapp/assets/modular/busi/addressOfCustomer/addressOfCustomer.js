layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 客户地址表管理
     */
    var AddressOfCustomer = {
        tableId: "addressOfCustomerTable"
    };

    /**
     * 初始化表格的列
     */
    AddressOfCustomer.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'customerinfoId', sort: true, title: '所属客户主键，外键'},
            {field: 'addresscontent', sort: true, title: '地址内容'},
            {field: 'addresstypeId', sort: true, title: '地址类型主键，外键'},
            {field: 'temp', sort: true, title: '备注'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    AddressOfCustomer.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(AddressOfCustomer.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    AddressOfCustomer.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加客户地址表',
            content: Feng.ctxPath + '/addressOfCustomer/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(AddressOfCustomer.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    AddressOfCustomer.exportExcel = function () {
        var checkRows = table.checkStatus(AddressOfCustomer.tableId);
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
    AddressOfCustomer.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改客户地址表',
            content: Feng.ctxPath + '/addressOfCustomer/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(AddressOfCustomer.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    AddressOfCustomer.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/addressOfCustomer/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(AddressOfCustomer.tableId);
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
        elem: '#' + AddressOfCustomer.tableId,
        url: Feng.ctxPath + '/addressOfCustomer/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: AddressOfCustomer.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        AddressOfCustomer.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        AddressOfCustomer.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        AddressOfCustomer.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + AddressOfCustomer.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            AddressOfCustomer.openEditDlg(data);
        } else if (layEvent === 'delete') {
            AddressOfCustomer.onDeleteItem(data);
        }
    });
});
