import commands.*;
import report.ReportType;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private final Map<Integer, Command> commands;

    Menu() {
        commands = new HashMap<>();
        commands.put(1, new ReadReport(1, "Считать все месячные отчёты", ReportType.MONTH));
        commands.put(2, new ReadReport(2, "Считать годовой отчёт", ReportType.YEAR));
        commands.put(3, new ValidateReportsData(3, "Сверить отчёты"));
        commands.put(4, new PrintReportsInfo(4, "Вывести информацию о всех месячных отчётах", ReportType.MONTH));
        commands.put(5, new PrintReportsInfo(5, "Вывести информацию о годовом отчёте", ReportType.YEAR));
        commands.put(6, new QuitApp(6, "Выйти из приложения"));
    }

    public void printMenu() {
        commands.values().forEach(System.out::println);
    }

    public void executeCommand(int command) {
        if (!commands.containsKey(command)) {
            throw new CommandMissingException("Нет команды с номером " + command);
        }
        commands.get(command).execute();
    }

}
