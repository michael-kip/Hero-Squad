import models.Hero;
import models.Squad;
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
        get("/squad",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"squad_form.hbs");
        },new HandlebarsTemplateEngine());
        post("/squad/new", (request, response) -> {
            Map<String,Object>model= new HashMap<>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            int size = Integer.parseInt(request.queryParams("size"));
            Squad squad = new Squad(name,cause,size);
            model.put("squad", squad);
            return new ModelAndView(model, "squad_success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/heroes/:id", (request, response) -> {
            Map<String, Object>model= new HashMap<>();
            int findHeroById = Integer.parseInt(request.params(":id"));
            Hero hero = Hero.findHero(findHeroById);
            model.put("foundHero", hero );
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.findHero(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
