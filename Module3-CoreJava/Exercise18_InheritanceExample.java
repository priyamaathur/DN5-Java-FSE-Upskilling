public class Exercise18_InheritanceExample {

    static class Animal {
        void makeSound() {
            System.out.println("Animal makes a sound.");
        }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound();

        Dog d = new Dog();
        d.makeSound();
    }
}