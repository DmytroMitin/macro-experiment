import cats.syntax.applicative._
import cats.instances.list._
import cats.instances.either._

import scala.language.reflectiveCalls

object Main {
  def main(args: Array[String]): Unit = {
    println(
      Macros.lift[({type F[A] = Either[String, A]})#F](42)
    )
  }
}
