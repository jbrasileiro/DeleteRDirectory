package br.com.core.it;

import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;


public abstract class AbstractTestIntegration {

    protected static JavaArchive getJAR() {
        return TestIntegrationHelper.getTestIntegration().getJAR();
    }
    
    protected static WebArchive getWAR() {
        return TestIntegrationHelper.getTestIntegration().getWAR();
    }
    
    protected static EnterpriseArchive getEAR(JavaArchive jar,
        WebArchive war) {
        return TestIntegrationHelper.getTestIntegration().getEAR(jar, war);
    }
}
