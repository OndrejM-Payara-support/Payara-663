Test app to reproduce for https://github.com/payara/Payara/issues/663

# Preconditions:

- disable implicit CDI in Payara ( asadmin set configs.config.server-config.cdi-service.enable-implicit-cdi=false )
 
# Test steps:

1. Deploy the tet app
1. Observe that deployment fails with message similar to following:

    The lifecycle method [postConstruct] must not throw a checked exception. Related annotation information: 
    annotation [@javax.annotation.PostConstruct()] on annotated element 
    [public void payara.testapps.github663.AbstractClassWithChekedExcInPostConstruct.postConstruct() throws java.lang.Exception] of type [METHOD]

1. the exception is triggered in com.sun.enterprise.deployment.annotation.handlers.PostConstructHandler.processAnnotation(AnnotationInfo, ResourceContainerContext[]), 
when calling validateAnnotatedLifecycleMethod().

# Desired behavior

Application is deployed correctly and Hello World! page is displayed for root context path. The class with @PostConstruct annotation is not validated, 
as it is not used in CDI or any othe Java EE mechanism.