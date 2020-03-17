package bankata.api.bankata_api.service;

import org.springframework.stereotype.Component;

@Component
public class Formatter implements IFormatter{
    @Override
    public String create() {
        return "🖕🏼";
    }
}
