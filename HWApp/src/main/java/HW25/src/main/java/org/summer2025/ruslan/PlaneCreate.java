package org.summer2025.ruslan;

public class PlaneCreate extends TransportFactory{
    @Override
    Transport createTransport() {
        return new Plane();
    }
}
