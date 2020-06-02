package com.dartagnan.springcourse.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){

        for (OrderStatus value : OrderStatus.values()){  //percorre todos os valores possíveis do enum
            if (value.getCode() == code){  //se o código do enum for igual ao passado como argumento
                return value; //retorna o enum
            }
        }
        throw new IllegalArgumentException("Invalid order status code");
    }
}
