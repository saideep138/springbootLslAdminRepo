package com.lsl.packageofdemotsal.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.MODULE;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.RECORD_COMPONENT;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(CLASS)
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER,
		TYPE_USE, MODULE, RECORD_COMPONENT })
public @interface CustAnnote {
	
	public String key() default ""; 
	
	String name(); 
	  
    //Class< ?> type(); 
  
    boolean isPrimaryKey() default false; 

}

/*
 
 @CustAnnote(key = "", name = "id", isPrimaryKey = true, type = Long.class) 
 private long id; 

 
         for (Field field : usr.getClass().getDeclaredFields()) { 
            DBField dbField = field.getAnnotation(DBField.class); 
            System.out.println("field name: " + dbField.name()); 
  
            // changed the access to public 
            field.setAccessible(true); 
            Object value = field.get(usr); 
            System.out.println("field value: " + value); 
  
            System.out.println("field type: " + dbField.type()); 
            System.out.println("is primary: " + dbField.isPrimaryKey()); 
            System.out.println(); 
        } 
 
 
 
 */
