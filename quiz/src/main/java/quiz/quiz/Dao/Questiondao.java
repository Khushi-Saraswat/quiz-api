package quiz.quiz.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import quiz.quiz.model.Question;

public interface Questiondao extends JpaRepository<Question, Integer> {

    public List<Question> findByCategory(String category);

    public Question findQuestionById(Integer id);


    List<Question> findRandomQuestionByCategory(String category);
}
