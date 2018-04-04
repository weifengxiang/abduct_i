package org.sky.log;

import java.lang.annotation.*;    

/**
 * 
 * @ClassName:  SysControllerLog   
 * @Description:TODO(Controller自定义注解 拦截)   
 * @author: weifx 
 * @date:   2018年4月4日 下午3:52:56   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface SysControllerLog {    
    
    String desc()  default "";    
    
    
}    