package com.morkaragh.dictadmin.api;

import com.morkaragh.dictadmin.rules.KeyValueRule;
import com.morkaragh.dictadmin.rules.KeyValueRuleService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    KeyValueRuleService service;

    @GetMapping("byKey/{key}")
    public ResponseEntity<List<KeyValueRule>> test(@PathParam("key") String key) {
        return ResponseEntity.ok(service.getActualRule(key));
    }


}
