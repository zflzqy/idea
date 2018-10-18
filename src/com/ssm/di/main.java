package com.ssm.di;

import com.ssm.di.bean.FatherUser;
import com.ssm.di.bean.User;
import com.ssm.di.controller.UserController;
import com.ssm.di.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

public class main {
    public  static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("./com/ssm/di/config/application-context.xml");
        // 这里的参数为xml文件里的唯一id（普通注入）
//        User user = (User) context.getBean("user");
//        System.out.println(user.getId());
//        System.out.println(user.getName());

//        FatherUser fatherUser = (FatherUser) context.getBean("fatherUser");
//        System.out.println(fatherUser.getFatherName());
//        System.out.println(fatherUser.getUser().getName()+"         "+fatherUser.getUser().getId());

        // 注解注入,当不加注解的时候将不会进行包扫描，        扫描器会扫描带有@Component@Service@Controller@Component等注解，
//        @Service  ---业务层
//        @Component  ---公共组件
//        @Controller  --- 控制用户请求的 springMVC
//        @Autowired  ---当要用到bean的时候进行注入不用getBean --controller类
        UserController controller = context.getBean(UserController.class);
        UserService service =controller.getUserService();
        service.say("赵飞龙");
        service.speak("赵飞龙");

    }
}
