package test;

public abstract class Duck {

    FlyBehacior flyBehacior;

    QuackBehaior quackBehaior;

    public Duck(){}

    public abstract void display();

    public void performFly() {
        flyBehacior.fly();
    }

    public void performQuark() {
        quackBehaior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}
