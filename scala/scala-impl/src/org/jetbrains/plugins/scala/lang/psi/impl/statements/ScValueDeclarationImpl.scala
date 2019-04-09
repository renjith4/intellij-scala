package org.jetbrains.plugins.scala
package lang
package psi
package impl
package statements

import com.intellij.lang.ASTNode
import org.jetbrains.plugins.scala.extensions.ifReadAllowed
import org.jetbrains.plugins.scala.lang.parser.ScalaElementType
import org.jetbrains.plugins.scala.lang.psi.api.ScalaElementVisitor
import org.jetbrains.plugins.scala.lang.psi.api.base._
import org.jetbrains.plugins.scala.lang.psi.api.base.types.ScTypeElement
import org.jetbrains.plugins.scala.lang.psi.api.statements._
import org.jetbrains.plugins.scala.lang.psi.controlFlow.impl.statements.ScValueDeclarationCfgBuildingImpl
import org.jetbrains.plugins.scala.lang.psi.stubs.ScPropertyStub
import org.jetbrains.plugins.scala.lang.psi.stubs.elements.ScPropertyElementType
import org.jetbrains.plugins.scala.lang.psi.types.result._

/**
 * @author Alexander Podkhalyuzin
 * Date: 22.02.2008
 * Time: 9:55:28
 */
final class ScValueDeclarationImpl private[psi](stub: ScPropertyStub[ScValueDeclaration],
                                                nodeType: ScPropertyElementType[ScValueDeclaration],
                                                node: ASTNode)
  extends ScalaStubBasedElementImpl(stub, nodeType, node)
    with ScValueDeclaration with ScValueDeclarationCfgBuildingImpl {

  override def toString: String = "ScValueDeclaration: " + ifReadAllowed(declaredNames.mkString(", "))("")

  def declaredElements: Seq[ScFieldId] = getIdList.fieldIds

  override def `type`(): TypeResult = typeElement match {
    case Some(te) => te.`type`()
    case None => Failure(ScalaBundle.message("no.type.element.found", getText))
  }

  def typeElement: Option[ScTypeElement] = byPsiOrStub(findChild(classOf[ScTypeElement]))(_.typeElement)

  def getIdList: ScIdList = getStubOrPsiChild(ScalaElementType.IDENTIFIER_LIST)

  override protected def acceptScala(visitor: ScalaElementVisitor) {
    visitor.visitValueDeclaration(this)
  }
}