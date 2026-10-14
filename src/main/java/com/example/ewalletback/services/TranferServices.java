package com.example.ewalletback.services;

import com.example.ewalletback.models.Transfer;

public interface TranferServices {
    public interface TransfertService {

        Transfer effectuerTransfert(Transfer transfert);

    }
}
