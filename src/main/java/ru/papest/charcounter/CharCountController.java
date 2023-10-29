package ru.papest.charcounter;

import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * RestController for character frequency counting
 */

@RestController
@Validated
public class CharCountController {

    @PostMapping(value = "/api/count/")
    public ResponseEntity<String> postCount(@Size(max = 10) @RequestBody String text) {
        return ResponseEntity.ok(new FrequencyMap(text).getMapToString());
    }
}
