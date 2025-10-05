package org.summer2025.ruslan;

public class CarCreate extends TransportFactory{
    @Override
    Transport createTransport() {
        return new Car();
    }
}
