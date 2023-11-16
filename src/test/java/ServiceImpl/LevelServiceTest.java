package ServiceImpl;

import com.spring.quiztime.dto.LevelDTO;
import com.spring.quiztime.entities.Level;
import com.spring.quiztime.repository.LevelRepository;
import com.spring.quiztime.service.LevelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;


import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
 public class LevelServiceTest {


    @Mock
    private LevelService levelService;

    private LevelDTO levelDTO ;

  @BeforeEach
    public void setUp(){

      levelDTO = new LevelDTO();
      levelDTO.setId(1L);
      levelDTO.setName("level1");
      levelDTO.setMaxPoints(10);
      levelDTO.setMinPoints(1);

     // MockitoAnnotations.openMocks(this);
    }

     @Test
   public void saveTest() {


         Optional<LevelDTO> optionalLevelDTO = Optional.of(levelDTO);
         when(levelService.saveService(levelDTO)).thenReturn(optionalLevelDTO);
        Optional<LevelDTO> savedLevel = levelService.saveService(levelDTO);
         assertThat(savedLevel).isNotNull();

     }

   @Test
   public void updateTest(){
       levelDTO.setName("levelUpdate");
       Optional<LevelDTO> optionalLevelDTO = Optional.of(levelDTO);
       when(levelService.updateService( levelDTO,1L)).thenReturn(optionalLevelDTO);
       LevelDTO tmp = levelService.updateService( levelDTO,1L).get();
       assertEquals(tmp.getName(),levelDTO.getName());
   }

    @Test
   public void  findByIdService()
   {
       Optional<LevelDTO> optionalLevelDTO = Optional.of(levelDTO);
     when(levelService.findByIdService(1L)).thenReturn(optionalLevelDTO);
      Optional<LevelDTO> levelDTO1 = levelService.findByIdService(1L);
      assertThat(levelDTO1).isNotNull();

   }


}
