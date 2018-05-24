package com.kozmosz.issues.ui.damage.list;

import com.kozmosz.issues.model.DamageDTO;
import com.kozmosz.issues.model.MessageDTO;

import java.util.List;

public interface DamageListScreen {
    void navigateToDamageDetail(long damageId);

    void showDamages(List<DamageDTO> damageDTOList);

    void showMessage(MessageDTO messageDTO);
}
