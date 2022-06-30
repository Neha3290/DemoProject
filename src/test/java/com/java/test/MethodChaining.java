package com.java.test;

public class MethodChaining {

    public static MethodChaining a1(){
            System.out.println("I am in a1");
            return new MethodChaining();
    }

    public static MethodChaining a2(){
        System.out.println("I am in a2");
      return new MethodChaining();
    }

        public static MethodChaining a3(){
        System.out.println("I am in a3");
        return new MethodChaining();
    }

}
