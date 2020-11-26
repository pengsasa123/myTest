package test;

public interface QuackBehaior {
    void quack();
}

class Quack implements QuackBehaior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}

class MuteQuack implements QuackBehaior {

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

class Squeak implements QuackBehaior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
