package pl.nobleprog.katowice.part7shell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class GreetingCommand {
    @ShellMethod(value = "Prints custom greeting message")
    public String greet(@ShellOption({"-M", "--message"}) String message){
        return String.format("Your greeting message: %s", message);
    }
}
