<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>报价</title>
    <link rel="stylesheet" href="../wzBac/lib/layui/css/layui.css">
    <style>
        .wzListH1{
            padding:10px 0 20px 0;
            font-size: 26px;
            color: #333;
        }
        .priceBox{
        position: fixed; pointer-events: auto;top: 19%;
    left: 30%;
    width: 500px;
    height: 500px;
         overflow-y:auto;
        z-index:1001;
       background:#fff;
       padding:15px;
       border-radius:8px;
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
        <div style="padding: 15px;" class="layui-form">
            <h1 class="wzListH1">报价信息</h1>
            <div class="layui-form-item">
            <button class="layui-btn addPrice">添加报价信息</button>
                 <div class="layui-inline" >
                    <label class="layui-form-label">报价系统</label>
                    <div class="layui-input-block">
	                    <select id="offertype" lay-verify="required">
					        <option value=""></option>
					        <option value="1">android</option>
					        <option value="2">ios</option>
				      	</select>
      				</div>
                </div>
                <div class="layui-inline" >
                    <label class="layui-form-label">报价地区</label>
                    <div class="layui-input-block">
	                    <select id="cityid" lay-verify="required">
					        <option value=""></option>
					       
					        
				     	 </select>
                	</div>
                </div>
                 <div class="layui-inline" >
	                    <label class="layui-form-label">商家名称</label>
	                    <div class="layui-input-inline" style="width: 120px;">
	                        <input type="text" id="shopname" autocomplete="off" class="layui-input" >
	                    </div>
	                </div>
	                <div class="layui-inline">
	                    <button class="layui-btn layui-btn-normal" onclick="search()">搜索</button>
	                </div>
            <table class="layui-hide" id="wzTable" lay-filter="test"></table>
            <script type="text/html" id="barDemo">
            <button class="layui-btn layui-btn-xs "  lay-event="del">删除</button>
            <button class="layui-btn layui-btn-xs "  lay-event="edit">修改</button>
	</script>
        </div>
    </div>
	<div class="layui-layer-shade bgOver"  style="z-index: 1000; background-color: rgb(0, 0, 0); opacity: 0.3;position: fixed; pointer-events: auto;top: 0;left: 0; width: 100%;height: 100%;display:none;"></div>
    <form class="layui-form"  lay-filter="priceBoxBody">
    <input type="hidden"  name="myid" id="offerid">
    <div class="priceBox layui-form" style="display:none;">
    <div class="layui-form-item">
      <h1 class="">报价/添加/修改</h1>
    </div>
     	<div class="layui-form-item">
		    <div class="layui-input-block">
		      <input type="radio" name="radiooffertype" value="1" id="addtype" title="安卓报价">
		      <input type="radio" name="radiooffertype" value="2" id="addtype1" title="苹果报价">
		    </div>
 		</div>
 	 <div class="layui-form-item">
    <label class="layui-form-label">报价地区</label>
    <div class="layui-input-inline">
     <select id="cityid1" name="hotid" lay-verify="required">
	    <option value=""></option>
	 </select>
    </div>
    </div>
    	<div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label">商家名称</label>
		      <div class="layui-input-inline">
		        <input type="tel" name="shopname" id="addshopname" lay-verify="required" autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
		      <label class="layui-form-label">商家图片</label>
		      <div class="layui-input-inline">
		        <button type="button" class="layui-btn" id="addshoppic">
                    <i class="layui-icon">&#xe67c;</i>选择文件
               </button>
                <input type="text" name="shoppicture"  id="addshoppicbase456" lay-verify="required" autocomplete="off" class="layui-input">
              <!--   <a href="" id="home_shop_com" target="view_window">查看图片</a> -->
		      </div>                                     
		    </div>
		   
		     <div class="layui-inline">
		      <label class="layui-form-label">报价标题</label>
		      <div class="layui-input-inline">
		        <input type="text" name="offertitle" id="addtitle" lay-verify="required" autocomplete="off" class="layui-input">
		      </div>
		    </div>
		     <div class="layui-inline">
				      <label class="layui-form-label">联系方式</label>
				      <div class="layui-input-inline">
				        <input type="text" name="phone" id="addphone" lay-verify="required|phone|number" autocomplete="off" class="layui-input">
				      </div>
		    </div>
		    
		     <div class="layui-inline">
		      <label class="layui-form-label">详细地址</label>
				      <div class="layui-input-inline">
				        <input type="text" name="address" id="address" lay-verify="required" autocomplete="off" class="layui-input">
				      </div>
		    </div>
		    
		    <div class="layui-inline">
		      <label class="layui-form-label">报价单</label>
		      <div class="layui-input-inline">
		         <button type="button" class="layui-btn" id="addquotation">
                    <i class="layui-icon">&#xe67c;</i>选择文件
               </button>
                <input type="text" name="quotation" id="addquotationbase123" lay-verify="required" autocomplete="off" class="layui-input">
               <!--  <a href="" id="home_quota_com" target="view_window">查看图片</a> -->
		      </div>
		    </div>
  		</div>
  		 <div class="layui-form-item">
              <div class="layui-input-block">
             <button class="layui-btn subPrice" lay-submit lay-filter="formDemo">立即提交</button>
             <button type="reset" class="layui-btn layui-btn-primary">重置</button>
             </div>
  </div>
    </div>
</form>
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
                ,{field: 'offertype', title: '报价系统',toolbar:'#offertypetemp'}
                ,{field: 'hotcityname', title: '报价地区'}
                ,{field: 'shopname', title: '商家名称'}
                ,{field: 'shoppicture', title: '商家图片',toolbar: '<div><a href="{{d.shoppicture}}" target="_blank ">查看图片</a></div>'}
                ,{field: 'offertitle', title: '报价标题'}
                ,{field: 'phone', title: '联系方式'}
                ,{field: 'address', title: '详细地址'}
                ,{field: 'quotation', title: '报价单',toolbar: '<div><a href="{{d.quotation}}" target="_blank ">查看图片</a></div>'}
                ,{field: 'temp', title: '操    作',toolbar: '#barDemo'}
            ];
    function search(){
    	var bao = $("#offertype").val();
    	var city = $("#cityid").val();
    	var shopname = $("#shopname").val();
         layui.use(['element','table','laydate'], function(){
            var table = layui.table;
            var element = layui.element;
            
           
            table.render({
                elem: '#wzTable'
                ,cellMinWidth: 80 
                ,url:'../manageWB/queryoffer'//全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,cols: [arr]
                ,where:{shopname:shopname,hotid:city,offertype:bao}
//              ,skin: 'line' //表格风格
                ,even: true
                ,page: true //是否显示分页
              //,limits: [5, 7, 10]
                ,limit: 10 //每页默认显示的数量
            });
            //监听行单击事件（单击事件为：rowDouble）
           
        }); 
    }
   
   
    layui.use(['element','upload','table','laydate','layer'], function(){
    	var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var element = layui.element;
        var upload = layui.upload;
        
 
        
        
        
        
        
        table.render({
             elem: '#wzTable'
            ,cellMinWidth: 80 
             ,url:'../manageWB/queryoffer'   //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [arr]
           // ,where:{name:company,stime:stime,etime:etime}
//            ,skin: 'line' //表格风格
            ,even: true
            ,page: true //是否显示分页
            //,limits: [5, 7, 10]
            ,limit: 10 //每页默认显示的数量
        });
        //监听行单击事件（单击事件为：rowDouble）
      	$('.addPrice').click(function(){
      		$("#offerid").val("");
      		$('.priceBox').show();
      		$('.bgOver').show();
      		
      	});
        var uploadInst = upload.render({
            elem: '#addshoppic' //绑定元素
            ,url: '../manageWB/offeruploadpic' //上传接口
            ,accept:'images'
            ,field:'file'
            ,drag:true
            ,done: function(res){
            	console.log(res);
              //上传完毕回调导入成
              if(res.errorCode == 0){
            	  
            	  $("#addshoppicbase456").val(res.result);
              }else{
            	  layer.msg(res.errorMessage);
              }
            }
            ,error: function(){
              //请求异常回调
            	ayer.msg("网络连接失败,请从新开始");
            }
          });
        var uploadInst = upload.render({
            elem: '#addquotation' //绑定元素
            ,url: '../manageWB/offeruploadpic' //上传接口
            ,accept:'images'
            ,field:'file'
            ,drag:true
            ,done: function(res){
            	console.log(res);
              //上传完毕回调导入成
              if(res.errorCode == 0){
	              $("#addquotationbase123").val(res.result);
              }else{
            	  layer.msg(res.errorMessage);
              }
            }
            ,error: function(){
              //请求异常回调
            	ayer.msg("网络连接失败,请从新开始");
            }
          });
      	 //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
          var data = obj.data //获得当前行数据
          ,layEvent = obj.event; //获得 lay-event 对应的值
          if(layEvent === 'detail'){
            layer.msg('查看操作');
          } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
              obj.del(); //删除对应行（tr）的DOM结构
              layer.close(index);
              //向服务端发送删除指令
              $.ajax({
            	     type:"post"
            	     ,url:"../manageWB/editffer"
                     ,dataType:"json"
                     ,data:{id:data.id,status:3}
                     ,success:function(data){
                    	  if(data.errorCode != 0){
                    		  layer.msg(data.errorMessage);
                    	  }else{
                    		  layer.msg("删除成功");
                    	 form.render();//需要渲染一下
                    	  }
                    	 
                     }
              })	
              
            });
          } else if(layEvent === 'edit'){
        	  $('.priceBox').show();
        		$('.bgOver').show();
        	  form.val("priceBoxBody", {
        		   "shopname": data.shopname,// "name": "value"
        		   "shoppicture":data.shoppicture,
        		    "offertitle":data.offertitle,
        		    "phone":data.phone,
        			"address":data.address,
        			"quotation":data.quotation,
        			"hotid":data.hotid,
        			"radiooffertype":data.offertype+"",
        			"myid":data.id
        		})
        	  
           
          }
        });
      
        
        //监听提交
      /*   form.on('submit(formDemo)', function(data){
          layer.msg("成功");
          // console.log(data);
          return true;
        }); */
        
        //监听行单击事件（单击事件为：rowDouble）
      	$('.subPrice').click(function(){
      		
      	  
      		var options=$("#cityid1 option:selected"); 
      		var 	url = null;
      		var id = $("#offerid").val();
      		var addtype = $("input[name='radiooffertype']:checked").val();
      		var cityid1 = options.val();
      		var cityname = options.text();
      		var addtitle = $("#addtitle").val();
      		var addshopname = $("#addshopname").val();
      		var addphone = $("#addphone").val();
      		var address = $("#address").val();
      		var addquotation = $("#addquotationbase123").val();
      		var addshoppic = $("#addshoppicbase456").val();
      		/* $('#home_shop_com').attr('href',addshoppic);
      		$('#home_quota_com').attr('href',addquotation); */
      		if(id == null || id == ""){
      			url = "../manageWB/addoffer";
      		}else{
      			url = "../manageWB/editffer";
      		}
      		if(cityid1== "" ||addtype == null ||cityid1== null || addtitle== null || addshopname== null ||  addphone== null || address== null || addquotation== null || addshoppic== null ){
      			layer.msg('参数不能为空');
      			return false;
      		}
      		
      		 $.ajax({
        	     type:"post"
        	     ,url:url
                 ,dataType:"json"
                 ,data:{id:id,hotid:cityid1,hotcityname:cityname,shopname:addshopname,offertitle:addtitle,offertype:addtype,phone:addphone,address:address,quotation:addquotation,shoppicture:addshoppic}
                 ,success:function(data){
                	  if(data.errorCode != 0){
                		  layer.msg(data.errorMessage);
                	  }else{
                		  layer.msg("成功");
                		  $('.priceBox').hide();
                    		$('.bgOver').hide();
                    		window.location.reload();
                	  }
                	 
                 }
          })	
      	});

      	$('.bgOver').click(function(){
      		$('.priceBox').hide();
      		$('.bgOver').hide();
      		
      	});
      
      	
      	 $.ajax({
    	     type:"get"
    	     ,url:"../manageWB/queryHotcity"
             ,dataType:"json"
             ,success:function(data){
            	
            	 console.log(data);
            	 var html = '';
            	 $.each(data,function(index,item){
            		 html += '<option value='+item.id+'>'+item.hotcityname+'</option>';
            	 })
            	  console.log(html);
            	 $("#cityid").append(html);
            	 $("#cityid1").append(html);
            	 form.render();//需要渲染一下
             }
      })
    });

</script>
	<script type="text/html" id="zizeng">
    {{d.LAY_TABLE_INDEX+1}}
	</script>
	<script type="text/html" id="offertypetemp">
        {{#if (d.offertype == 1) { }}
         <span>安卓(android)</span>
        {{# }else if(d.offertype == 2){ }}
        <span>苹果(ios)</span>
        {{# } }}
       
	</script>
	

</body>
</html>