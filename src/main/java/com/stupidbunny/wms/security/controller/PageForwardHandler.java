package com.stupidbunny.wms.security.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面重定向
 *
 * @author Stupidbunny
 * @since 2017/2/27.
 */
@RequestMapping("/")
@Controller
public class PageForwardHandler {

    /**
     * 内部重定向到登陆页面
     *
     * @return 跳转的 jsp
     */
    @RequestMapping("login")
    public String loginPageForward() {
        // 判断当前用户是否已经登陆
        Subject currentSubject = SecurityUtils.getSubject();
        if (!currentSubject.isAuthenticated())
            return "login";
        else
            return "WMS/mainPage";
    }

    /**
     * 内部重定向到主页面
     *
     * @return 跳转的 jsp
     */
    @RequestMapping("mainPage")
    public String showLoginView() {
        Subject currentSubject = SecurityUtils.getSubject();
        if (!currentSubject.isAuthenticated())
            return "login";
        else
        	return "mainPage";
    }
}
