package cn.java18.sys.annotation;

import org.springframework.context.annotation.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RoleAnnotation {
   //标识，执行某个方法标识的权限id
   int [] value();
}
