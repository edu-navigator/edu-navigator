package org.edunavigator.search_service.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/search")
public class SearchController {
    @PostMapping
    public ResponseEntity<String> ingestData(){
        return ResponseEntity.ok("Search called...");
    }
}
