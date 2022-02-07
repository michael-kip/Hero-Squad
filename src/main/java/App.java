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




        get("/squads/new",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "/squad_success.hbs");
        }, new HandlebarsTemplateEngine());

        ;

        post("/squadsForm", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> squadit = request.session().attribute("squadi");
            if(squadit == null) {
                squadit = new ArrayList<Squad>();
                request.session().attribute("squads", squadit);
            }

            String name = request.queryParams("name");
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");

            Squad newSquad = new Squad(name, size, cause);
            squadit.add(newSquad);
            return new ModelAndView(model, "/success.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> squadit = Squad.getSquads();
            model.put("squads", squadit);
            return new ModelAndView(model, "/squadForm.hbs");
        }, new HandlebarsTemplateEngine());
        get("squadit/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("heroes-in-squad",squad.getHeroes());
            return new ModelAndView(model, "/squadDetails.hbs");
        }, new HandlebarsTemplateEngine());
        get("heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", Squad.getSquads());
            return new ModelAndView(model, "/createhero.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = request.session().attribute("heroes");
            if (heroes == null) {
                heroes = new ArrayList<Hero>();
                request.session().attribute("heroes", heroes);
            }
            Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newhero = new Hero(name,age,power,weakness,squad.getId());
            heroes.add(newhero);
            return new ModelAndView(model, "/heroCreated.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads",Squad.getSquads());
            return new ModelAndView(model, "/createhero.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "/heroes.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Hero hero = Hero.findHero(Integer.parseInt(request.params(":id")));
            Squad squad = Squad.find(hero.getSquadId());
            model.put("hero", hero);
            model.put("squad",squad);
            return new ModelAndView(model, "/hero.hbs");
        }, new HandlebarsTemplateEngine());



    }
}