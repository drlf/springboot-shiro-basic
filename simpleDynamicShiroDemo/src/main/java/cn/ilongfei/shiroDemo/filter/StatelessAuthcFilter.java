package cn.ilongfei.shiroDemo.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;

import cn.ilongfei.shiroDemo.realm.StatelessToken;
import cn.ilongfei.shiroDemo.Constants;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-26
 * <p>Version: 1.0
 */
public class StatelessAuthcFilter extends AccessControlFilter {
	//http://www.boyunjian.com/javadoc/org.apache.shiro/shiro-web/1.2.1/_/org/apache/shiro/web/filter/AccessControlFilter.html
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    		System.out.println(getPathWithinApplication(request));
    		
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //1、客户端生成的消息摘要
        String clientDigest = request.getParameter(Constants.PARAM_DIGEST);
        //2、客户端传入的用户身份
        String username = request.getParameter(Constants.PARAM_USERNAME);
        //3、客户端请求的参数列表
        Map<String, String[]> params = new HashMap<String, String[]>(request.getParameterMap());
        params.remove(Constants.PARAM_DIGEST);

        //4、生成无状态Token
        StatelessToken token = new StatelessToken(username, params, clientDigest);

        try {
            //5、委托给Realm进行登录
            getSubject(request, response).login(token);
        } catch (Exception e) {
            e.printStackTrace();
            onLoginFail(response); //6、登录失败
            return false;
        }
        return true;
    }

    //登录失败时默认返回401状态码
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("login error");
    }
}
