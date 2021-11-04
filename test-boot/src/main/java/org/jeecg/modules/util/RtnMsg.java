package org.jeecg.modules.util;


//1、定义统一返回格式
public class RtnMsg{

private String rtnCode;

private String rtnMsg="";

private Object msg;

public RtnMsg(String rtnCode,String rtnMsg,Object msg){
this.rtnCode = rtnCode;
this.rtnMsg = rtnMsg;
this.msg = msg;
}

public RtnMsg(String rtnCode,String rtnMsg){
this.rtnCode = rtnCode;
this.rtnMsg = rtnMsg;
}

public RtnMsg(){
}

public String getRtnCode() {
return rtnCode;
}

public void setRtnCode(String rtnCode) {
this.rtnCode = rtnCode;
}

public String getRtnMsg() {
return rtnMsg;
}

public void setRtnMsg(String rtnMsg) {
this.rtnMsg = rtnMsg;
}

public Object getMsg() {
return msg;
}

public void setMsg(Object msg) {
this.msg = msg;
}




}
