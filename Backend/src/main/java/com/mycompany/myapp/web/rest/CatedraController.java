package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CatedraService;
import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
@PermitAll
public class CatedraController {
    private final CatedraService catedraService;

    public CatedraController(CatedraService catedraService) {
        this.catedraService = catedraService;
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody String body) {
        return catedraService.registrar(body);
    }
}
