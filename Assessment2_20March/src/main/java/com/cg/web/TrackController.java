package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Track;
import com.cg.repo.ITrackRepository;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private ITrackRepository repo;

    @PostMapping
    public ResponseEntity<String> addTrack(@RequestBody Track track) {
        repo.save(track);
        return ResponseEntity.status(201).body("Track added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Track>> getTracks() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/byTitle")
    public ResponseEntity<List<Track>> getTracksByTitle(@RequestParam String title) {
        List<Track> list = repo.findByTitle(title);
        return list.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTrack(@PathVariable Long id) {
    	
        return repo.findById(id).<ResponseEntity<Object>>map(track -> ResponseEntity.ok(track)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}