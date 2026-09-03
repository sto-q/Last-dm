package com.in.jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class text {
    public static void main(String[] args) {
//        Class<student> clazz = student.class;
//        try{
//            Constructor<? extends student> C=clazz.getDeclaredConstructor();
//            C.setAccessible(true);
//            student a= clazz.newInstance();
//            Field f1=clazz.getDeclaredField("name");
//            f1.setAccessible(true);
//            f1.set(a,"李四");
//            Field f2=clazz.getDeclaredField("age");
//            f2.set(a,20);
//            String field= f1.getName();
//            String monthname ="get"+field.substring(0,1).toUpperCase()+field.substring(1);
//            Method m1=clazz.getDeclaredMethod(monthname);
//            m1.setAccessible(true);
//            String name= (String) m1.invoke(a);
//            System.out.println(name);
//
//            monthname="set"+field.substring(0,1).toUpperCase()+field.substring(1);
//            Method m2=clazz.getDeclaredMethod(monthname,f1.getType());
//            m2.setAccessible(true);
//            m2.invoke(a,"lmq");
//            System.out.println(a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        getMethod();
//        getField();
//        getConstructor();
getClazz();
    }
    public static void getMethod(){
        Class<student> clazz = student.class;
        Method[] methods=clazz.getDeclaredMethods();
        for(Method m:methods){
            System.out.print(m.getModifiers()+" ");
            System.out.print(m.getName()+"(");
            Class[] types=m.getParameterTypes();
            for(Class c:types){
                System.out.print(c.getName()+",");
            }
            System.out.println(")");
        }
        System.out.println("==========================");
        try{
            Method method =clazz.getDeclaredMethod("setName",String.class);
            System.out.print(method.getModifiers()+" ");
            System.out.print(method.getName()+"(");
            Class[] types=method.getParameterTypes();
            for(Class c:types){
                System.out.print(c.getName()+",");
            }
            System.out.println(")");
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }
    public static void getField(){
        Class<student> clazz = student.class;
        Field[] fields=clazz.getDeclaredFields();
        for(Field f:fields){
            System.out.print(f.getModifiers()+" ");
            System.out.print(f.getName()+"(");
            System.out.print(f.getType().getName()+",");
        }
        System.out.println(")");
        System.out.println("===========================");
        try{
            Field f=clazz.getDeclaredField("name");
            System.out.print(f.getModifiers()+" ");
            System.out.print(f.getType().getName()+",");
            System.out.print(f.getName()+" ");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
     private static void getConstructor(){
        Class<student> clazz = student.class;
        Constructor[] constructors=clazz.getDeclaredConstructors();
        for(Constructor c:constructors){
            System.out.println(c.getModifiers());
            String name=c.getName();
            Class[] types=c.getParameterTypes();
            System.out.print(name+",");
            System.out.print(Arrays.toString(types));
        }
        System.out.println("===============================");
        try{
            Constructor constructor=clazz.getConstructor(String.class,int.class);
            System.out.print(constructor.getModifiers());
            String name=constructor.getName();
            Class[] types=constructor.getParameterTypes();
            System.out.print(name+",");
            System.out.print(Arrays.toString(types));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
     }
    private static void getClazz(){
        Class<student> c1 = student.class;
        System.out.println(c1.getName());
        student stu=new student("Aa",20);
        Class<? extends student> c2=stu.getClass();
        System.out.println(c2.getName());
        Class<? super student> c3=c1.getSuperclass();
        System.out.println(c3.getName());
        try{
            Class c4=Class.forName("com.in.jdbc.student");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Class c5=Integer.TYPE;
        Class c6=int.class;
        System.out.println(c5.getName());
        System.out.println(c6.getName());
    }
}
