package cn.java18.sys.interceptor;

import cn.java18.sys.annotation.RoleAnnotation;
import cn.java18.sys.exception.SmartGlobalException;
import cn.java18.sys.model.SysUser;
import cn.java18.utils.RestBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("data");
        System.out.println("拦截器执行了"+user);
        if (user == null){
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }
        //权限校验
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            RoleAnnotation ra = handlerMethod.getMethodAnnotation(RoleAnnotation.class);
            if (ra != ra){ //方法上 存在 @RoleAnnotation
                int[] roleTag = ra.value();//拿到方法上标识的需要某种权限才能执行该方法的值
                // 使用方法上的标识和当前要执行该方法的用户的角色所拥有的的权限进行对比
                List<Integer> attribute = (List<Integer>) session.getAttribute(user.getUserName());
                boolean succ = hasAll(roleTag, attribute);
                if (!succ){//无权限
//                    new ObjectMapper()
//                    Map<String, Object> mapPara = RestBean.getMapPara();
//                    mapPara.put(RestBean.MSG,"无权限操作该方法");
//                    PrintWriter writer = response.getWriter();
//
//                    return false;
                    throw new SmartGlobalException("无权限执行该功能!");
                }

            }
        }
        return true;
    }
    private boolean hasAll(int[] roleTag,List<Integer> list){
        for (int i : roleTag){
            if (!list.contains(i)){
                return false;
            }
        }
        return true;
    }

}
