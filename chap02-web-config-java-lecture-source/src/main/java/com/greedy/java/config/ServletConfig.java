package com.greedy.java.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/* appServlet를 대체할 파일 
 * @EnableWebMvc Configuration + webMvc기능 
 * WebMvcConfigurer웹에 대한 기능을 사용하는 인터페이스
 * ViewResolverRegistry를 등록하기 위한 메소드
 * */

@EnableWebMvc
@ComponentScan(basePackages = {"com.greedy.java"})
public class ServletConfig implements WebMvcConfigurer {

   
   @Override
   public void configureViewResolvers(ViewResolverRegistry registry) {
      
      InternalResourceViewResolver bean = new InternalResourceViewResolver();
      bean.setViewClass(JstlView.class);
      bean.setPrefix("/WEB-INF/views/");
      bean.setSuffix(".jsp");
      
      registry.viewResolver(bean);
   
   }
   
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources");
   }
}