package controllers.upload

import javax.inject.Inject

import akka.actor.ActorSystem
import com.pharbers.fopModule.Upload
import controllers.common.requestArgsQuery
import play.api.mvc.{AbstractController, ControllerComponents}

class FopController @Inject()(implicit as_inject: ActorSystem, cc: ControllerComponents) extends AbstractController(cc) {
	
	def uploadFile = Action { request =>
		requestArgsQuery().uploadRequestArgs(request)(Upload.uploadFile)
	}
	
}
