FROM chanjarster/openjdk:8-alpine

ARG NAME
ARG VERSION
ARG JAR_FILE

LABEL name=$NAME \
      version=$VERSION

# 新建用户java-app
RUN set -eux; \
    adduser --home=/home/java-app/ --shell=/bin/sh --disabled-password java-app; \
    adduser java-app java-app; \
    mkdir -p /home/java-app/lib /home/java-app/etc /home/java-app/logs /home/java-app/tmp; \
    chown -R java-app:java-app /home/java-app

COPY --chown=java-app:java-app docker-entrypoint.sh /home/java-app/docker-entrypoint.sh
COPY --chown=java-app:java-app target/${JAR_FILE} /home/java-app/lib/app.jar

RUN chmod +x /home/java-app/docker-entrypoint.sh
ENTRYPOINT ["/home/java-app/docker-entrypoint.sh"]

EXPOSE 8080
