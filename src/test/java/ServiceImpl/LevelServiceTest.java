package ServiceImpl;

import com.spring.quiztime.entities.Level;
import com.spring.quiztime.repository.LevelRepository;
import com.spring.quiztime.service.LevelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
 public class LevelServiceTest {

    @Mock
    private LevelRepository levelRepository;

    @InjectMocks
    private LevelService levelServiceImpl;

    private Level level ;

  @BeforeEach
    public void setUp(){
       level = new Level();
       level.setId(1L);
       level.setName("level1");
       level.setMaxPoints(10);
       level.setMinPoints(1);
    }

     @Test
   public void saveTest() {
         given(levelRepository.save(level)).willReturn(level);
        when(levelServiceImpl.saveService(level)).thenReturn(Optional.ofNullable(level));
         Optional<Level> result = levelServiceImpl.saveService(level);
         assertThat(result).isEqualTo(result.get());

     }
}
