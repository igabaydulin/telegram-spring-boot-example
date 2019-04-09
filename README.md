# telegram-spring-boot-example [![Version](https://img.shields.io/badge/Version-0.1-color.svg)](https://github.com/igabaydulin/telegram-spring-boot-example) [![Version](https://img.shields.io/badge/Java-OpenJDK%2011.0.1-dd0000.svg?logo=java)](https://jdk.java.net/11/) [![Version](https://img.shields.io/badge/Gradle-5.3.1-1ba8cb.svg)](https://docs.gradle.org/5.2.1/release-notes.html) [![Version](https://img.shields.io/badge/Spring%20Boot-2.1.3.RELEASE-color.svg)](https://github.com/spring-projects/spring-boot/releases/tag/v2.1.3.RELEASE)

The only purpose of this bot is to reply "ping" to the received message
<p align="center">
  <img src="https://github.com/igabaydulin/telegram-spring-boot-example/blob/master/resources/conversation.png">
</p>

## TLDR
```
./gradlew clean build

java -jar build/libs/telegram-spring-boot-example-0.1.jar \
--spring.config.additional-location=classpath:credentials.yaml \
--spring.config.additional-location=classpath:proxy.yaml
```

## Configuration Properties
* Credentials ([example](https://github.com/igabaydulin/telegram-spring-boot-example/blob/master/src/main/resources/credentials.yaml.sample)):
    ```yaml
    telegram:
      bot:
        credentials:
          token: "<put your bot's token here>"
          bot-username: "<put your bot's username here>"
    ```
* Proxy ([example](https://github.com/igabaydulin/telegram-spring-boot-example/blob/master/src/main/resources/proxy.yaml.sample))
    ```yaml
    telegram:
      bot:
        proxy:
          enabled: true
          type: "<put proxy type here: {NO_PROXY, HTTP, SOCKS4, SOCKS5}>"
          host: "<put proxy host here>"
          port: "<put proxy port here>"
    ```

## Building a Jar
```
./gradlew clean build
```
Output: ./build/libs/telegram-spring-boot-example-0.1.jar

## Execute Jar
```
java -jar build/libs/telegram-spring-boot-example-0.1.jar \
--spring.config.additional-location=classpath:credentials.yaml \
--spring.config.additional-location=classpath:proxy.yaml
```

