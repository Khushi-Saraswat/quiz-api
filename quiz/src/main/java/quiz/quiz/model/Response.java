package quiz.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@RequiredArgsConstructor
@Entity
public class Response {
    @Id
    private Integer id;
    private String response;
}
