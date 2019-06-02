import scala.language.experimental.macros
import cats.implicits._

object Macros {
  class LiftPartiallyApplied[F[_]] {
    def apply[A](a: A): F[A] = macro MacroImpl.liftImpl[F, A]
  }

  def lift[F[_]] = new LiftPartiallyApplied[F]
}

object Main {
  def main(args: Array[String]): Unit = {
    Macros.lift[({type F[A] = Either[String, A]})#F](42)
  }
}
