package ServiceImpl;


import com.spring.quiztime.dto.QuizQuestion.QuizQuestionDTO;
import com.spring.quiztime.service.QuizQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class QuizQuestionServiceTest {




    @Mock
    private QuizQuestionService questionService;
    private QuizQuestionDTO quizQuestionDTO;

    @BeforeEach
    public void setUp(){
        quizQuestionDTO = new QuizQuestionDTO();
        quizQuestionDTO.setId(1L);
        quizQuestionDTO.setTemporization(20);
        quizQuestionDTO.setQuestion_id(1L);
        quizQuestionDTO.setQuiz_id(1L);

    }


/*
    @Test
    public void saveTest(){
        Optional<QuizQuestionDTO> questionDTOOptional = Optional.of(quizQuestionDTO);

        when(questionService.saveService(quizQuestionDTO)).thenReturn();


    }
*/
}
