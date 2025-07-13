$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/cwZr/list',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: 'id', width: 80 },
            { label: '车位信息', name: 'cwInfo', index: 'cwInfo', width: 80 },
            { label: '车位编号', name: 'cwNum', index: 'cwNum', width: 80 },
            { label: '车位用户姓名', name: 'cwUser', index: 'cwUser', width: 80 },
            { label: '转让价格', name: 'zrjg', index: 'zrjg', width: 80 },
            { label: '车位状态', name: 'stu', index: 'stu', width: 80 },
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
            cwInfo: null
        },
        showList: true,
        title: null,
        cwZr: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },

        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.cwZr = {};
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
            alert(vm.cwZr.id);
            var url = vm.cwZr.id == null ? "sys/cwZr/save" : "sys/cwZr/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.cwZr),
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
                    url: baseURL + "sys/cwZr/delete",
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
            $.get(baseURL + "sys/cwZr/info/"+id, function(r){
                vm.cwZr = r.cwZr;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'cwInfo': vm.q.cwInfo},
                page:page
            }).trigger("reloadGrid");
        }
    }
});