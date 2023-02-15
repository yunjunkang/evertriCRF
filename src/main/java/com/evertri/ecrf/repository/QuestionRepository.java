package com.evertri.ecrf.repository;

import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import com.evertri.ecrf.model.*;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByQuestionText(String questionText);

    List<Question> findByFormId(Long formId);

    List<Question> findByAnswerType(String answerType);

    List<Question> findByQuestionOrder(Integer questionOrder);

    List<Question> findByIsRequired(Boolean isRequired);
}
