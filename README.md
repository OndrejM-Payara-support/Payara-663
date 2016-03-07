Test app to reproduce for https://github.com/payara/Payara/issues/663

# Preconditions:

- disable implicit CDI in Payara ( asadmin set configs.config.server-config.cdi-service.enable-implicit-cdi=false )
 
# Test steps:

1. Deploy the tet app
1. Observer that deployment fails with message similar to following:

    The lifecycle method [something] must not throw a checked exception.
Related annotation information: annotation [@javax.annotation.PostConstruct()] 
on annotated element [public void com.something.MyClass.something() throws 
java.io.IOException] of type [METHOD]. Please see server.log for more details.

1. the exception is triggered in 

# Desired behavior

Application is deployed correctly and Hello World! page is displayed for root context path.