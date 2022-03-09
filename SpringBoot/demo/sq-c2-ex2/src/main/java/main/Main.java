package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String args[]){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p = context.getBean("koko",Parrot.class);

        System.out.println(p.getName());

//        Parrot p1 = context.getBean("nuke ",Parrot.class);
//        System.out.println(p1.getName());

        Parrot primary = context.getBean(Parrot.class);
        System.out.println(primary.getName());


        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}
