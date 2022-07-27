package tests.console.week07;

public class TravelDirectionTest {

    private static void goNorthEast(int endX, int endY, int x, int y, String route) {

        if (x == endX && y == endY) {
            System.out.println(route);
        }else if(x <= endX && y <= endY){
            goNorthEast(endX, endY,       x, y + 1, route + " N");
            goNorthEast(endX, endY,x + 1,        y, route + " E");
            goNorthEast(endX, endY,x + 1, y + 1, route + " NE");
        }
    }

    private static void goSouthWest(int endX, int endY, int x, int y, String route) {
        if (x == endX && y == endY) {
            System.out.println(route);
        }else if(x >= endX && y >= endY){
            goSouthWest(endX, endY,        x, y - 1, route + " S");   // move to go South
            goSouthWest(endX, endY, x - 1,        y, route + " W");   // move to go West
            goSouthWest(endX, endY, x - 1, y - 1, route + " SW");   // move to go SouthWest
        }
    }

    public static void goNorthEast(int endX, int endY, int startX, int startY) {
        System.out.println("Solutions for (" + startX + "," + startY + ")" + " to (" + endX + "," + endY + ")");
        goNorthEast(endX, endY, startX, startY, "moves:");
        System.out.println();
    }

    public static void goSouthWest(int endX, int endY, int startX, int startY) {
        System.out.println("Solutions for (" + startX + "," + startY + ")" + " to (" + endX + "," + endY + ")");
        goSouthWest(endX, endY, startX, startY, "moves:");
        System.out.println();
    }

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t T R A V E L    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        goNorthEast(1,2, 0, 0);
        goSouthWest(0, 0, 1, 2);
        System.out.println();
    }
}
