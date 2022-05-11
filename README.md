These are Java Beans classes for the Beacon API v2.0.0 specification Json schema.

Compiling:
```shell
>git clone https://gitlab.bsc.es/inb/ga4gh/beacon-data-model.git
>cd beacon-data-model
>mvn install
```
The beacon-data-model-2.0.0.jar will be generated in the beacon-data-model/target/ directory

To include Beacon beans in a maven project (pom.xml):

```xml
<dependencies>
    <dependency>
        <groupId>es.bsc.inb.ga4gh</groupId>
        <artifactId>beacon-data-model</artifactId>
        <version>2.0.0</version>
    </dependency>
</dependencies>
     
<repositories>
    <repository>
        <id>gitlab-bsc</id>
        <url>https://gitlab.bsc.es/inb/maven/raw/master</url>
    </repository>

</repositories>
```
