package ru.papest.charcounter;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * RestController for character frequency counting
 */

@RestController
@Validated
@Tag(name = "Char Counter Controller", description = "Контроллер для подсчета частоты символов в строке")
public class CharCountController {

    @PostMapping(value = "/api/count/")
    @Operation(summary = "Подсчет частоты символов", description = "Получение строки и подсчет частоты символов в ней")
    public ResponseEntity<String> postCount(@Size(max = 10) @RequestBody String text) {
        return ResponseEntity.ok(new FrequencyMap(text).getMapToString());
    }
}
