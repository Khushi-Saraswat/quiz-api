package quiz.quiz.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import quiz.quiz.model.Quiz;

public interface Quizdao extends JpaRepository<Quiz,Integer>{

}
