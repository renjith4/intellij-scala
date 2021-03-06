package org.jetbrains.plugins.scala
package codeInsight
package template
package macros

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.template._

/**
 * @author Roman.Shein
 * @since 22.09.2015.
 */
final class ScalaExpressionTypeMacro extends ScalaMacro {

  override def calculateResult(params: Array[Expression], context: ExpressionContext): Result = params match {
    case Array(head) =>
      resultToScExpr(head.calculateResult(context))(context)
        .map(ScalaTypeResult)
        .orNull
    case _ => null
  }

  override def getPresentableName: String = CodeInsightBundle.message("macro.expression.type")
}
