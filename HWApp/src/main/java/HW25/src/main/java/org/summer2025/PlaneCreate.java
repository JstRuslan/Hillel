package org.summer2025;

public class PlaneCreate extends TransportFactory{
    @Override
    Transport createTransport() {
        return new Plane();
    }
}
