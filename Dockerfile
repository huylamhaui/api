FROM maven as buildJar

WORKDIR /opt/source/api

COPY . .

RUN mvn clean package



FROM openjdk

WORKDIR /opt/app/

COPY --from=buildJar /opt/source/api .

RUN ls

CMD [ "java", "-jar", "api.jar" ]