<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>content1</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/zsq.css" rel="stylesheet">
    <script type="text/javascript" src="https://raw.githubusercontent.com/wanghetommy/ichartjs/master/ichart.1.2.1.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]-->
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <script type="text/javascript" src="js/ichart.1.2.min.js"></script>
		<%
			ValueStack vs = (ValueStack) request.getAttribute("struts.valueStack");
			//if (vs != null){
				String t = (String) vs.findValue("test");
			//}
			
            %>
    
    <script type="text/javascript">
        $(function(){
            var data = [
				<%
				Map<String, Integer> hC = (Map<String, Integer>)vs.findValue("habitCounts");
				String[] colorList = (String[]) vs.findValue("colorList");
				System.out.println(hC);
				int colorIt = 0;
				for (Map.Entry<String, Integer> entry : hC.entrySet()){
					%>
					{name : '<%=entry.getKey()%>' ,value : <%=entry.getValue().intValue()%>,color:'<%=colorList[colorIt]%>'},
					
					<%
					++colorIt;
				}
				%>


                        
                //{name : 'HTML5&CSS3',value : 30,color:'#fedd74'},
               // {name : 'JavaScript',value : 25,color:'#82d8ef'},
                //{name : 'Java',value : 15,color:'#f76864'},
               // {name : 'XML',value : 20,color:'#80bd91'},
               // {name : 'PhotoShop',value : 10,color:'#fd9fc1'}
            ];

            var chart = new iChart.Donut2D({
                render : 'canvasDiv1',
                center:{
                    text:'Hobby',
                    shadow:true,
                    shadow_offsetx:0,
                    shadow_offsety:2,
                    shadow_blur:2,
                    shadow_color:'#b7b7b7',
                    color:'#6f6f6f'

                },
                data: data,
                offsetx:-10,
                shadow:true,
                border: false,
                separate_angle:10,//分离角度
                tip:{
                    enable:true,
                    showType:'fixed'
                },
                legend : {
                    enable : true,
                    shadow:true,
                    background_color:null,
                    border: false,
                    legend_space:10,//图例间距
                    line_height:34,//设置行高
                    sign_space:10,//小图标与文本间距
                    sign_size:30,//小图标大小
                    color:'#6f6f6f',
                    fontsize:15//文本大小
                },
                sub_option:{
                    label:false,
                    color_factor : 0.3
                },
                showpercent:true,
                decimalsnum:2,
                width : 600,
                height : 400,
                radius:140
            });

            /**
             *利用自定义组件构造左侧说明文本。
             */
            chart.plugin(new iChart.Custom({
                drawFn:function(){
                    /**
                     *计算位置
                     */
                    var y = chart.get('originy');
                    /**
                     *在左侧的位置，设置竖排模式渲染文字。
                     */
                    chart.target.textAlign('center')
                            .textBaseline('middle')
                            .textFont('600 24px 微软雅黑')
                            .fillText('兴趣分析',100,y,false,'#6d869f', 'tb',26,false,0,'middle');

                }
            }));

            chart.draw();
        });

    </script>
    <script type="text/javascript">
        $(function(){
            var pv=[],ip=[],t;
           // for(var i=0;i<24;i++){
          //      t = Math.floor(Math.random()*(30+((i%12)*5)))+10;
          //      //pv.push(t);
         //       t = Math.floor(t*0.5);
          //      t = t-Math.floor((Math.random()*t)/2);
          //      ip.push(t);
         //   }
			<%
				if (vs != null){
					List<Integer> aD = (ArrayList<Integer>)vs.findValue("activityDegree");
					for (Integer i : aD){
						%>
						pv.push(<%=i.intValue()%>);
					
						<%
					}
				}
			%>
			
			
            var data = [
                {
                    name : '微博活跃度',
                    value:pv,
                    color:'#0d8ecf',
                    line_width:2
                }

            ];

            //var labels = ["0:00-1:00","1:00-2:00","2:00-3:00","3:00-4:00","4:00-5:00","5:00-6:00","6:00-7:00","7:00-8:00","8:00-9:00","9:00-10:00",
           //               "10:00-11:00","11:00-12:00","12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00","17:00-18:00","18:00-19:00","19:00-20:00",
            //              "20:00-21:00","21:00-22:00","22:00-23:00","23:00-24:00"];
            var labels = ["0:00","4:00","8:00","12:00","16:00","20:00","24:00"];
            var line = new iChart.LineBasic2D({
                render : 'canvasDiv2',
                data: data,
                align:'center',
                title : '活跃度分析',
                subtitle : '各时段发微博情况',
                footnote : '',
                width : 1000,
                border: false,
                height : 400,
                tip:{
                    enable:true,
                    shadow:true
                },
                legend : {
                    enable : true,
                    row:1,//设置在一行上显示，与column配合使用
                    column : 'max',
                    valign:'top',
                    sign:'bar',
                    background_color:null,//设置透明背景
                    offsetx:-80,//设置x轴偏移，满足位置需要
                    border : true
                },
                crosshair:{
                    enable:true,
                    line_color:'#62bce9'
                },
                sub_option : {
                    label:false,
                    point_hollow : false
                },
                coordinate:{
                    width:640,
                    height:240,
                    axis:{
                        color:'#9f9f9f',
                        width:[0,0,2,2]
                    },
                    grids:{
                        vertical:{
                            way:'share_alike',
                            value:1
                        }
                    },
                    scale:[{
                        position:'left',
                        start_scale:0,
                        end_scale:10,
                        scale_space:1,
                        scale_size:2,
                        scale_color:'#9f9f9f'
                    },{
                        position:'bottom',
                        labels:labels
                    }]
                }
            });

            //开始画图
            line.draw();
        });


    </script>
</head>
<body>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" ><a href="displayMessage.action">最新动态</a></li>
    <li role="presentation" class="active"><a href="#">兴趣分析</a></li>
</ul>

<div class="row">
</div>
<div id='canvasDiv1'></div>

</div>
<br/>
<br/>
<div id='canvasDiv2'></div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
