package quiz.quiz.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import quiz.quiz.Dao.Questiondao;
import quiz.quiz.Dao.Quizdao;
import quiz.quiz.model.Question;
import quiz.quiz.model.QuestionWrapper;
import quiz.quiz.model.Quiz;
import quiz.quiz.model.Response;

@Service
public class QuizService {
  @Autowired
  Quizdao quizdao;

  @Autowired
  Questiondao questiondao;

  public ResponseEntity<String> createQuiz(String category, String title) {
    List<Question> questions = questiondao.findRandomQuestionByCategory(category);
    Quiz quiz = new Quiz();
    quiz.setTitle(title);
    System.out.println(questions + "questions");
    quiz.setQuestions(questions);
    System.out.println(quiz.getQuestions() + "quizquestions");
    quizdao.save(quiz);

    return new ResponseEntity<>("Success", HttpStatus.CREATED);

  }

  public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
    System.out.println("id of quiz:"+id);
    Optional<Quiz> quiz = quizdao.findById(id);
    System.out.println(quiz + "quizVVV");
    List<Question> questionsFromdb = quiz.get().getQuestions();
    System.out.println(questionsFromdb + "questionsFromdbF");
    List<QuestionWrapper> questionForUser = new ArrayList<>();
    for (Question q : questionsFromdb) {
      QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
          q.getOption3(), q.getOption4());
      questionForUser.add(qw);
    }
    return new ResponseEntity<>(questionForUser, HttpStatus.OK);
  }
  public ResponseEntity<Integer> calculateResult(Integer id,List<Response>responses){
      Quiz quiz=quizdao.findById(id).get();
      List<Question> questions=quiz.getQuestions();
      int right=0;
      int i=0;
      for(Response response:responses){
        if(response.getResponse().equals(questions.get(i).getRightAnswer())){
          right++;
        }
        i++;
      }
      return new ResponseEntity<>(right,HttpStatus.OK);
  }

}
