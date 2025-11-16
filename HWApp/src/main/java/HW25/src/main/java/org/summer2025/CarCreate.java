package org.summer2025;

public class CarCreate extends TransportFactory{
    @Override
    Transport createTransport() {
        return new Car();
    }
}
