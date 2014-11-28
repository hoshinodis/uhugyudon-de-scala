package controllers;

import models.entity.Gyudon;
import models.repository.GyudonRepository;
import play.data.Form;
import play.db.jpa.Transactional;
import play.db.jpa.JPA;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.data.Form.form;


public class Application extends Controller {
	public static class GyudonForm {
		public Long id;
		public String name;
		public String action;
	}

	//@Transactional(value="default",readOnly=true)
	@Transactional(value = "default")
    public static Result index() {
		Gyudon firstGyudon = JPA.em().find(Gyudon.class, 1L);
		if(firstGyudon == null){
			Gyudon gyudon = new Gyudon();
			gyudon.id = Long.valueOf(1);
			//gyudon.id = GyudonRepository.getMaxId().getId() + 1L;
			gyudon.name = "hogehuga";
			gyudon.resister_dt = "2014/12/21";
			JPA.em().persist(gyudon);
			firstGyudon = gyudon;
		}
	    System.out.println(firstGyudon.getId() + ":" + firstGyudon.getName() + ":" + firstGyudon.getResister_dt());

		//firstGyudon.name = "betumei";
		//JPA.em().persist(firstGyudon);

		//JPA.em().remove(firstGyudon);

		//List<Gyudon> gyudons = (List<Gyudon>) GyudonRepository.findById(0L);

        return ok(index.render(firstGyudon.getId() + ":" + firstGyudon.getName() + ":" + firstGyudon.getResister_dt(), form(GyudonForm.class)));
    }

	@Transactional(value = "default")
	public static Result send() {
		Form<GyudonForm> f = form(GyudonForm.class).bindFromRequest();
		if (!f.hasErrors()) {
			GyudonForm data = f.get();
			if (data.action.equals("insert")){
				Gyudon gyudon = new Gyudon();
				gyudon.id = data.id;
				//gyudon.id = GyudonRepository.getMaxId().getId() + 1L;
				gyudon.name = data.name;
				gyudon.resister_dt = "2014/12/21";
				JPA.em().persist(gyudon);
			}else if (data.action.equals("update")){
				Gyudon gyudon = JPA.em().find(Gyudon.class, data.id);
				gyudon.name = data.name;
				JPA.em().persist(gyudon);
			}else if (data.action.equals("delete")){
				Gyudon gyudon = JPA.em().find(Gyudon.class, data.id);
				JPA.em().remove(gyudon);
			}

			String msg = "you gyudoned: " + data.name + "さんがチーズ牛丼中盛りツユダクを" + data.action;
			return ok(index.render(msg, f));
		}else{
			return badRequest(index.render("ERRER", form(GyudonForm.class)));
		}
	}

}
