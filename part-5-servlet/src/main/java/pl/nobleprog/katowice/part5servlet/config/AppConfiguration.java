package pl.nobleprog.katowice.part5servlet.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.nobleprog.katowice.part5servlet.servlet.BookServlet;
import pl.nobleprog.katowice.part5servlet.servlet.HomeServlet;

public class AppConfiguration {
//    @Bean
//    public ServletRegistrationBean homeServletBean() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(
//                new HomeServlet(), "/servlet/*");
//        bean.setLoadOnStartup(1);
//        return bean;
//    }
//    @Bean
//    public ServletRegistrationBean bookServletBean() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(
//                new BookServlet(), "/book");
//        bean.setLoadOnStartup(1);
//        return bean;
//    }
}
