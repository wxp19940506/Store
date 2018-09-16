package com.trvqd.store.web.servlet;

import com.trvqd.store.domain.User;
import com.trvqd.store.service.UserService;
import com.trvqd.store.service.serviceImpl.UserServiceImp;
import com.trvqd.store.utils.MailUtils;
import com.trvqd.store.utils.MyBeanUtils;
import com.trvqd.store.utils.UUIDUtils;
import com.trvqd.store.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {
    public String registUI(HttpServletRequest request, HttpServletResponse response){
        return "/jsp/register.jsp";
    }


    public String userRegist(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        MyBeanUtils.populate(user,map);
        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setCode(UUIDUtils.getCode());
        System.out.println(user.toString());
        //调用业务层注册功能
        UserService service = new UserServiceImp();
        try {
            service.userRegister(user);
            //注册成功，发生邮件
            MailUtils.sendMail(user.getEmail(),user.getCode());
            request.setAttribute("msg","用户注册成功，请激活！");
        }catch (Exception e){
            request.setAttribute("msg","用户注册失败，请重新注册！");

        }

        return "/jsp/info.jsp";
    }

}
