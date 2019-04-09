# telegram-spring-boot-example [![Version](https://img.shields.io/badge/Version-0.1-color.svg)](https://github.com/igabaydulin/telegram-spring-boot-example) [![Version](https://img.shields.io/badge/Java-OpenJDK%2011.0.1-dd0000.svg?logo=java)](https://jdk.java.net/11/) [![Version](https://img.shields.io/badge/Gradle-5.3.1-1ba8cb.svg)](https://docs.gradle.org/5.2.1/release-notes.html) [![Version](https://img.shields.io/badge/Spring%20Boot-2.1.3.RELEASE-color.svg)](https://github.com/spring-projects/spring-boot/releases/tag/v2.1.3.RELEASE)

Simple example of Telegram's bot written with Spring Boot

## Configuration Properties
* First credentials are needed ([file example](https://github.com/igabaydulin/telegram-spring-boot-example/blob/master/credentials-example.yaml)):
    ```
    telegram:
      bot:
        credentials:
          token: "<put your bot's token here>"
          bot-username: "<put your bot's username here>"
    ```
* Proxy may needed ([file example](https://github.com/igabaydulin/telegram-spring-boot-example/blob/master/proxy-example.yaml))
    ```
    telegram:
      bot:
        proxy:
          enabled: true
          type: "<put proxy type here: {NO_PROXY, HTTP, SOCKS4, SOCKS5}>"
          host: "<put proxy host here>"
          port: "<put proxy port here"
    ```

## Building a Jar
```
./gradlew clean build
```
Output: ./build/libs/telegram-spring-boot-example-0.1.jar

## Execute Jar
```
java -jar build/libs/telegram-spring-boot-example-0.1.jar \
--spring.config.additional-location=/home/igabaydulin/dev/telegram-spring-boot-example/src/main/resources/credentials.yaml \
--spring.config.additional-location=/home/igabaydulin/dev/telegram-spring-boot-example/src/main/resources/proxy.yaml
```

## Bot Usage
If you send message to your bot, bot will reply you "ping"
<p align="center">
  <img src="https://github.com/igabaydulin/telegram-spring-boot-example/blob/master/resources/conversation.png">
</p>
