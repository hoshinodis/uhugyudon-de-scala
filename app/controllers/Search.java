package controllers;

import models.entity.Gyudon;
import models.form.SearchForm;
import models.repository.GyudonRepository;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.search;

import javax.persistence.*;
import java.util.List;

import static play.data.Form.form;

/**
 * Created by uhu on 2014/12/04.
 */
public class Search extends Controller {

    @Transactional(value="default")
    public static Result index() {
        Form<SearchForm> sf = form(SearchForm.class).bindFromRequest();
        String searchName = sf.get().searchString;
        System.out.println(searchName);
        if (searchName != null && !searchName.isEmpty()) {
            GyudonRepository repo = new GyudonRepository();
            List<Gyudon> gList = repo.findByName(searchName);
            if (gList.size() > 0) {
                System.out.println(gList.get(0).getName());
            }else{
                System.out.println("ない");
            }
            System.out.println(repo.findMaxId().getName());
        }
        return ok(search.render("", sf));
    }
}

