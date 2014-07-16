import play.api.Play
import scala.util.{Success, Try}

package object app {
  object ConfigProperties  {
    def getProperty(property:String,default:Int) = Try(Play.current.configuration.getInt(property).getOrElse(default)) match { case Success(s) => s case _ => default}
    def getProperty(property:String,default:String) = Try(Play.current.configuration.getString(property).getOrElse(default)) match { case Success(s) => s case _ => default}
    def getProperty(property:String,default:Boolean) = Try(Play.current.configuration.getBoolean(property).getOrElse(default)) match { case Success(s) => s case _ => default}
    def getProperty(property:String,default:Long) = Try(Play.current.configuration.getLong(property).getOrElse(default)) match { case Success(s) => s case _ => default}
  }
}