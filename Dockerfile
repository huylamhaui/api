FROM maven as buildJar

WORKDIR /usr/source/api

COPY . .

RUN mvn clean package



FROM openjdk

WORKDIR /usr/app/

COPY --from=buildJar /usr/source.api .

CMD [ "java", "-jar", "api.jar" ]