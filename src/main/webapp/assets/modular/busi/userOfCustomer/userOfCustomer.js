layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 用户客户对应表管理
     */
    var UserOfCustomer = {
        tableId: "userOfCustomerTable"
    };

    /**
     * 初始化表格的列
     */
    UserOfCustomer.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'customerinfoId', hide: true, title: '客户编号'},
            {field: 'userId', hide: true, title: '分配管理员编号'},
            {field: 'customerinfoName', sort: true, title: '客户'},
            {field: 'userAccount', sort: true, title: '分配管理员账户'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    UserOfCustomer.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(UserOfCustomer.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    UserOfCustomer.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '给客户分配用户',
            content: Feng.ctxPath + '/userOfCustomer/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(UserOfCustomer.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    UserOfCustomer.exportExcel = function () {
        var checkRows = table.checkStatus(UserOfCustomer.tableId);
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
    UserOfCustomer.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改用户客户对应表',
            content: Feng.ctxPath + '/userOfCustomer/edit?userId=' + data.userId,
            end: function () {
                admin.getTempData('formOk') && table.reload(UserOfCustomer.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    UserOfCustomer.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/userOfCustomer/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(UserOfCustomer.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("userId", data.userId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + UserOfCustomer.tableId,
        url: Feng.ctxPath + '/userOfCustomer/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: UserOfCustomer.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        UserOfCustomer.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        UserOfCustomer.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        UserOfCustomer.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + UserOfCustomer.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            UserOfCustomer.openEditDlg(data);
        } else if (layEvent === 'delete') {
            UserOfCustomer.onDeleteItem(data);
        }
    });
});
