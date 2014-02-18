package controllers;

import java.util.Map;

import play.*;
import play.libs.Json;
import play.mvc.*;
import views.html.*;
import models.*;

public class Application extends Controller {

    public static Result index() {
        return redirect(routes.Application.apiHome()); //Type-safe redirect to API home
    }

    
    
    public static Result auth(String method) {
      return ok(Json.toJson(new APIMessage("Authentication method: " + method)));
    }

    public static Result login() {
      //could also use session();
      Map<String, String[]> parsed = request().body().asFormUrlEncoded();
      String username = parsed.get("username")[0]; //fails if nothing is set but...
      String password = parsed.get("password")[0];
      return ok(Json.toJson(new APIMessage("login: " + username + " and *****")));
    }
    
    
    public static Result logout() {
      return ok(Json.toJson(new APIMessage("logged out!")));
    }
    
    public static Result apiHome() {
      return ok(views.html.index.render());
    }
}
