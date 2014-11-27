package controllers;

import models.entity.Gyudon;
import models.repository.GyudonRepository;
import play.db.jpa.Transactional;
import play.db.jpa.JPA;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

	//@Transactional(value="default",readOnly=true)
	@Transactional(value = "default")
    public static Result index() {
		Gyudon firstGyudon = JPA.em().find(Gyudon.class, 1L);
		if(firstGyudon == null){
			Gyudon gyudon = new Gyudon();
			gyudon.id = Long.valueOf(1);
			gyudon.name = "hogehuga";
			gyudon.resister_dt = "2014/12/21";
			JPA.em().persist(gyudon);
			firstGyudon = gyudon;
		}
	    System.out.println(firstGyudon.id + ":" + firstGyudon.name + ":" + firstGyudon.resister_dt);

		//firstGyudon.name = "betumei";
		//JPA.em().persist(firstGyudon);

		//JPA.em().remove(firstGyudon);

		//List<Gyudon> gyudons = (List<Gyudon>) GyudonRepository.findById(0L);

        return ok(index.render(firstGyudon.id + ":" + firstGyudon.name + ":" + firstGyudon.resister_dt));
		//return ok(index.render("Your new application is ready."));
    }

	@Transactional(value = "default")
	public static Result dinner() {
		return ok(index.render("Your new application is ready."));
	}

}
