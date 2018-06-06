package controllers

import javax.inject.Inject

import play.api.mvc._

class TmistController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
	def index() = Action {
		Ok(views.html.index())
	}
	
}