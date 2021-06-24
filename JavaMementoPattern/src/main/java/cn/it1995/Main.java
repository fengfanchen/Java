package cn.it1995;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Controller controller = new Controller();
        game.setStatus("{'name':'warrior', 'level':100}");
        controller.add(game.saveStatusToFile());
        game.setStatus("{'name':'warrior', 'level':101}");
        controller.add(game.saveStatusToFile());
        game.setStatus("{'name':'warrior', 'level':102}");
        controller.add(game.saveStatusToFile());

        //回退到战士的第一个存单
        game.setStatusFromFile(controller.get(0));
        System.out.println(game.getStatus());
    }
}
