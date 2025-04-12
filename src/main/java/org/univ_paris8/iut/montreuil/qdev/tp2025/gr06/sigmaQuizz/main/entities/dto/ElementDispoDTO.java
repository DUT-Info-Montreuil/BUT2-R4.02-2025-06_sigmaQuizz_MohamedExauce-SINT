package org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr07.jeuQuizz.entities.dtos.JoueurDTO;

import java.util.ArrayList;

public class ElementDispoDTO {

    public ArrayList<QuestionnaireDTO> questionnaire;
    public ArrayList<JoueurDTO> joueurs;

    public ElementDispoDTO(ArrayList<QuestionnaireDTO> questionnaire, ArrayList<JoueurDTO> joueurs) {
        this.questionnaire = questionnaire;
        this.joueurs = joueurs;
    }

    public ArrayList<QuestionnaireDTO> getQuestionnaire() {
        return questionnaire;
    }

    public ArrayList<JoueurDTO> getJoueurs() {
        return joueurs;
    }
}
