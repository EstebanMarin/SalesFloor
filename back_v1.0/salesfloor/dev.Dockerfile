FROM openjdk:17
RUN curl -L -o sbt.zip https://github.com/sbt/sbt/releases/tag/v1.7.1
# RUN unzip sbt.zip -d ops
# https://yuchen52.medium.com/getting-started-with-docker-scala-sbt-d91f8ac22f5f

# WORKDIR /salesfloor
# ADD . /salesfloor
# CMD /ops/sbt/bin/sbt run