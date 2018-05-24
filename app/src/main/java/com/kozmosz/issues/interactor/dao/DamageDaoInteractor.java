package com.kozmosz.issues.interactor.dao;

import com.kozmosz.issues.interactor.service.event.FindDamagesEvent;
import com.kozmosz.issues.interactor.service.event.InfoEvent;
import com.kozmosz.issues.model.DamageDTO;

public interface DamageDaoInteractor {
    InfoEvent addDamage(DamageDTO damageDTO);

    InfoEvent modDamage(DamageDTO damageDTO);

    InfoEvent deleteDamage(DamageDTO damageDTO);

    FindDamagesEvent findAllDamages();

    DamageDTO findDamageById(long id);
}
