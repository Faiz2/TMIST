package controllers

import play.api.mvc._

class TmistController() extends Controller {
	def index() = Action {
		Ok(views.html.index())
	}
}