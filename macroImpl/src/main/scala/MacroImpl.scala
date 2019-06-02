import scala.language.higherKinds
import scala.reflect.macros.blackbox
object MacroImpl {
  def liftImpl[F[_], A](c: blackbox.Context)(a: c.Tree)(implicit tt: c.WeakTypeTag[F[_]]): c.Tree = {
    import c.universe._
    q"$a.pure[${tt.tpe.typeConstructor}]"
  }
}
