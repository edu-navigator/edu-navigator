package org.edunavigator.ingestion.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/ingestion")
public class IngestionController {

    @PostMapping
    public ResponseEntity<String> ingestData(){
        return ResponseEntity.ok("Ingesting data.....");
    }
}
