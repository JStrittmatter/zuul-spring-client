package org.devnull.client.spring

import org.devnull.client.spring.test.BaseHttpServerIntegrationTest
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by jstrittmatter on 10/3/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ['classpath:test-zuul-client-context.xml'])
@ActiveProfiles("envVar")
class ZuulClientEnvironmentVariableIntegrationTest extends BaseHttpServerIntegrationTest {

    @BeforeClass
    static void setVars() {
        System.setProperty('host', 'localhost');
        System.setProperty('port','8081');
    }

    @Value("\${jdbc.zuul.password}")
    String password

    @Test
    void shouldConnectToServerAndReadPropertiesWithEnvVars(){
        assert password == "thisisatest"

    }
}
