package org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.entities.dto.ElementDispoDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr06.sigmaQuizz.main.utils.exeptions.PartieDataExeption;

public interface IPartieService
{
    ElementDispoDTO getDataPartie() throws PartieDataExeption;
}
