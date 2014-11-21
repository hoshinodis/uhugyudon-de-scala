package controllers;

import models.entity.Gyudon;
import play.db.jpa.Transactional;
import play.db.jpa.JPA;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	//@Transactional(value="default",readOnly=true)
	@Transactional(value = "default")
    public static Result index() {
    	Gyudon gyudon = new Gyudon();
		gyudon.id = Long.valueOf(1);
	    gyudon.name = "hoge";
		gyudon.resister_dt = "2014/11/21";
	    JPA.em().persist(gyudon);

		Gyudon firstGyudon = JPA.em().find(Gyudon.class, 1L);
	    System.out.println(firstGyudon.id + ":" + firstGyudon.name + ":" + firstGyudon.resister_dt);
        return ok(index.render("Your new application is ready."));
    }

}
