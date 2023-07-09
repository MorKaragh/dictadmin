package com.morkaragh.dictadmin;

import com.morkaragh.dictadmin.rules.FixedProgramForAgent;
import com.morkaragh.dictadmin.rules.FixedProgramForAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    FixedProgramForAgentService service;

    @GetMapping("keyvalue/actual")
    public ResponseEntity<FixedProgramForAgent> test(@RequestParam("key") String key) {
        return ResponseEntity.ok(service.getActualFixedProgramForAgent(key));
    }

}
