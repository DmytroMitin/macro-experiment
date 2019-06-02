import scala.language.experimental.macros
import cats.implicits._

import scala.language.higherKinds

object Macros {
  class LiftPartiallyApplied[F[_]] {
    def apply[A](a: A): F[A] = macro MacroImpl.liftImpl[F, A]
  }

  def lift[F[_]] = new LiftPartiallyApplied[F]
}
