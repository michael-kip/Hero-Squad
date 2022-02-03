import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> { //get all heroes
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = (ArrayList<Hero>) Hero.heroes();
            model.put("heroes", heroes);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/hero-form/new", (request, response) -> {
            Map<String, Object>model=new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());
        post("/heroes", (request, response) -> {
            Map<String, Object>model= new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero hero = new Hero(name, age, power,weakness);
            model.put("hero", hero);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
