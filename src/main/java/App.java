import models.Hero;
import models.Squad;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "/index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad_form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Squad> squads = request.session().attribute("squads");
            if(squads == null) {
                squads = new ArrayList<>();
                request.session().attribute("squads", squads);
            }

            String name = request.queryParams("name");
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");

            Squad newSquad = new Squad(name, size, cause);
            squads.add(newSquad);
            return new ModelAndView(model, "squad_success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "squad_view.hbs");
        }, new HandlebarsTemplateEngine());
        get("squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squad squad = Squad.findById(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("heroes-in-squad",squad.getHeroes());
            return new ModelAndView(model,"squad.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads",Squad.getAll());
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            model.put("squads",Squad.getAll());
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = request.session().attribute("heroes");
            if (heroes == null) {
                heroes = new ArrayList<>();
                request.session().attribute("heroes", heroes);
            }
            Squad squad = Squad.findById(Integer.parseInt(request.queryParams("squadId")));

            String name = request.queryParams("name");
            int age  = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name,age,power,weakness,squad.getId());
            heroes.add(newHero);
            return new ModelAndView(model, "hero_success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/heroes",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/:Id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Hero hero= Hero.findById(Integer.parseInt(req.params(":Id")));
            Squad squad = Squad.findById(hero.getSquadId());
            model.put("hero", hero);
            model.put("squad",squad);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());



    }
}