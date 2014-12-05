package controllers;

import models.entity.Gyudon;
import models.entity.Menu;
import models.entity.Size;
import models.entity.Topping;
import models.form.GyudonForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import models.form.MenuForm;

import java.util.Date;

import static play.data.Form.form;
import static play.db.jpa.JPA.em;

/**
 * Created by uhu on 2014/12/05.
 */
public class MenuController extends Controller {
    public static Result index(){
        return ok(views.html.menu.render("", form(MenuForm.class)));
    }

    @Transactional(value = "default")
    public static Result create(){
        // TODO:サイズとトッピングはマスターとして入れて選択できるようにする
        // TODO:サイズとトッピングは参照キーにする
        Form<MenuForm> f = form(MenuForm.class).bindFromRequest();
        MenuForm data = f.get();
        Menu menu = new Menu();
        menu.name = data.name;
        menu.create_at = new Date();
        em().persist(menu);

        Size size = new Size();
        size.name = data.size;
        size.create_at = new Date();
        em().persist(size);

        Topping topping = new Topping();
        topping.name = data.topping;
        topping.create_at = new Date();
        em().persist(topping);
        return ok(views.html.menu.render("", f));

    }
}
