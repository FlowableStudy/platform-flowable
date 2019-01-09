package com.fxtcn.platform.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.flowable.ui.common.security.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fxtcn.platform.Const.Const;

public class CustomHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String servletPath = request.getServletPath();

		if (servletPath.endsWith(".css") || servletPath.endsWith(".js") || servletPath.endsWith(".jpg")
				|| servletPath.endsWith(".png")) {
			return true;
		}

		System.out.println(servletPath);
		if (servletPath.startsWith("/app")) {
			User user = new UserEntityImpl();
			user.setId("admin");
			SecurityUtils.assumeUser(user);
		}
		Object obj = request.getSession().getAttribute(Const.SESSION_USER);
		if (obj == null) {
			response.sendRedirect("/");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}