package com.kozmosz.issues.interactor.network;

import com.kozmosz.issues.interactor.service.event.FindDamagesEvent;
import com.kozmosz.issues.model.DamageDTO;

public interface NetworkInteractor {
    void addDamage(DamageDTO damageDTO);

    void modDamage(DamageDTO damageDTO);

    void deleteDamage(DamageDTO damageDTO);

    FindDamagesEvent findAllDamages();

    DamageDTO findDamageById(long id);
}
