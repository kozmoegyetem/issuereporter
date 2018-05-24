package com.kozmosz.issues.interactor.service;

import com.kozmosz.issues.model.DamageDTO;

public interface ServiceInteractor {
    void addDamage(DamageDTO damageDTO);

    void modDamage(DamageDTO damageDTO);

    void deleteDamage(DamageDTO damageDTO);

    void findAllDamages();

    void findDamageById(long id);

    void sync();
}
