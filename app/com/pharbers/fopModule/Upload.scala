package com.pharbers.fopModule

import java.io.File
import java.util.UUID

import com.pharbers.ErrorCode.errorToJson
import play.api.libs.Files.TemporaryFile
import play.api.libs.json.JsValue
import play.api.libs.json.Json.toJson
import play.api.mvc.MultipartFormData
import com.pharbers.common.algorithm.{alTempLog, max_path_obj}

object Upload {
	def uploadFile(data: MultipartFormData[TemporaryFile]): JsValue = {
		try {
			val lst = data.files.map { file =>
				val uuid = UUID.randomUUID
				val path = max_path_obj.p_clientPath
//				new TemporaryFile(file.ref.file).moveTo(new File(s"$path/$uuid"), replace = true)
				file.ref.moveTo(new File(s"$path/$uuid"), replace = true)
				uuid
			}
			alTempLog(s"上传文件，md5 = " + lst)
			toJson(Map("status" -> toJson("ok"), "result" -> toJson(lst)))
		} catch {
			case _: Exception =>
				alTempLog(errorToJson("upload error").toString)
				errorToJson("upload error")
		}
	}
}
