package com.ribomation.jmxagent;

public interface JMXStartupStubMBean {
    public String getDescription();
    public void start() throws Throwable;
    public  void stop() throws Exception;
}
