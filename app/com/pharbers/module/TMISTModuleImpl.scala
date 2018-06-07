package com.pharbers.module

import javax.inject.Singleton
import com.pharbers.dbManagerTrait.dbInstanceManager
import com.pharbers.token.tokenImpl.TokenImplTrait

@Singleton
class DBManagerModule extends dbInstanceManager

@Singleton
class TokenInjectModule extends TokenImplTrait

