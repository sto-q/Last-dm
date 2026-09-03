// function ajax(option){
//     ajax1(option.url,option.method,option.data,option.contentType,option.success,option.error)
// }
//
//

function ajax1(option){
        let xmlHttpRequest;
        if (window.ActiveXObject) {//检查winow中是否存在ActionObject对象
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");//微软的IE需要通过这个来获取AJAX核心对象
        } else {
            xmlHttpRequest = new XMLHttpRequest();
        }
        xmlHttpRequest.onreadystatechange = function () {
            if (xmlHttpRequest.readyState === 4) {//4表示已经将服务器传输回来的信息读取完

                if (xmlHttpRequest.status >= 200&&xmlHttpRequest.status<300) {//HTTP为200表示该请求处理成功
                    //这里需要对结果进行处理
                    let result = xmlHttpRequest.responseText.trim();

                    if (typeof option.success=== 'function') {
                        option.success(result);
                    }else {
                        if (typeof option.error === 'function') {
                            option.error(xmlHttpRequest.responseText);
                        }
                    }
                }
            }
        }
        if(option.method.toLowerCase()==="get"){
            let param="?";
            let keys=Object.keys(option.data);//获取对象所有属性名形成集合
            keys.forEach(key=>{
                param+=key+"="+option.data[key]+"&";
            })
            param=param.substring(0,param.length-1);
            option.url+=param;
        }
        //get发送数据的方式是在URL后面进行数据拼接
        xmlHttpRequest.open(option.method, option.url, true);
    let dataInfo=null;
        if(option.contentType){//contentType不存在就设置请求头
            xmlHttpRequest.setRequestHeader('content-type',option.contentType);
            if(option.method.toLowerCase()!=='get'){
                dataInfo=option.data;
                if(option.contentType&&option.contentType.indexOf('application/x-www-form-urlencoded')>=0){
                let param="";
                let keys=Object.keys(option.data);//获取对象所有属性名形成集合
                keys.forEach(key=>{
                    param+=key+"="+option.data[key]+"&";
                })
                param=param.substring(0,param.length-1);
                dataInfo=param;
                }
            }
        }
    //这个表示发送数据get请求方式直接为空即可
    xmlHttpRequest.send(dataInfo);
}
