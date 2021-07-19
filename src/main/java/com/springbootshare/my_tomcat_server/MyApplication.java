package com.springbootshare.my_tomcat_server;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class MyApplication {

  public static void main(String[] args) throws LifecycleException {
    //Config Tomcat
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(Integer.getInteger("port", 8123));
    tomcat.getConnector();
    //Create Webapp
    Context ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
    WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(
        new DirResourceSet(resources, "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/"));
    ctx.setResources(resources);
    //Start Tomcat
    tomcat.start();
    tomcat.getServer().await();
  }
}
