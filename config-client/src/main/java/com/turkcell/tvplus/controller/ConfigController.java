package com.turkcell.tvplus.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {
	

    @Autowired
    ConfigurableEnvironment env;

    private static <T> Set<T> collectArrayList(Class<T> clzz, String property, Environment env, int maxValues) {
        HashSet<T> valueSet = new HashSet<>();
        for (int i = 0; i <= maxValues; i++) {
            T val = env.getProperty(property + "[" + i + "]", clzz);
            if (val == null) break;
            valueSet.add(val);
        }
        return valueSet;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<String>> getConfigs(){
        Set<String> scopes = collectArrayList(String.class, "my.security.scope", env, 10);
    	return new ResponseEntity<>(scopes, HttpStatus.OK);
    }
    
}
 