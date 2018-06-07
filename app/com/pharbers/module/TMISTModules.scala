package com.pharbers.module

import play.api.{Configuration, Environment}
import play.api.inject.{Binding, Module}
import com.pharbers.dbManagerTrait.dbInstanceManager
import com.pharbers.token.AuthTokenTrait

class TMISTModules extends Module{
	override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = {
		Seq(
			bind[dbInstanceManager].to[DBManagerModule],
			bind[AuthTokenTrait].to[TokenInjectModule]
		)
	}
}
