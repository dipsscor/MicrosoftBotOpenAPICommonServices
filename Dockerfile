FROM openjdk
MAINTAINER Dipankar Chatterjee <dipankar.c@hcl.com>
ADD target/MicrosoftBotOpenAPICommonServices-1.0.jar MicrosoftBotOpenAPICommonServices-1.0.jar
ENTRYPOINT exec java -jar /MicrosoftBotOpenAPICommonServices-1.0.jar MicrosoftBotOpenAPICommonServices
EXPOSE 12005