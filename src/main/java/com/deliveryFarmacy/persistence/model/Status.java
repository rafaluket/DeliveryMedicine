package com.deliveryFarmacy.persistence.model;

public enum Status {
    PENDENTE(1) ,AUSENTE(2), ENDERECO_INCORRETO(3), PEDIDO_CANCELADO(4), SEM_PAGAMENTO(5);

    public final int codeEvent;
    Status(int value) {
        codeEvent = value;
    }

    public static String getEnumById(int code){
        for(Status e : Status.values()){
            if(e.codeEvent == code) return e.name();
        }
        return null;
    }
}
