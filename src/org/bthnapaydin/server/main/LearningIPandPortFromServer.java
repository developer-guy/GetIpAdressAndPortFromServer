package org.bthnapaydin.server.main;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by bapaydin on 30.08.2016.
 */
public class LearningIPandPortFromServer {
    public static void main(String[] args) throws UnknownHostException, MalformedObjectNameException {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();

        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));

        String host = InetAddress.getLocalHost().getHostAddress();
        String port = objectNames.iterator().next().getKeyProperty("port");

        System.out.println("IP Address of System : "+host );
        System.out.println("port of tomcat server : "+port);
    }
}
