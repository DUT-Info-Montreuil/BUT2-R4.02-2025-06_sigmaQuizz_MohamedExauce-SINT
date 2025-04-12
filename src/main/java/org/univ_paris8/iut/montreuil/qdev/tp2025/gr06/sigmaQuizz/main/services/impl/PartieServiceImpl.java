package org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.entities.dto.ElementDispoDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.services.interfaces.IPartieService;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.utils.exeptions.ListJoueurExeption;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.utils.exeptions.ListQuestionnaireExeption;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.utils.exeptions.PartieDataExeption;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dtos.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.services.impl.JoueurServiceImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.services.implementations.FichierService;

import java.util.ArrayList;

public class PartieServiceImpl implements IPartieService {
    public PartieServiceImpl()
    {
    }

    @Override
    public ElementDispoDTO getDataPartie() throws PartieDataExeption {
        ArrayList<JoueurDTO> joueurs = new JoueurServiceImpl().getJoueurs();
        ArrayList<QuestionnaireDTO> questionnaire = new FichierService().getQuestionnaires();

        if (joueurs == null || joueurs.isEmpty()) {
            throw new ListJoueurExeption();
        }

        if (questionnaire == null || questionnaire.isEmpty()) {
            throw new ListQuestionnaireExeption();
        }

        return new ElementDispoDTO(questionnaire, joueurs);
    }
}
