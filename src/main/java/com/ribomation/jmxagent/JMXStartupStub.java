package com.ribomation.jmxagent;

import java.lang.instrument.Instrumentation;
import java.util.HashMap;

import com.wily.introscope.agent.AgentShim;
import com.wily.introscope.agent.IAgent;
import com.wily.introscope.agent.jmx.JMXDelegatingService;
import com.wily.introscope.agent.service.ServiceAdministrator;

public class JMXStartupStub {
    private static final String NAME = "JMX";

    /**
     * Entry point for the java.lang.instrument Agent invocation.
     * @param args
     * @param instrumentation
     */
    public static void premain(String args, Instrumentation instrumentation) {
        try {
            new JMXStartupStub().start();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /**
     * MBean entry point.
     * @throws Throwable
     */
    public void start() throws Throwable {
        IAgent agent = AgentShim.getAgentShim().IAgentShim_getAgent();
        ServiceAdministrator serviceAdministrator = agent.IAgent_getServiceAdministrator();
        serviceAdministrator.registerServiceAsync(agent, NAME, new JMXDelegatingService(), new HashMap());
    }

    /**
     * MBean exit point.
     * @throws Exception
     */
    public void stop() throws Exception {
        //nothing here
    }

    public String getDescription() {
        return "IntroScope Agent JMX Connector";
    }

}
