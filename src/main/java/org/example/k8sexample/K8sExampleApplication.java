package org.example.k8sexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@SpringBootApplication
public class K8sExampleApplication {

    @GetMapping("/")
    public String hello() throws UnknownHostException {
        return "Helloo from k8s-example service on " + InetAddress.getLocalHost();
    }

    public static void main(String[] args) {
        SpringApplication.run(K8sExampleApplication.class, args);
    }

}
