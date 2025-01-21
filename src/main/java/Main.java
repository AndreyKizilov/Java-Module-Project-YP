


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        for(int i = 0; i < 3; i++) {
            System.out.println("Введите марку автомобиля " + (i+1) + ": ");
            String model;
            while (true) {
                model = scanner.nextLine().trim();
                if (!model.isEmpty()) {
                    break;
                }
                System.out.println("Марка автомобиля не может быть пустой строкой");
            }

            int speed = 0;
            while (true) {
                System.out.println("Введите скорость автомобиля " + (i+1) + " в диапозоне от 0 до 250: ");
                String input = scanner.nextLine();
                try {
                    speed = Integer.parseInt(input);
                    if(speed >= 0 && speed <= 250){
                        break;
                    } else {
                        System.out.println("Некорректно введена скорость.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректно введена скорость. Введите число.");
                }
            }

            try {
                cars[i] = new Car(model,speed);
            }catch (Exception e){
                System.out.println("Ошибка при создании объекта Car:");
                e.printStackTrace();
            }

        }
        int[] distances = new int[3];
        for(int i = 0; i < 3; i++){
            distances[i] = cars[i].totalDistance(24);
        }
        int maxDist = 0;
        for(int i = 1; i < 3;i++) {
            if(distances[i] > distances[maxDist]) {
                maxDist = i++;
            }
        }

        System.out.println("\nАвтомобиль, который проедет наибольшую дистанцию: " +
                cars[maxDist].getModel() + ", с растоянием " + distances[maxDist] + " км");
    }

    static class Car {
        private String model;
        private int speed;

        public Car(String model, int speed) {
            this.model = model;
            this.speed = speed;
        }
        public String getModel() {
            return model;
        }
        public  int getSpeed() {
            return speed;
        }
        public int totalDistance(int hours) {
            return speed * hours;
        }

    }



}