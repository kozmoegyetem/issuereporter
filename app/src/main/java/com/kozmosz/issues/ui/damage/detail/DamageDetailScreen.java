package com.kozmosz.issues.ui.damage.detail;

import com.kozmosz.issues.model.DamageDTO;
import com.kozmosz.issues.model.MessageDTO;

public interface DamageDetailScreen {
    void navigateToDamageListScreen();

    void showDamageDetails(DamageDTO damageDTO);

    void showMessage(MessageDTO message);
}
