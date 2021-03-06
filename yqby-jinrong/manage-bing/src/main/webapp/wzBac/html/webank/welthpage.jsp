<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>微众</title>
    <link rel="stylesheet" href="../wzBac/lib/layui/css/layui.css">
    <style>
        .wzListH1{
            padding:10px 0 20px 0;
            font-size: 26px;
            color: #333;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">

    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->

        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <h1 class="wzListH1">微众财富发放记录</h1>
            <div class="layui-form-item">
                 <div class="layui-inline" >
                    <label class="layui-form-label">公司名称</label>
                    <div class="layui-input-inline" style="width: 120px;">
                        <input type="text" id="company" autocomplete="off" class="layui-input" >
                    </div>
                </div>
                <div class="layui-inline" >
                    <label class="layui-form-label">门店名称</label>
                    <div class="layui-input-inline" style="width: 120px;">
                        <input type="text" id="store" autocomplete="off" class="layui-input" >
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发放时间</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="st" placeholder="开始时间">
                    </div>
                    <div class="layui-form-mid">-</div>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="et" placeholder="结束时间">
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btn-normal" onclick="search()">搜索</button>
                </div>

                </div>
            <table class="layui-hide" id="wzTable"></table>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="../wzBac/js/jquery-3.2.1.min.js"></script>
<script src="../wzBac/js/common.js"></script>
<script src="../wzBac/lib/layui/layui.js"></script>
<script>
   

    //JavaScript代码区域
    var arr = [ //标题栏
                 {field: 'sid', title: '序号', width: 80, sort: true,templet:'#zizeng'}
                ,{field: 'storeName', title: '门店名称'}
                ,{field: 'storeCode', title: '门店ID'}
                ,{field: 'storeUsername', title: '店长名称'}
                ,{field: 'phone', title: '注册手机号'}
                ,{field: 'beInvited', title: '公司名称'}
                ,{field: 'money', title: '已启用额度'}
                ,{field: 'wealth', title: '已发放财富'}
                ,{field: 'updateTime', title: '发放时间', sort: true}
            ];
    function search(){
    	var company=$("#company").val();
    	var store=$("#store").val();
        var stime = $("#st").val();
        var etime = $("#et").val();
        
         layui.use(['element','table','laydate'], function(){
            var table = layui.table;
            var element = layui.element;
            var laydate = layui.laydate;
            
            laydate.render({
                elem: '#st'
            });
            laydate.render({
                elem: '#et'
            });
            table.render({
                elem: '#wzTable'
                ,cellMinWidth: 80 
                ,url:'../manageWB/queryWelth'//全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,cols: [arr]
                ,where:{company:company,store:store,stime:stime,etime:etime}
//              ,skin: 'line' //表格风格
                ,even: true
                ,page: true //是否显示分页
              //,limits: [5, 7, 10]
                ,limit: 10 //每页默认显示的数量
            });
            //监听行单击事件（单击事件为：rowDouble）
           
        }); 
    }
   
    	
    layui.use(['element','table','laydate'], function(){
        var table = layui.table;
        var element = layui.element;
        var laydate = layui.laydate;
        
        laydate.render({
            elem: '#st'
        });
        laydate.render({
            elem: '#et'
        });
        table.render({
            elem: '#wzTable'
            ,cellMinWidth: 80 
            ,url:'../manageWB/queryWelth'    //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [arr]
           // ,where:{name:company,stime:stime,etime:etime}
//            ,skin: 'line' //表格风格
            ,even: true
            ,page: true //是否显示分页
            //,limits: [5, 7, 10]
            ,limit: 10 //每页默认显示的数量
        });
        //监听行单击事件（单击事件为：rowDouble）
       
    });
 
</script>
<script type="text/html" id="zizeng">
    {{d.LAY_TABLE_INDEX+1}}
</script>
</body>
</html>