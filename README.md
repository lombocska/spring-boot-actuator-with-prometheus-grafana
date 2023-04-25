# SPRING-BOOT-ACTUATOR EXAMPLE WITH PROMETHEUS AND GRAFANA


[![Github Repo](https://img.shields.io/badge/GitHub-Repo-green.svg?longCache=true&style=flat)](https://github.com/lombocska/spring-boot-actuator-with-prometheus-grafana)
![Github Actions](https://github.com/lombocska/https://github.com/lombocska/spring-boot-actuator-with-prometheus-grafana/workflows/Java%20CI%20with%20Maven/badge.svg)

<p align="center">
  <a href="#description">Description</a> •
  <a href="#tech-stack">Tech Stack</a> •
  <a href="#approaches-highlighting-some-tech-savvy-things">Approaches</a> •
  <a href="#usage">Usage</a> •
  <a href="#inspirations">Inspiration</a>
</p>

## DESCRIPTION

**This Spring Boot app aims to show how spring-boot-actuator work together with prometheus and grafana to help you gain metrics.**

I used a premade grafana dashboard template from [here](https://grafana.com/grafana/dashboards/11378-justai-system-monitor/)



## TECH STACK

- Spring Boot Parent 3.0.6
- Micrometer Prometheus  1.10.6
- Docker
- Github Actions
- docker-file-maven-plugin 1.4.10


## APPROACHES - Highlighting some tech savvy things

### layered dockerfile for efficiency

> There is a clean separation between dependencies and application resources in a Spring Boot fat jar file,
>and we can use that fact to improve performance.
>The key is to create layers in the container filesystem. The layers are cached both at build time
>and at runtime (in most runtimes) so we want the most frequently changing resources,
>usually the class and static resources in the application itself, to be layered after the more slowly changing resources.

### prometheus for metrics

> Prometheus is an open-source systems monitoring and alerting toolkit originally built at SoundCloud.
> Since its inception in 2012, many companies and organizations have adopted Prometheus, and the project has a very active developer and account community.

The default dashboard for Spring Boot dashboard template can be found [here](https://grafana.com/grafana/dashboards/11378-justai-system-monitor/).



### docker-compose-maven-plugin

> Maven plugin for running basic docker-compose commands with Maven.
In case of this app, integration tests needed postgres db running via this plugin.


## USAGE

0. `./mvnw clean install` for creating the docker image of the app and running tests
1. fire up prometheus, grafana and the app itself `docker-compose -f docker/monitoring.yml -f docker/app.yml up --build`
2. visit `localhost:8080/api/hello`

6. visit `localhost:3000`
7. grafana default login credentials is `admin-admin` and skip the password change
8. visit provisioned Spring-boot dashboard and fathom micrometer metrics of the app


```
Note: docker settings (host.docker.internal) works for MacOS, but on Windows it won't. In theory, 'host' should be used on Windows, but I don't have a chance to try it out.
```

## INSPIRATIONS

- [Spring Boot Docker Layers](https://springframework.guru/why-you-should-be-using-spring-boot-docker-layers/)
- [JarLauncher](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/loader/JarLauncher.html)
- [Prometheus](https://prometheus.io/docs/introduction/overview/)
- [docker-compose-maven-plugin](https://github.com/dkanejs/docker-compose-maven-plugin)


