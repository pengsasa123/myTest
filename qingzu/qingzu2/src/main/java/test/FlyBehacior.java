package test;

public interface FlyBehacior {

    void fly();
}

class FlyWithWings implements FlyBehacior {

    @Override
    public void fly() {
        System.out.println("im flying!");
    }
}

class FlyNoWay implements FlyBehacior {
    @Override
    public void fly() {
        System.out.println("i cant flying");
    }
}

