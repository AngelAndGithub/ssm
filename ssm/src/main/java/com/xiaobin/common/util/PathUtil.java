package com.xiaobin.common.util;

import java.net.URISyntaxException;

/**
 * java类获取web应用的根目录
 * @author xiaobin
 * @version 1.0, 2017-11-15 9:40
 */
public class PathUtil {

    /**
     * 获取应用根目录
     * @return
     */
    public String getWebClassesPath(){
        String path = "";
        try {
            path = getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            if(path.startsWith("/")){
                path = path.substring(1,path.length());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 获取应用WEB-INF目录路径
     * @return
     * @throws IllegalAccessException
     */
    public String getWebInfPath() throws IllegalAccessException {
        String path = getWebClassesPath();
        if(path.indexOf("WEB-INF") > 0){
            path = path.substring(0,path.indexOf("WEB-INF") + 8);
        }else{
            throw new IllegalAccessException("路径获取错误");
        }
        return path;
    }

    /**
     * 获取应用WEB-INF/classes目录路径
     * @return
     * @throws IllegalAccessException
     */
    public String getWebRoot() throws IllegalAccessException {
        String path = getWebClassesPath();
        if(path.indexOf("WEB-INF") > 0){
            path = path.substring(0,path.indexOf("WEB-INF/classes"));
        }else {
            throw new IllegalAccessException("路径获取错误");
        }
        return path;
    }

    private String trim(String str){
        if(str.startsWith("/") || str.startsWith("\\")){
            str = str.substring(1);
            trim(str);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        PathUtil p = new PathUtil();
        System.out.println(p.getWebClassesPath());
        System.out.println(p.getWebInfPath());
        System.out.println(p.getWebRoot());
    }

}
