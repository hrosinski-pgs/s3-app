package com.example.s3app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s3")
public class FileController {

  @Autowired FileService fileServiceNew;

  @GetMapping()
  String healthCheck() {
    return "UP";
  }

  @GetMapping("/{fileName}")
  public ResponseEntity<String> findByName(@PathVariable("fileName") String fileName) {
    return new ResponseEntity<>(fileServiceNew.findByName(fileName), HttpStatus.OK);
  }

  @PostMapping("/upload")
  public ResponseEntity<String> saveFile(@RequestParam("extension") String extension) {
    return new ResponseEntity<>(fileServiceNew.save(extension), HttpStatus.OK);
  }
}
