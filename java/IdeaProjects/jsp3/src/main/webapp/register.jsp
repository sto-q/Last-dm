<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>用户注册</title>
</head>
<body>
<form action="" method="post">
  <div>
    <span> 用户名:</span>
    <input type="text" name="username" id="username">
    <span  id="tip"> </span>
  </div>
</form>
</body>
<%--<script type="text/javascript" src="js/ajax.js"></script>--%>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(function (){
  $("#username").blur(function (){
    $.ajax({
      url:'checkUsername',
      method:'get',
      data:{
        username:$("#username").val(),
      },
      success:function (resp){
          let tip=$("#tip")
                if (resp === '1') {
                  tip.text("账号已经注册");
                  tip.css("color","red");
                } else {
                  tip.text("账号可以注册");
                  tip.css("color","green");
                }
        }
    })
  })
})


  // let element=document.getElementById("username");
  //为username元素添加一个失去焦点的事件
  // element.onblur=function (){
  //
  //   let value=element.value;
  //   if(value !== ''){
  //
  //     ajax1({
  //       url:'checkUsername',
  //       method:'GET',
  //       data:{
  //         username:value,
  //       },
  //       success:function (resp){
  //           let tip=document.getElementById("tip")
  //                 if (resp === '1') {
  //                   tip.innerText = "账号已经注册";
  //                   tip.style.color = "red";
  //                 } else {
  //                   tip.innerText = "该账户可以注册";
  //                   tip.style.color = "green";
  //                 }
  //         }
  //     })
      // let  xmlHttpRequest;
      // if(window.ActiveXObject){//检查winow中是否存在ActionObject对象
      //   xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP")//微软的IE需要通过这个来获取AJAX核心对象
      // }else {
      //   xmlHttpRequest=new XMLHttpRequest();
      // }
      // xmlHttpRequest.onreadystatechange=function (){
      //   if(xmlHttpRequest.readyState===4){//4表示已经将服务器传输回来的信息读取完
      //     if(xmlHttpRequest.status===200){//HTTP为200表示该请求处理成功
      //       let tip=document.getElementById("tip")
      //       //这里需要对结果进行处理
      //       let result = xmlHttpRequest.responseText.trim();
      //
      //       if (result === '1') {
      //         tip.innerText = "账号已经注册";
      //         tip.style.color = "red";
      //       } else {
      //         tip.innerText = "该账户可以注册";
      //         tip.style.color = "green";
      //       }
      //
      //     }
      //
      //   }
      // }
      // //get发送数据的方式是在URL后面进行数据拼接
      // xmlHttpRequest.open("get","checkUsername?username="+ value,true);
      // //这个表示发送数据get请求方式直接为空即可
      // xmlHttpRequest.send();
    // }
  // }
</script>
</html>