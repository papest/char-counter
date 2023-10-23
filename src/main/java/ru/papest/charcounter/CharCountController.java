package ru.papest.charcounter;

import jakarta.validation.constraints.NotEmpty;
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
    public ResponseEntity<String> postCount(@NotEmpty @RequestBody String text) {
        return ResponseEntity.ok(new FrequencyMap(text).getMapToString());
    }
}
