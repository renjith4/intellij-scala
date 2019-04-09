package org.jetbrains.plugins.scala
package lang
package psi
package impl
package expr

import com.intellij.lang.ASTNode
import org.jetbrains.plugins.scala.lang.psi.api.expr.ScUnitExpr
import org.jetbrains.plugins.scala.lang.psi.controlFlow.impl.expr.ScUnitExprCfgBuildingImpl
import org.jetbrains.plugins.scala.lang.psi.types.api.Unit
import org.jetbrains.plugins.scala.lang.psi.types.result._

/**
* @author ilyas, Alexander Podkhalyuzin
*/
class ScUnitExprImpl(node: ASTNode) extends ScExpressionImplBase(node) with ScUnitExpr with ScUnitExprCfgBuildingImpl {
  protected override def innerType: TypeResult = Right(Unit)

  override def toString: String = "UnitExpression"
}