package quiz.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.quiz.Service.questionService;
import quiz.quiz.model.Question;

@RestController

@RequestMapping("/question")
public class QuestionController {

    @Autowired
    questionService questionService;

   

    @GetMapping("/all questions")
    public ResponseEntity<List<Question>> getAllquestion() {
        return questionService.getallQuestion();

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        System.out.println("category" + category);
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable int id) {
        System.out.println("question to be deleted: " + id);
        questionService.deleteQuestion(id);
    }

    @PutMapping("/update/{id}")
    public String updateQuestion(@RequestBody Question question, @PathVariable int id) {
        System.out.println("question to be updated:" + question);
        return questionService.modifyQuestion(question, id);

    }

}
