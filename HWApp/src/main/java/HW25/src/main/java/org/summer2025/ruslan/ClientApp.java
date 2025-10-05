package org.summer2025.ruslan;

public class ClientApp {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        TransportFactory carCreate = new CarCreate();
        TransportFactory planeCreate = new PlaneCreate();

        Transport car = carCreate.createTransport();
        Transport plane = planeCreate.createTransport();
        car.move();
        plane.move();


    }
}
