<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AJAX登录</title>
</head>
<body>
    <div>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <input type="button" value="登录" id="loginBtn">
    </div>
</body>
<%--<script type="text/javascript" src="js/ajax.js"></script>--%>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
    $(function (){
        $("#loginBtn").click(function (){
            $.ajax({
                url:'login',
                type:'post',
                contentType:'application/x-www-form-urlencoded;charset=UTF-8',
                data:{
                    username:$("#username").val(),
                    password:$("#password").val(),
                },
                success:function (resp){
                    if (resp === "0") {
                        alert("错误")
                    } else {
                        alert("成功")
                    }
                }
            })

        })
    })








    // document.getElementById("loginBtn").onclick=function (){
    //     let username = document.getElementById("username").value.trim();
    //     let password = document.getElementById("password").value.trim();
    //     ajax1({
    //         url:'login',
    //         method:'post',
    //         contentType:'application/x-www-form-urlencoded;charset=UTF-8',
    //         data:{
    //             username:username,
    //             password:password,
    //         },
    //         success:function (resp) {
    //             if (resp === "0") {
    //                 alert("错误")
    //             } else {
    //                 alert("成功")
    //             }
    //         }
    //     })
            // let  xmlHttpRequest;
            // if(window.ActiveXObject){//检查winow中是否存在ActionObject对象
            //     xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP")//微软的IE需要通过这个来获取AJAX核心对象
            // }else {
            //     xmlHttpRequest=new XMLHttpRequest();
            // }
            // xmlHttpRequest.onreadystatechange=function (){
            //     if(xmlHttpRequest.readyState===4) {//4表示已经将服务器传输回来的信息读取完
            //         if (xmlHttpRequest.status === 200) {//HTTP为200表示该请求处理成功
            //             //这里需要对结果进行处理
            //             let result = xmlHttpRequest.responseText.trim();
            //             if (result === "0") {
            //                 alert("错误")
            //             } else {
            //                 alert("成功")
            //             }
            //
            //         }
            //     }
            // }
            // xmlHttpRequest.open("post","login",true);
            // //post发送数据要在send方法中
            // xmlHttpRequest.setRequestHeader('content-type','application/x-www-form-urlencoded;charset=UTF-8')
            // xmlHttpRequest.send("username="+(username)+"&password="+(password));
    // }
</script>
</html>