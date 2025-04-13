package org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.entities.dto.ElementDispoDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.utils.exeptions.PartieDataExeption;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dtos.JoueurDTO;

import java.util.ArrayList;
import java.util.List;

public class ServiceMockSucc implements IPartieService
{

    @Override
    public ElementDispoDTO getDataPartie() throws PartieDataExeption {
        ArrayList<JoueurDTO> joueurs = new ArrayList<>();
        joueurs.add(new JoueurDTO("moh", "moh le boss", 1000, new ArrayList<String>(), 1));
        ArrayList<QuestionnaireDTO> questionnaires = new ArrayList<>();
        ArrayList<QuestionDTO> questions = new ArrayList<>();
        questions.add(new QuestionDTO(1, "zf", "oooh", 2, "zzf", "zf"));
        questionnaires.add(new QuestionnaireDTO(questions));

        return new ElementDispoDTO(questionnaires, joueurs);

    }
}
