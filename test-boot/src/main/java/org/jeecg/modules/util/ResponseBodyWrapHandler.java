package org.jeecg.modules.util;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
/**
* @author suntongxin
* Create on 2017年12月12日上午10:48:54
* All right reserved
*/
//6、实现具体的统一json返回处理
public class ResponseBodyWrapHandler implements HandlerMethodReturnValueHandler{

private final HandlerMethodReturnValueHandler delegate;

public ResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate){

this.delegate = delegate;

}

@Override
public boolean supportsReturnType(MethodParameter returnType) {

return delegate.supportsReturnType(returnType);

}

@Override
public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
NativeWebRequest webRequest) throws Exception {
RtnMsg rtnMsg = null;
if(returnValue instanceof RtnMsg){
rtnMsg = (RtnMsg)returnValue;
}else{
rtnMsg = new RtnMsg(RtnCode.STATUS_OK,"",returnValue);
}

delegate.handleReturnValue(rtnMsg, returnType, mavContainer, webRequest);;


}

}
