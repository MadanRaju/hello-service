package com.assignment.hello_service.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping({"/hello-service"})
public class HelloController {

    @RequestMapping ("/hello")
    public ResponseEntity<?> hello(@PathParam("path") String path) throws Exception {
        try {
            System.out.println("Health Check Request processed");
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode dataNode = objectMapper.createObjectNode();
            dataNode.put("message", "Hello :)");
            dataNode.put("status", "OK");
            return ResponseEntity.ok(dataNode);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
