package controllers.common

import javax.inject.Inject

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.pharbers.bmmessages.{MessageRoutes, excute}
import com.pharbers.bmpattern.RoutesActor
import play.api.libs.Files.TemporaryFile
import play.api.libs.json.JsValue
import play.api.mvc._

import scala.concurrent.Await
import scala.concurrent.duration._

object requestArgsQuery {
	def apply()(implicit akkasys : ActorSystem, cc: ControllerComponents) = new requestArgsQuery()
}

class requestArgsQuery @Inject() (implicit akkasys : ActorSystem, cc: ControllerComponents) extends AbstractController(cc) {
	implicit val t = Timeout(60 second)

	def requestArgs(request : Request[AnyContent])(func : JsValue => MessageRoutes) : Result = {
		try {
			request.body.asJson.map { x =>
				Ok(commonExcution(func(x)))
			}.getOrElse (BadRequest("Bad Request for input"))
		} catch {
			case _ : Exception => BadRequest("Bad Request for input")
		}
	}

	def commonExcution(msr : MessageRoutes) : JsValue = {
		val act = akkasys.actorOf(Props[RoutesActor])
		val r = act ? excute(msr)
		Await.result(r.mapTo[JsValue], t.duration)
	}

	def uploadRequestArgs(request : Request[AnyContent])(func : MultipartFormData[TemporaryFile] => JsValue) : Result = {
		try {
			request.body.asMultipartFormData.map { x =>
				Ok(func(x))
			}.getOrElse (BadRequest("Bad Request for input"))
		} catch {
			case _ : Exception => BadRequest("Bad Request for input")
		}
	}
}