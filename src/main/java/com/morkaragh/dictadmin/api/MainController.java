package com.morkaragh.dictadmin.api;

import com.morkaragh.dictadmin.rules.KeyValueRule;
import com.morkaragh.dictadmin.rules.KeyValueRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    KeyValueRuleService service;

    @GetMapping("keyvalue/actual")
    public ResponseEntity<KeyValueRule> test(@RequestParam("key") String key) {
        return ResponseEntity.ok(service.getActualRule(key));
    }

}
