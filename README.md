#Alfresco JMX from [Loftux AB](https://www.loftux.com)

Brings powerful JMX capabilities to your Alfresco installation (Administrators) and custom modules (Developers).

###Why?

JMX (Java Messaging eXtensions) capabilities have been previously only available to Alfresco Enterprise installations.  This module brings JMX to Alfresco Community edition installations, including installations of [LXCommunity ECM](https://loftux.se/en/products-and-add-ons/lxcommunity).

The existing JMX implementation available with Alfresco Enterprise is based on a proprietary implementation of JMX related beans. Since then, Spring framework has included built-in support for adding annotations to make it easier to develop and build JMX resource and operation exporting beans. 

Compared to the existing implementation, this module is modern and open source. It is also a way of encouraging community contribution towards a scalable and stable infrastructure for everyone who has chosen Alfresco, whether it is Enterprise or Community.

###Installation
- Download the source or checkout the project using `git clone`.
- Package using `mvn package` and deploy the resulting AMP file in your Alfresco.

###Current Status
Currently the module exposes the ability to receive user count and group count using JMX. This is a intended as a basic demonstration of how JMX resources can be exposed.

###Proposed Features
The following features are to be added to the module. If you have are willing, go ahead and create them.

- Adding more statistics providers
- Adding support for modifying system properties and properties defined using alfresco-global.properties
- Adding support for changing Log4J and logging related properties
- Adding support for manual scheduler invocations

###Configuration

You can use the standard JMX configuration properties according to [official Alfresco documentation](http://docs.alfresco.com/5.1/concepts/jmx-intro-config.html).

###Extending Capabilities for Developers
If you are building an Alfresco extension module, add Alfresco JMX as a dependency. This allows you to use powerful annotations from Spring framework, such as `@ManagedResource`, `@ManagedOperation`, `@ManagedAttribute` within your code. See the existing beans defined within the source of this module for reference.

###Providing more JMX Resources/Operations
If you want to provide more information and operations through JMX, you can contribute to the development of this module.

###Trying out the module with JMX Console

1. To try the module, start the server by running `run.sh` and then open JConsole or JVisualVM.

2. Use the following settings to connect to the JVM JMX instance and replace variables as necessary.
 `service:jmx:rmi:///jndi/rmi://<hostname>:50500/alfresco/jmxrmi`  
  username: `jmxViewRole` password: `change_asap`

###Open Source
This module is an important step in bringing the best features to Alfresco Community edition. This will remain open source.

###Contributing
Create a fork of this project and make pull requests as you see fit. They will be merged and made available to everyone who are using this module.

###Author
- Bhagya Silva [https://about.me/bhagyas](https://about.me/bhagyas) [(Loftux AB)](https://www.loftux.com)


