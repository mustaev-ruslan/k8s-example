package org.example.k8sexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@SpringBootApplication
public class K8sExampleApplication {

    @GetMapping("/")
    public String hello() throws IOException {
        Path path = Paths.get("data", "fileTest.txt");
        String text = Files.readAllLines(path).get(0);
        return "111Hello from k8s-example service on " + InetAddress.getLocalHost() +
                "<br>Storage content: " + text;
    }

    public static void main(String[] args) {
        SpringApplication.run(K8sExampleApplication.class, args);
    }

}
