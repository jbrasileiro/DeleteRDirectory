package br.com.core.it;

import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public interface TestIntegration {

    JavaArchive getJAR();

    WebArchive getWAR();

    EnterpriseArchive getEAR(JavaArchive jar,
        WebArchive war);

}
