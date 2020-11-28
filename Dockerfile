FROM maven as buildJar

WORKDIR /opt/source/api

COPY . .

RUN mvn clean package



FROM openjdk

WORKDIR /opt/app/

COPY --from=buildJar /opt/source/api .

CMD [ "java", "-jar", "api.jar" ]