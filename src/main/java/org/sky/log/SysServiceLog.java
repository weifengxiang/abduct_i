package org.sky.log;
import java.lang.annotation.*;    

  
/**
 *     
 * @ClassName:  SysServiceLog   
 * @Description:TODO(Service自定义注解 拦截)   
 * @author: weifx 
 * @date:   2018年4月4日 下午3:53:40   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface SysServiceLog {    
    
    String desc()  default "";    
    
    
}  