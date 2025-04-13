package org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.services.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.entities.dto.ElementDispoDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.services.interfaces.IPartieService;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.utils.exeptions.ListJoueurExeption;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.utils.exeptions.ListQuestionnaireExeption;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.utils.exeptions.PartieDataExeption;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dtos.JoueurDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPartieServiceTest {

    @Mock
    private IPartieService partieServiceMock;

    @Test
    public void testDeterminerElementsDisponiblesSuccess() throws PartieDataExeption {
        IPartieService service = new ServiceMockSucc();

        ElementDispoDTO result = service.getDataPartie();

        assertNotNull(result);
        assertEquals(1, result.getJoueurs().size());
        assertEquals(1, result.getQuestionnaire().size());
    }

    @Test
    public void testDeterminerElementsDisponiblesEmptyQuestionnaires() {
        IPartieService service = new ServiceMockQuestEmpty();

        assertThrows(ListQuestionnaireExeption.class, () -> {
            service.getDataPartie();
        });
    }

    @Test
    public void testDeterminerElementsDisponiblesEmptyJoueurs() {
        IPartieService service = new ServiceMockQuestEmpty();

        assertThrows(ListJoueurExeption.class, () -> {
            service.getDataPartie();
        });
    }

    @Test
    public void testDeterminerElementsDisponibles() throws PartieDataExeption {
        ArrayList<String> centreInteret = new ArrayList<>();
        centreInteret.add("foot");
        centreInteret.add("Pologne virgule");

        ArrayList<QuestionDTO> questions = new ArrayList<>();

        when(partieServiceMock.getDataPartie())
                .thenReturn(
                        new ElementDispoDTO
                                (
                                        (ArrayList<QuestionnaireDTO>) List.of(new QuestionnaireDTO(questions), new QuestionnaireDTO(questions)),
                                        (ArrayList<JoueurDTO>) List.of(new JoueurDTO("Test", "User", 2005, centreInteret, 2))
                                ));

        ElementDispoDTO result = partieServiceMock.getDataPartie();

        assertNotNull(result);
        assertEquals(1, result.getJoueurs().size());
        assertEquals(2, result.getJoueurs().size());
    }
}
