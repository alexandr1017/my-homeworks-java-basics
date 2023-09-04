public class Elevator {
    private int currentFloor = 1;
    private final int minFloor;
    private final int maxFloor;


    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    private void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    private void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {


        boolean isError = (floor < minFloor || floor > maxFloor);
        if (isError) {
            System.out.println("Ошибка! Этаж введен неверно. Попробуйте еще раз. ");
            return;
        }

        if (floor < currentFloor) {
            for (int i = currentFloor; i > floor; i--) {
                moveDown();
                System.out.println("Этаж: " + getCurrentFloor());
            }
        }
        if (floor > currentFloor) {
            for (int i = currentFloor; i < floor; i++) {
                moveUp();
                System.out.println("Этаж: " + getCurrentFloor());
            }
        }
    }
}




