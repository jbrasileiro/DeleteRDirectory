package br.com.core.it;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class TestIntegrationHelper {

    public static final String WAR_NAME = "test-intregation-war.war";
    public static final String JAR_NAME = "test-intregation-jar.jar";
    public static final String EAR_NAME = "test-integration-ear.ear";

    public static TestIntegration getTestIntegration() {
        return new TestIntegration() {

            @Override
            public JavaArchive getJAR() {
                final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, JAR_NAME);
                jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
                return jar;
            }

            @Override
            public WebArchive getWAR() {
                final WebArchive war = ShrinkWrap.create(WebArchive.class, WAR_NAME);
                war.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
                return war;
            }

            @Override
            public EnterpriseArchive getEAR(final JavaArchive jar,
                final WebArchive war) {
                final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, EAR_NAME);
                ear.addAsModule(jar);
                ear.addAsModule(war);
                return ear;
            }
        };
    }

    protected static void createEAR(final JavaArchive ejbJar,
        final WebArchive testWar) {
        final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class);
        ear.setApplicationXML(new StringAsset(applicationXML()));
        ear.addAsModule(ejbJar);
        ear.addAsModule(testWar);
        System.out.println(ear.toString(true));
    }

    private static String applicationXML() {
        final StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        builder.append("<!DOCTYPE xml>");
        builder.append("<application>");
        builder.append("    <display-name>ear</display-name>");
        builder.append("    <module>");
        builder.append("        <ejb>");
        builder.append(JAR_NAME);
        builder.append("        </ejb>");
        builder.append("    </module>");
        builder.append("    <module>");
        builder.append("        <web>");
        builder.append("            <web-uri>");
        builder.append(WAR_NAME);
        builder.append("            </web-uri>");
        builder.append("            <context-root>/test</context-root>");
        builder.append("        </web>");
        builder.append("    </module>");
        builder.append("</application>");
        builder.append("");
        return builder.toString();
    }

}
