package com.example.Generic;

import com.example.Generic.VO.Sedan;
import com.example.Generic.VO.Truck;
import com.example.Generic.VO.Vehicle;

/**
 * Vehicle을 상속한 타입으로 제한하였다.
 * @author jinwoopark
 */
public class GenericBoundExample<T extends Vehicle> {
    private T vehicleType;

    public T getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(T vehicleType) {
        this.vehicleType = vehicleType;
    }

    public static void main(String[] args) {
        GenericBoundExample<Sedan> sedan = new GenericBoundExample<Sedan>();
        GenericBoundExample<Truck> truck = new GenericBoundExample<Truck>();
        // 상속 범위를 벗어났기 때문에 컴파일 에러 발생
        GenericBoundExample<String> srror = new GenericBoundExample<String>();
    }
}
