
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表格刷新</title>
</head>
<body>
<input type="text" id="region">

<input type="button" value="查询" id="search">
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>编号</th>
    <th>名称</th>
    <th>区域</th>
  </tr>
  </thead>
  <tbody id="dataBox"></tbody>
</table>
</body>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
  $(function (){
    $("#search").click(function (){
      //发送get方式的请求·
      //使用定位的元素去加载searchAgents这个请求的处理结果
      // $("#dataBox").load("searchAgents?region="+$("#region").val())
      $.ajax({
        url:'searchAgents',
        type:'get',
        data:{
          region:$('#region').val(),
        },
        // dataType:"application/json",//这个说明服务器端必须返回一个json格式的数据否则前端会报错
        success:(function (resp){
          let tbody=$("#dataBox");
          tbody.empty();//既然是刷新，首先要清空tbody的所有内容
          for(let i=0;i<resp.length;i++){
            let tr=$("<tr></tr>")
            tr.append($("<td>"+resp[i].aid+"<td>"))
            tr.append($("<td>"+resp[i].ano+"<td>"))
            tr.append($("<td>"+resp[i].aname+"<td>"))
            tr.append($("<td>"+resp[i].aregion+"<td>"))
            tbody.append(tr);
          }
          console.log(resp)
        })
      })

    });
  })
</script>
</html>
