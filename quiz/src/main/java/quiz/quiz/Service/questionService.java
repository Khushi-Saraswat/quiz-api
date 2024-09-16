package quiz.quiz.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import quiz.quiz.Dao.Questiondao;
import quiz.quiz.model.Question;


@Service
public class questionService {

    @Autowired
    Questiondao  questiondao;

    public ResponseEntity<List<Question>> getallQuestion() {
        try{
        return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public  ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
        return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questiondao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public void deleteQuestion(int id) {
        questiondao.deleteById(id);
    }
    public String modifyQuestion(Question question,Integer id){
        question.setId(id);
        questiondao.save(question);
        return "question modified";
    }
   
}
