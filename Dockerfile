FROM openjdk:11-jdk-bullseye

RUN mkdir -p /home/todolist

COPY . /home/todolist

WORKDIR /home/todolist

EXPOSE 8400

CMD ["./gradlew", "clean", "bootRun"]
