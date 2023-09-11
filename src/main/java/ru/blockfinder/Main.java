package ru.blockfinder;

import ru.blockfinder.actions.*;
import ru.blockfinder.service.LevelService;
import ru.blockfinder.service.SimpleLevelService;

public class Main {

    private final Output out;

    public Main(Output out) {
        this.out = out;
    }

    public void init(Input input, LevelService service, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, service);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try {
            LevelService service = new SimpleLevelService();
            UserAction[] actions = {
                    new ListUniqueEntitiesAction(output),
                    new CreateJsonWithChunksWithEntitiesAction(output),
                    new CreateJsonWithTagsByNameAction(output),
                    new ShowPathAction(output),
                    new ExitAction(output)
            };
            new Main(output).init(input, service, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}