package controllers;

import models.entity.Gyudon;
import models.form.GyudonForm;
//import models.repository.GyudonRepository;
import play.data.Form;
import play.db.jpa.Transactional;
import play.db.jpa.JPA;
import play.mvc.*;

import views.html.*;

import java.util.Date;

import static play.data.Form.form;


public class Application extends Controller {

	//@Transactional(value="default",readOnly=true)
	@Transactional(value = "default")
	public static Result index() {
		Gyudon firstGyudon = JPA.em().find(Gyudon.class, 1L);
		if(firstGyudon == null){
			Gyudon gyudon = new Gyudon();
			gyudon.id = 1L;
			//gyudon.id = GyudonRepository.getMaxId().getId() + 1L;
			gyudon.name = "hogehuga";
			gyudon.create_at = new Date();
			gyudon.update_at = new Date();
			JPA.em().persist(gyudon);
			firstGyudon = gyudon;
		}
		System.out.println(firstGyudon.getId() + ":" + firstGyudon.getName() + ":" + firstGyudon.getUpdate_at());

		//firstGyudon.name = "betumei";
		//JPA.em().persist(firstGyudon);

		//JPA.em().remove(firstGyudon);

		//List<Gyudon> gyudons = (List<Gyudon>) GyudonRepository.findById(0L);

		return ok(index.render(firstGyudon.getId() + ":" + firstGyudon.getName() + ":" + firstGyudon.getUpdate_at(), form(GyudonForm.class)));
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
				gyudon.create_at = new Date();
				gyudon.update_at = new Date();
				JPA.em().persist(gyudon);
			}else if (data.action.equals("update")){
				Gyudon gyudon = JPA.em().find(Gyudon.class, data.id);
				gyudon.name = data.name;
				gyudon.update_at = new Date();
				JPA.em().merge(gyudon);
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
