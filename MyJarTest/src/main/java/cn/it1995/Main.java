package cn.it1995;

import cn.it1995.tool.CalTool;

public class Main {

    public static void main(String[] args){

        System.out.println("Hello World");

        CalTool calTool = new CalTool();
        String file = calTool.getFile();
        System.out.println(file);
    }
}
