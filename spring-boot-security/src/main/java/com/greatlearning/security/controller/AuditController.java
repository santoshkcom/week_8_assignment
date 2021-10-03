package com.greatlearning.security.controller;

import com.greatlearning.security.entity.AuditLog;
import com.greatlearning.security.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {
    @Autowired
    AuditRepository auditRepository;

    @GetMapping("/logs")
    public List<AuditLog> getRecords() {
        return auditRepository.findAll();
    }
}
