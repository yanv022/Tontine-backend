package com.vougue.tontineApp.controller;

import com.vougue.tontineApp.model.TontineGroup;
import com.vougue.tontineApp.service.TontineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tontine")
@RequiredArgsConstructor
public class TontineController {
    private final TontineService tontineService;

    @PostMapping("/rotate/{groupId}")
    public ResponseEntity<String> rotateGroup(@PathVariable Long groupId) {
        tontineService.processRotation(groupId);
        return ResponseEntity.ok("Rotation réussie");
    }

    @GetMapping
    public ResponseEntity<List<TontineGroup>> getAllGroups() {
        return ResponseEntity.ok(tontineService.getAllGroups());
    }
}