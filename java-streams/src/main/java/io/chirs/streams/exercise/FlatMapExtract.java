package io.chirs.streams.exercise;

import io.chirs.streams.model.Project;

import java.util.List;

public class FlatMapExtract {

    public static void main(String[] args) {
        var pr1 = new Project(List.of("maven","lombok"));
        var pr2 = new Project(List.of("maven","spring-boot","maven-compiler"));
        var pr3 = new Project(List.of("maven","spring-webflux","netty"));

        var projects = List.of(pr1,pr2,pr3);

        var dependencies = projects.stream().flatMap(pr -> pr.getLibrerias().stream())
                .distinct()
                .toList();
        dependencies.forEach(System.out::println);
    }
}
