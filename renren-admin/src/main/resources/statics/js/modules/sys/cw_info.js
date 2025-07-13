$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/cwInfo/list',
        datatype: "json",
        colModel: [
            { label: '车位编号', name: 'id', index: 'id', width: 80 },
            { label: '车位名称', name: 'name', index: 'name', width: 80 },
            { label: '用户用户', name: 'username', index: 'username', width: 80 },
            { label: '手机号', name: 'phone', index: 'phone', width: 80 },
            { label: '用户地址', name: 'dizhi', index: 'dizhi', width: 80 },
            { label: '车位类型', name: 'field', index: 'field', width: 80 },
            { label: '车位位置', name: 'cwwz', index: 'cwwz', width: 80 },
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            name: null
        },
        showList: true,
        title: null,
        cwInfo: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },

        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.cwInfo = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },


        saveOrUpdate: function (event) {
            alert("sdadasdasdasdas");
            alert(vm.cwInfo.id);
            var url = vm.cwInfo.id == null ? "sys/cwInfo/save" : "sys/cwInfo/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.cwInfo),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/cwInfo/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(index){
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function(id){
            $.get(baseURL + "sys/cwInfo/info/"+id, function(r){
                vm.cwInfo = r.cwInfo;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
        }
    }
});